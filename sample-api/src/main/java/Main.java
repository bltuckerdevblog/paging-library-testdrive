import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import spark.Spark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String> names = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

      initializeNames();
      initializeProducts();

        Spark.get("/names", (request, response) ->{

            String afterNameArg = request.queryParams("after");
            int limitArg = Integer.parseInt(request.queryParams("limit"));

          int indexOfNameArg = names.indexOf(afterNameArg);

          if(indexOfNameArg == -1){
            indexOfNameArg = 0;
          }

          List<String> responseList = names.stream()
              .skip(indexOfNameArg + 1)
              .limit(limitArg)
              .collect(Collectors.toList());
//              .collect(Collectors.joining("\",\"", "\"", "\""));

          JsonArray jsonArray = new JsonArray();

          responseList.forEach(name -> jsonArray.add(name));

          return jsonArray;

        });

        Spark.get("/products", (request, response) -> {

          String searchTerm = request.queryParams("searchTerm");
          int requestedPage = Integer.parseInt(request.queryParams("page"));


          List<Product> filteredProducts = products.stream()
              .filter(product -> product.name.toLowerCase().contains(searchTerm.toLowerCase()))
              .collect(Collectors.toList());

          int totalPages = (filteredProducts.size() / 10) + 1;

          if(requestedPage > totalPages){
            requestedPage = totalPages;
          }


        //determine what the page looks like from here
          int firstResult = (requestedPage - 1) * 10;
          int lastResult = Math.min(firstResult + 10, filteredProducts.size());


          String previousPageUrl = "";
          if(requestedPage != 1){
             previousPageUrl = "http://" + request.host() + "/products?searchTerm=" + searchTerm +"&page=" + (requestedPage -1);
          }

          String nextPageUrl = "";
          if(requestedPage != totalPages){
            nextPageUrl = "http://" + request.host() + "/products?searchTerm=" + searchTerm +"&page=" + (requestedPage +1);
          }

          SearchResponseMeta searchResponseMeta = new SearchResponseMeta(previousPageUrl,
              nextPageUrl,
              totalPages,
              requestedPage);

          SearchResponse searchResponse = new SearchResponse(searchResponseMeta, filteredProducts.subList(
              firstResult, lastResult));

          return gson.toJson(searchResponse);

        });


    }

  private static void initializeProducts() {
    try{
      File namesFile = new File(Main.class.getResource("fake_products.json").getFile());
      FileReader fileReader = new FileReader(namesFile);
      Product[] productsArray = gson.fromJson(fileReader, Product[].class);
      products.addAll(Arrays.asList(productsArray));
      System.out.println("Products size == " + products.size());
    } catch(Exception ex){
      //ignored
    }

  }

  private static void initializeNames() {
      try{
        File namesFile = new File(Main.class.getResource("fake_names.csv").getFile());
        names.addAll(Files.readAllLines(Paths.get(namesFile.toURI())));
        Collections.sort(names);
        System.out.println("names.size == " + names.size());
      } catch(Exception ex){
        //ignored
      }
  }
}

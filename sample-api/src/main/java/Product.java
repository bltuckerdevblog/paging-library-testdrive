import com.google.gson.annotations.SerializedName;

public class Product {

  @SerializedName("product_name")
  public final String name;

  @SerializedName("price")
  public final String price;

  @SerializedName("id")
  public final String id;

  public Product(String name, String price, String id){
    this.name = name;
    this.price = price;
    this.id = id;
  }

}

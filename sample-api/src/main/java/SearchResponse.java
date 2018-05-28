import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchResponse {

  @SerializedName("meta")
  public SearchResponseMeta meta;

  @SerializedName("products")
  public final List<Product> products;

  public SearchResponse(SearchResponseMeta meta,
      List<Product> products){
    this.meta = meta;
    this.products = products;
  }
}

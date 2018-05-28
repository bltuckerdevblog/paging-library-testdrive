import com.google.gson.annotations.SerializedName;

public class SearchResponseMeta {

  @SerializedName("previousPageUrl")
  public final String previousPageUrl;

  @SerializedName("nextPageUrl")
  public final String nextPageUrl;

  @SerializedName("totalPages")
  public final int totalPages;

  @SerializedName("currentPage")
  public final int currentPage;

  public SearchResponseMeta(String previousPageUrl,
      String nextPageUrl,
      int totalPages,
      int currentPage){
    this.totalPages = totalPages;
    this.currentPage = currentPage;
    this.previousPageUrl = previousPageUrl;
    this.nextPageUrl = nextPageUrl;
  }

}

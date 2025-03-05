package core;
import io.restassured.http.ContentType;

public interface ConstantsConfiguration {

    //public String API_BASE_URL = "https://api-loja-de-livro.onrender.com";
    public String API_BASE_URL = "http://localhost:8080";

    //public String API_BASE_URL = null;
    public Integer API_PORT = 443;
    public String API_BASE_PATH = "";
    public ContentType API_CONTENT_TYPE = ContentType.JSON;
    public Long MAX_TIMEOUT = 5000L;

}

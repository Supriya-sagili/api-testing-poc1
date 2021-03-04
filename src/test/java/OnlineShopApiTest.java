import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import petclinic.api.onlineShop.data.OnlineShopApiClient;
import petclinic.api.onlineShop.data.Response;

public class OnlineShopApiTest {
    static String apiUrl;
    SoftAssertions softly = new SoftAssertions();

    @BeforeAll
    static void getApiUrl() {
        apiUrl = System.getProperty("apiUrl");
    }

    @Test
    public void getProducts() throws Exception {
        OnlineShopApiClient client = new OnlineShopApiClient(apiUrl, "/api/shop/getproducts");
        int statusCode = client.getProductsStatusCode();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(statusCode).isEqualTo(200);
        //softly.assertAll();
        System.out.println("Status Code is: " + statusCode);

    }

    @Test
    public void getProducts_List1() throws InvalidResponseException {
        OnlineShopApiClient client = new OnlineShopApiClient(apiUrl, "/api/shop/getproducts");
        Response[] cartproducts = client.getProducts_List();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(cartproducts[1].getName()).isEqualTo("Velcote Liquid");
        softly.assertThat(cartproducts[1].getId()).isEqualTo("2");
        softly.assertThat(cartproducts[1].getAmount()).isEqualTo("318.00");
        softly.assertThat(cartproducts[1].getCurrency()).isEqualTo("$");
        softly.assertAll();
        System.out.println("Available product details at Index 2" + cartproducts[1]);
    }

    @Test
    public void getProducts_Count() throws InvalidResponseException {
        OnlineShopApiClient client = new OnlineShopApiClient(apiUrl, "/api/shop/getproducts");
        int productsCount = client.getProductsCount();
        System.out.println("Available products count : " + productsCount);

    }

    @Test
    public void createAddProducts_Cart() throws InvalidResponseException {
        OnlineShopApiClient client = new OnlineShopApiClient(apiUrl, "/api/shop/addtocart");
        Response response1 = client.createAddItemsToCart(Response.builder()
                .amount("100.00")
                .currency("$")
                .id("24")
                .name("ball")
                .build());
        softly.assertThat(response1.getAmount()).isEqualTo("100.00");
        softly.assertThat(response1.getCurrency()).isEqualTo("$");
        softly.assertThat(response1.getName()).isEqualTo("ball");
        softly.assertThat(response1.getId()).isNotEmpty();
        softly.assertAll();

    }
   /* @Test
    public void deleteProductsFrom_CartThroughID() throws InvalidResponseException{
        OnlineShopApiClient client = new OnlineShopApiClient(apiUrl, "/api/shop/clearcart");
        Response createdProduct = client.createAddItemsToCart(Response.builder()
                .name("Pen")
                .id("12")
                .currency("$")
                .amount("100.00")
                .build());
        //System.out.println("Available products count : "+ response);
        softly.assertThat(deleteProductsFrom_CartThroughID().getHttpStatusCode()).as("The Status code is :").isEqualTo(200);
        softly.assertAll();


    }*/
//Delete Product
 @Test
    public void deleteNewOwners_throughID_ShouldDisplayDeletedId() throws InvalidResponseException {
        //create a new product
       /* OnlineShopApiClient client = new OnlineShopApiClient(apiUrl, "/api/shop/addtocart/");
        Response response = client.createAddItemsToCart(Response.builder()
                .name("Pen")
                .amount("100.00")
                .currency("$")
                .id("12")
                .build());*/
        //delete the created product
        OnlineShopApiClient client1 = new OnlineShopApiClient(apiUrl, "/api/shop/clearcart" );
         ApiResponse<Response[]> deletedProduct = client1.deleteProducts();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(deletedProduct.getHttpStatusCode()).as("The Status code is :").isEqualTo(200);
        softly.assertAll();
    }
}


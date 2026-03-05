package hooks;

import io.restassured.RestAssured;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        //Base URL for API calls
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
}

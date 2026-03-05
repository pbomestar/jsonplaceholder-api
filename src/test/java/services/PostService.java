package services;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PostService {
    public Response getAllPosts(){
        return given()
                .when()
                .get("/posts")
                .then()
                .extract().response();
    }

    public Response getPostById(int id){
        return given()
                .when()
                .get("/posts/" + id)
                .then()
                .extract().response();
    }

    public Response getPostComments(int id){
        return given()
                .when()
                .get("/posts/" + id + "/comments")
                .then()
                .extract().response();
    }

    public Response createPost(String title, String body, int userId){
        String jsonBody = String.format("{\"title\":\"%s\",\"body\":\"%s\",\"userId\":%d}", title, body, userId);
        return given()
                .header("Content-type", "application/json")
                .body(jsonBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();
    }



}
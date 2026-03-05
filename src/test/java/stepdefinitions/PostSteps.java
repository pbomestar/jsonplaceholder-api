package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import services.PostService;
import static org.junit.Assert.assertEquals;


public class PostSteps {

    PostService postService = new PostService();
    Response response;

    @When("I request all posts")
    public void i_request_all_posts(){
        response = postService.getAllPosts();
    }
    @Then("I receive status code {int}")
    public void i_receive_status_code(int code){
        assertEquals(code, response.getStatusCode());
    }

    @When("I request post with ID = {int}")
    public void i_request_post_with_id(int id){
        response = postService.getPostById(id);
    }
    @When("I request comments for post ID = {int}")
    public void i_request_comments_for_post(int id){
        response = postService.getPostComments(id);
    }

    @When("I create a post with title {string} and body {string} for user {int}")
    public void i_create_new_post(String title, String body, Integer userId){
        response = postService.createPost(title, body, userId);
    }

    @And("the response title is {string}")
    public void response_title_is(String responseTitle){
        assertEquals(responseTitle, response.jsonPath().getString("title"));
    }
}

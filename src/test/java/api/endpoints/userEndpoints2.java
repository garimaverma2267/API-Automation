package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;
// Crud Operation 

public class userEndpoints2 {

	// Loading properties files

	static ResourceBundle getUrl() { // userdefined methods creating for getting url from propertis file
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // will load properties file
		return routes;
	}

	// Create user
	public static Response createUser(User payload) {
		String post_url = getUrl().getString("post_url");
		Response res = given().contentType("application/json").body(payload)

				.when().post(post_url);

		return res;
	}

//	 get user
	public static Response getUser(String name) {
		String get_url = getUrl().getString("get_url");
		Response res = given().pathParam("username", name)

				.when().get(get_url);

		return res;
	}

	// update user
	public static Response updateUser(String name, User payload) {
		String update_url = getUrl().getString("update_url");
		Response res = given().contentType("application/json").body(payload).pathParam("username", name)

				.when().put(update_url);

		return res;
	}

//
//	// delete user
	public static Response deleteUser(String name) {
		String delete_url = getUrl().getString("delete_url");
		Response res = given().pathParam("username", name)

				.when().delete(delete_url);

		return res;
	}
}

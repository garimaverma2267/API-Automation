package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.response.Response;
// Crud Operation 

public class userEndpoints {
	// Create user
	public static Response createUser(User payload) {
		Response res = given().contentType("application/json").body(payload)

				.when().post(Routes.post_url);

		return res;
	}

//	 get user
	public static Response getUser(String name) {
		Response res = given().pathParam("username", name)

				.when().get(Routes.get_url);

		return res;
	}

	// update user
	public static Response updateUser(String name, User payload) {
		Response res = given().contentType("application/json").body(payload).pathParam("username", name)

				.when().put(Routes.update_url);

		return res;
	}

//
//	// delete user
	public static Response deleteUser(String name) {
		Response res = given().pathParam("username", name)

				.when().delete(Routes.delete_url);

		return res;
	}
}

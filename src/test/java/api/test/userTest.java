package api.test;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndpoints;
import api.payload.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class userTest {

	Faker fakedata;
	User userpayload;

	@BeforeClass
	public void setupData() {

		fakedata = new Faker();
		userpayload = new User();

		userpayload.setId(fakedata.number().randomDigit());
		userpayload.setUsername(fakedata.name().username());
		userpayload.setFirstname(fakedata.name().firstName());
		userpayload.setLastname(fakedata.name().lastName());
		userpayload.setEmail(fakedata.internet().emailAddress());
		userpayload.setPassword(fakedata.internet().password());
		userpayload.setPhone(fakedata.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void createUser() {

		Response res = userEndpoints.createUser(userpayload);
		res.then().statusCode(200).log().all();
		System.out.println("Create user");
		System.out.println("username" + userpayload.getUsername());
	}

	@Test(priority = 2)
	public void getUser() {

		Response res = userEndpoints.getUser(userpayload.getUsername());
		res.then().statusCode(200).log().all();
		System.out.println("get user");
		System.out.println("username" + userpayload.getUsername());
	}

	@Test(priority = 3)
	public void updateUser() {
		userpayload.setEmail("garima22@gmail.com");
		Response res = userEndpoints.updateUser(userpayload.getUsername(), userpayload);
		res.then().statusCode(200).log().all();
		System.out.println("update user");
		System.out.println("updated email" + userpayload.getEmail());
	}

	@Test(priority = 4)
	public void deleteUser() {

		Response res = userEndpoints.deleteUser(userpayload.getUsername());
		res.then().statusCode(200).log().all();
		System.out.println("Delete user");
		System.out.println("username" + userpayload.getUsername());
	}

}

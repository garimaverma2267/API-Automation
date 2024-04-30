package api.endpoints;

/*
Swagger URL -- https://petstore.swagger.io/	
	
Create user (Post) -- https://petstore.swagger.io/v2/user
get user (Get) -- https://petstore.swagger.io/v2/user/{username}
update user (Put) -- https://petstore.swagger.io/v2/user/{username}
delete user (Delete ) -- https://petstore.swagger.io/v2/user/{username}
	
*/

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2/";

	// User models

	public static String post_url = base_url + "user";

	public static String get_url = base_url + "user/{username}";

	public static String update_url = base_url + "user/{username}";

	public static String delete_url = base_url + "user/{username}";

	// store module

	// pet module

	// etc
}

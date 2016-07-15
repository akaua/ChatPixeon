package controllers;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import model.UserTest;
import play.cache.Cache;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;


public class ChatControllerApplication extends Controller{
	
	private static final String cacheConstantUser = "LastUserLogin";
	private static final String cacheConstantGroup = "GroupUserLogin";
//	private Cache cache;
	
	
	 public static Result index() {
		 	JsonNode json = Json.parse("{\"firstName\":\"Foo\", \"lastName\":\"Bar\", \"age\":13}");
		 	session().put("IdUserGoogle", "AKAUA!!!!!!!!!!!!");
		 	String jsonString = json.toString();
		 	System.out.println(jsonString);
		 	System.out.println(session().get(cacheConstantUser));
		 	System.out.println(session().get(cacheConstantUser));
		 	System.out.println(session().get("IdUserGoogle"));
		 	//JsonNode jsonResponse = Json.parse(session().get("IdUserGoogle"));
		 	//Http.Context.current()
	        return ok(json);//ok(index.render("Your new application is ready."));
	    }
	 
	 @BodyParser.Of(BodyParser.Json.class)
	 public static Result login(){
		 try {
			 response().setHeader("Access-Control-Allow-Origin", "*");
			 
			 JsonNode jsonUserLogin = request().body().asJson();
			 UserTest userLogin = Json.fromJson(jsonUserLogin, UserTest.class);
			 List<UserTest> listUsers;

			 if(Cache.get(cacheConstantGroup) != null){
				 listUsers = (ArrayList<UserTest>) Cache.get(cacheConstantGroup);
			 }else{
				 listUsers = new ArrayList<UserTest>();
			 }
			 
			 listUsers.add(userLogin);
			 Cache.set(cacheConstantGroup, listUsers);
			 Cache.set(cacheConstantUser, jsonUserLogin);
//			 JsonNode jsonCached = (JsonNode) Cache.get(cacheConstantUser);			 
			 return ok(jsonUserLogin);
		} catch (Exception e) {
			e.printStackTrace();
            return badRequest("Missing information");
		}
		 
	 }
	 
	 public static Result checkPreFlight() {
		    response().setHeader("Access-Control-Allow-Origin", "*");
		    response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		    response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");  
		    return ok();
		}
	 
	 public static Result getUser(){
		 response().setHeader("Access-Control-Allow-Origin", "*"); 
		 JsonNode jsonUser = (JsonNode) Cache.get(cacheConstantUser);
		 System.out.println(Cache.get(cacheConstantUser));
		 return ok(jsonUser);
	 }
	 
	 @BodyParser.Of(BodyParser.Json.class)
	 public static Result logaut(){
		 try {
			 response().setHeader("Access-Control-Allow-Origin", "*");
		     
			 
			 System.out.println(request().body().asJson());
			 
			 JsonNode jsonUserLogin = request().body().asJson();
			 UserTest userLogaut = Json.fromJson(jsonUserLogin, UserTest.class);
			 List<UserTest> listUsers = (ArrayList<UserTest>) Cache.get(cacheConstantGroup);
//			 listUsers.forEach(user -> {
//				 if(user.givenName.equals(userLogaut.givenName)){
//					 user = null;
//				 }				 
//			 });			
			 int indexUser = 0;
			 for (UserTest userTest : listUsers) {
				if(userTest.id.equals(userLogaut.id)){
					break;
				}
				indexUser++;
			}
			 listUsers.remove(indexUser);
			 Cache.set(cacheConstantGroup, listUsers);			 
			 return ok(jsonUserLogin);
		} catch (Exception e) {
			e.printStackTrace();
            return badRequest("Missing information");
		}
	 }
	 
	 public static Result getListUsers(){
		 response().setHeader("Access-Control-Allow-Origin", "*"); 
		 List<UserTest> listUsers = (ArrayList<UserTest>) Cache.get(cacheConstantGroup);
		 JsonNode jsonListUser = Json.toJson(listUsers);
		 System.out.println(jsonListUser);
		 return ok(jsonListUser);
	 }
	 
	 public static Result cleanListUsers(){
		 response().setHeader("Access-Control-Allow-Origin", "*");
		 Cache.set(cacheConstantGroup, new ArrayList<UserTest>());
		 return ok("LIMPO");
	 }
	 


}

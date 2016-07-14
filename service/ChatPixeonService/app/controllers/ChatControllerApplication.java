package controllers;




import com.fasterxml.jackson.databind.JsonNode;

import model.UserTest;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.cache.Cache;


public class ChatControllerApplication extends Controller{
	
	private static final String sessionConstant = "LastUserLogin";
//	private Cache cache;
	
	
	 public static Result index() {
		 	JsonNode json = Json.parse("{\"firstName\":\"Foo\", \"lastName\":\"Bar\", \"age\":13}");
		 	session().put("IdUserGoogle", "AKAUA!!!!!!!!!!!!");
		 	String jsonString = json.toString();
		 	System.out.println(jsonString);
		 	System.out.println(session().get(sessionConstant));
		 	System.out.println(session().get(sessionConstant));
		 	System.out.println(session().get("IdUserGoogle"));
		 	//JsonNode jsonResponse = Json.parse(session().get("IdUserGoogle"));
		 	//Http.Context.current()
	        return ok(json);//ok(index.render("Your new application is ready."));
	    }
	 
	 @BodyParser.Of(BodyParser.Json.class)
	 public static Result login(){
		 try {
			 response().setHeader("Access-Control-Allow-Origin", "*");
		     
			 
			 System.out.println(request().body().asJson());
			 
			 JsonNode jsonUserLogin = request().body().asJson();
			 UserTest userLogin = Json.fromJson(jsonUserLogin, UserTest.class);
			 
			 System.out.println(userLogin.toString());
			 Cache.set(sessionConstant, jsonUserLogin);
			 JsonNode jsonCached = (JsonNode) Cache.get(sessionConstant);
			 System.out.println(jsonCached.toString());
			 
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
		 JsonNode jsonUser = (JsonNode) Cache.get(sessionConstant);
		 System.out.println(Cache.get(sessionConstant));
		 return ok(jsonUser);
	 }
	 
	 @BodyParser.Of(BodyParser.Json.class)
	 public static Result logaut(){
		 try {
			 response().setHeader("Access-Control-Allow-Origin", "*");
		     
			 
			 System.out.println(request().body().asJson());
			 
			 JsonNode jsonUserLogin = request().body().asJson();
			 UserTest userLogin = Json.fromJson(jsonUserLogin, UserTest.class);
			 
			 System.out.println(userLogin.toString());
			 Cache.set(sessionConstant, jsonUserLogin);
			 JsonNode jsonCached = (JsonNode) Cache.get(sessionConstant);
			 System.out.println(jsonCached.toString());
			 
			 return ok(jsonUserLogin);
		} catch (Exception e) {
			e.printStackTrace();
            return badRequest("Missing information");
		}
	 }
	 


}

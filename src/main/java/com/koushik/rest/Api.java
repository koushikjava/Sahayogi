package com.koushik.rest;
 

import DataBaseControler.DataBaseControl;
import DataBaseControler.Dbresponse;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.io.FileInputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
@Path("/hello")
public class Api extends DataBaseControl{
    
    String res="";
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
                
//                try{
//                FileInputStream serviceAccount = new FileInputStream("/home/koushik/NetBeansProjects/sahayogi/src/main/java/com/koushik/rest/sahayogwala.json");
//
//FirebaseOptions options = new FirebaseOptions.Builder()
//  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//  .setDatabaseUrl("https://sahayogwala.firebaseio.com")
//  .build();
//  FirebaseApp defaultApp=FirebaseApp.initializeApp(options);
//  output=output+defaultApp.getName();
//                }catch(Exception w)
//                {
//                   output=output+w.getMessage();
//                }
 
		return Response.status(200).entity(output).build();
 
	}
        
        @GET
	@Path("/json/{data}")
	public Response getCount(@PathParam("data") String msg) {
           
        JSONObject obj = new JSONObject();
        obj.put("name", msg);
        obj.put("age", new Integer(100));
        String outut1=obj.toString();
        
        super.InsertNuseryData(outut1,new Dbresponse() {
            @Override
            public void OnSucess(String data) {
                res=data;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
             
        obj.put("conn", res);
        
        
        String outut=obj.toString();
        
        
 
//		return Response.status(200).entity(outut).build();
    return Response.ok(outut, MediaType.APPLICATION_JSON).build();
	}
 
}
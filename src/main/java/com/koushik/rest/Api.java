package com.koushik.rest;
 

import DataBaseControler.DataBaseControl;
import DataBaseControler.Dbresponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
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
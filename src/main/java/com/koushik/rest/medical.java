package com.koushik.rest;
 

import DataBaseControler.DataBaseControl;
import DataBaseControler.Dbresponse;
import DataBaseControler.MedicalDbcontroler;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.parser.JSONParser;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
@Path("/medical")
public class medical extends MedicalDbcontroler{
    
    String res="";
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
        
        @POST
	@Path("/insert_Doctor")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response postStudentRecord(String student){
        String result = "Record entered: "+ student;
         super.InsertNuseryData(student,new Dbresponse() {
            @Override
            public void OnSucess(String data) {
                res=data;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
                      Document document = Document.parse(student);
        Document append = document.append("id", res);

         
       
        JsonWriterSettings writerSettings = new JsonWriterSettings(JsonMode.SHELL, true);           

        
        
        return Response.ok(append.toJson(writerSettings), MediaType.APPLICATION_JSON).build();
            }


//	public Response getCount(@PathParam("data") String msg) {
//           
//        JSONObject obj = new JSONObject();
//        obj.put("name", msg);
//        obj.put("age", new Integer(100));
//        String outut1=obj.toString();
//        
//        super.InsertNuseryData(outut1,new Dbresponse() {
//            @Override
//            public void OnSucess(String data) {
//                res=data;
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        
//             
//        obj.put("conn", res);
//        
//        
//        String outut=obj.toString();
//        
//        
// 
////		return Response.status(200).entity(outut).build();
//    return Response.ok(outut, MediaType.APPLICATION_JSON).build();
//	}
 
}
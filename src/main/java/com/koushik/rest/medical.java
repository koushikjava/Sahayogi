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
public class medical extends MedicalDbcontroler {

    String res = "";

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;
       
        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/Chember/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postNewRecord(String student) {
        super.InsertChembesrData(student, new Dbresponse() {
            @Override
            public void OnSucess(String data) {
                res = data;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Document append = null;
        if (!res.equals("")) {
            Document document = Document.parse(student);
            append = document.append("id", res).append("code", 200);
        } else {
            append = new Document();
            append.put("code", 203);
            append.put("message", "Alreadt Esixt");
        }

        JsonWriterSettings writerSettings = new JsonWriterSettings(JsonMode.SHELL, true);

        return Response.ok(append.toJson(writerSettings), MediaType.APPLICATION_JSON).build();
    }
    
     @POST
    @Path("/doctor/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postNewDrRecord(String student) {
        super.InsertChembesrData(student, new Dbresponse() {
            @Override
            public void OnSucess(String data) {
                res = data;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Document append = null;
        if (!res.equals("")) {
            Document document = Document.parse(student);
            append = document.append("id", res).append("code", 200);
        } else {
            append = new Document();
            append.put("code", 203);
            append.put("message", "Alreadt Esixt");
        }

        JsonWriterSettings writerSettings = new JsonWriterSettings(JsonMode.SHELL, true);

        return Response.ok(append.toJson(writerSettings), MediaType.APPLICATION_JSON).build();
    }
    
     @POST
    @Path("/Chember/find")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response FindChemberRecord(String student) {
        super.FindChembesrData(student, new Dbresponse() {
            @Override
            public void OnSucess(String data) {
                res = data;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Document append = null;
        if (!res.equals("")) {
            Document document = Document.parse(res);
            append = document.append("code", 200);
        } else {
            append = new Document();
            append.put("code", 203);
            append.put("message", "Alreadt Esixt");
        }

        JsonWriterSettings writerSettings = new JsonWriterSettings(JsonMode.SHELL, true);

        return Response.ok(append.toJson(writerSettings), MediaType.APPLICATION_JSON).build();
    }
  
}

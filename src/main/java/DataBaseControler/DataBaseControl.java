/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseControler;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.util.Arrays;
import org.bson.Document;



/**
 *
 * @author koushik
 */
public class DataBaseControl {

   public void InsertNuseryData(final String data,final Dbresponse dnresp)
   {
       new MongodbConnector(new MongodbConnector.OnDbConnection() {
           @Override
           public void Conconnected(MongoDatabase db) {
              
               Document document = Document.parse(data);
              
                MongoCollection<Document> collection = db.getCollection("nursery");

                
                collection.insertOne(document);
                 dnresp.OnSucess("Connected"+collection.count());
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void ErorrConnected(String exception) {
               dnresp.OnSucess("Connected Faied"+exception);
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
   }
    
}

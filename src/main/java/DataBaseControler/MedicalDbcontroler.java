/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseControler;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.util.JSON;
import java.util.Arrays;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author koushik
 */
public class MedicalDbcontroler {

    public void InsertChembesrData(final String data, final Dbresponse dnresp) {
        new MongodbConnector(MongodbConnector.CHEMBERS, new MongodbConnector.OnDbConnection() {
            @Override
            public void Conconnected(MongoDatabase db) {

                Document document = Document.parse(data);

                MongoCollection<Document> collection = db.getCollection("Doctors");
                Document index = new Document("phone", 1);
                collection.createIndex(index, new IndexOptions().unique(true));

                collection.insertOne(document);
                ObjectId id = (ObjectId) document.get("_id");
                dnresp.OnSucess(id.toString());
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void ErorrConnected(String exception) {
                dnresp.OnSucess("Connected Faied" + exception);
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void FindChembesrData(final String data, final Dbresponse dnresp) {
        new MongodbConnector(MongodbConnector.CHEMBERS, new MongodbConnector.OnDbConnection() {
            @Override
            public void Conconnected(MongoDatabase db) {

                Document document = Document.parse(data);

                MongoCollection<Document> collection = db.getCollection("Doctors");

                BasicDBObject query = new BasicDBObject();

                query.put("phone", document.get("phone"));
                Document myDoc = collection.find(query).first();

                dnresp.OnSucess(myDoc.toJson().toString());
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void ErorrConnected(String exception) {
                dnresp.OnSucess("Connected Faied" + exception);
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseControler;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author koushik
 */
public class MongodbConnector {

    public static  MongoClient mongoClient;
    public static String DBDOCTOR = "MediCal_DB";
    public static String CHEMBERS="Chembers";

    MongodbConnector(OnDbConnection DBCN) {
        try {
           if(mongoClient==null)
            {
                ConnectConfig();
                System.out.println("@@ Resfers");
            }
            MongoDatabase database = mongoClient.getDatabase("school");
            DBCN.Conconnected(database);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    MongodbConnector(String DBNAME, OnDbConnection DBCN) {
        try {
            if(mongoClient==null)
            {
                ConnectConfig();
                System.out.println("@@ Resfers");
            }
            MongoDatabase database = mongoClient.getDatabase(DBNAME);
            DBCN.Conconnected(database);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    public interface OnDbConnection {

        void Conconnected(MongoDatabase db);

        void ErorrConnected(String Exception);
    }

    
    private void ConnectConfig()
    {
             MongoClientURI uri = new MongoClientURI(
                    "mongodb://koushik:koushik100@cluster0-shard-00-00-v7k3g.mongodb.net:27017,cluster0-shard-00-01-v7k3g.mongodb.net:27017,cluster0-shard-00-02-v7k3g.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
             mongoClient = new MongoClient(uri);
    }
    
    
}

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
    public static String DBDOCTOR="MediCal_DB";

    MongodbConnector(OnDbConnection DBCN) {
        boolean auth=false;
	      try{   
	
                  
                  
                MongoClientURI uri = new MongoClientURI(
   "mongodb://koushik:koushik100@cluster0-shard-00-00-v7k3g.mongodb.net:27017,cluster0-shard-00-01-v7k3g.mongodb.net:27017,cluster0-shard-00-02-v7k3g.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");

MongoClient mongoClient = new MongoClient(uri);
MongoDatabase database = mongoClient.getDatabase("school");

DBCN.Conconnected(database);
                  
                  
	         // To connect to mongodb server
//	       MongoClient    mongoClient = new MongoClient( "cluster0-shard-00-00-v7k3g.mongodb.net" , 27017 );
//				
//	         // Now connect to your databases
//	         DB db = mongoClient.getDB( "admin" );
//	         
//	         char[] password = new char[] {'k', 'o', 'u', 's', 'h', 'i','k','1','0','0'};
//	          auth = db.authenticate("koushik", password);
//                  if(auth)
//                  DBCN.Conconnected(db);
//	         System.out.println("Connect to database successfully");
//	         System.out.println("Authentication: "+auth);
               
			
	      }catch(Exception e){
//                  DBCN.ErorrConnected(e.getLocalizedMessage());
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	      
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     MongodbConnector(String DBNAME,OnDbConnection DBCN) {
        boolean auth=false;
	      try{   
	
                  
                  
                MongoClientURI uri = new MongoClientURI(
   "mongodb://koushik:koushik100@cluster0-shard-00-00-v7k3g.mongodb.net:27017,cluster0-shard-00-01-v7k3g.mongodb.net:27017,cluster0-shard-00-02-v7k3g.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");

MongoClient mongoClient = new MongoClient(uri);
MongoDatabase database = mongoClient.getDatabase(DBNAME);

DBCN.Conconnected(database);
                  
                  
	         // To connect to mongodb server
//	       MongoClient    mongoClient = new MongoClient( "cluster0-shard-00-00-v7k3g.mongodb.net" , 27017 );
//				
//	         // Now connect to your databases
//	         DB db = mongoClient.getDB( "admin" );
//	         
//	         char[] password = new char[] {'k', 'o', 'u', 's', 'h', 'i','k','1','0','0'};
//	          auth = db.authenticate("koushik", password);
//                  if(auth)
//                  DBCN.Conconnected(db);
//	         System.out.println("Connect to database successfully");
//	         System.out.println("Authentication: "+auth);
               
			
	      }catch(Exception e){
//                  DBCN.ErorrConnected(e.getLocalizedMessage());
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	      
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public interface OnDbConnection{
        void Conconnected(MongoDatabase db);
        void ErorrConnected(String Exception);
    }
    
    
    
    
    
}

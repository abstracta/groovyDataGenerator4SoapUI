@Grab('org.mongodb:mongodb-driver:3.2.2')

import com.mongodb.MongoClient
import com.mongodb.DBCollection
import com.mongodb.DB
import com.mongodb.BasicDBObject

class MongoService { 
    private MongoClient mongoClient 

    def host = 'localhost' // = your host name 
    def port = 27017 // = your port no.
    
    public MongoClient client() {
        mongoClient = mongoClient ?: new MongoClient(host, port) 
        return mongoClient
    } 

    public DBCollection collection(databaseName, collectionName) { 
        DB db = client().getDB(databaseName)
        return db.getCollection(collectionName) 
    }
}
 
 /* get collection from database */
 def databaseName = 'database-name'
 def collectionName = 'collection' 
 def service = new MongoService()
 def collection = service.collection(databaseName, collectionName)
 
 /* iterate over documents */
 def cursor = collection.find().iterator()
 while(cursor.hasNext()) {
     log.info(cursor.next())
 }
 cursor.close()
 
 /* find document using a query */
 def query = new BasicDBObject()
 query.put("_id", "foo")
 cursor = collection.find(query)
 def document = cursor.next()
 cursor.close()

 /* "update" a document (without using $set command) */
 def updatedDocument = new BasicDBObject()
 updatedDocument.put("_property", "some property")
 updatedDocument.put("_id", document.get("_id"))
 collection.update(document, updatedDocument)

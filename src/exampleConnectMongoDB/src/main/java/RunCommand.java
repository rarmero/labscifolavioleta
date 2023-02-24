
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;

import com.mongodb.MongoException;
import org.bson.conversions.Bson;


public class RunCommand {
    public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb+srv://<user>:<password>@<serveraddress>/<database>";

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("electrolinera");

            System.out.println("connected to:" + database.getName());


            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server.");

                System.out.println("showing collection reserve");

                MongoCollection<Document> collection = database.getCollection("reserve");
                collection.find().first();

                Bson filter = Filters.and(Filters.eq("IdPointCharge",123));

                collection.find(filter).forEach(doc -> System.out.println(doc.toJson()));


            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }


        }
    }
}


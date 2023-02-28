
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;

import com.mongodb.MongoException;
import org.bson.conversions.Bson;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;


public class RunCommand {

    public static void main(String[] args) throws IOException {

        final Properties myAppProperties = new Properties();
        myAppProperties.load(new FileInputStream("src/main/resources/application.properties"));

        try (MongoClient mongoClient = MongoClients.create(myAppProperties.getProperty("app.uri"))) {

            MongoDatabase database = mongoClient.getDatabase(myAppProperties.getProperty("app.database"));

            System.out.println("Connected to:" + database.getName());

            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server.");

                System.out.println("showing collection reserve");

                MongoCollection<Document> collection = database.getCollection("reserve");

                //Retrieving the documents
                FindIterable<Document> iterDoc = collection.find();
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {
                    System.out.println("********************************" + it.next());
                }

            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }

        }
    }
}


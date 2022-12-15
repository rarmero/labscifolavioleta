import helper.MessageUtil;
import helper.ReadJson;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class TestPerson {

    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {

        assertEquals(message,messageUtil.printMessage());
    }

    @Test
    public void testAddPerson() throws IOException, ParseException {

       JSONObject jsonObject;

        ReadJson readJson = new ReadJson();

        jsonObject = readJson.ReadJsonFromFile("person.json");

        Person person = new Person(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(), Integer.parseInt(jsonObject.get("age").toString()),
                jsonObject.get("address").toString(), null);

        Person personToTest = new Person();

        personToTest.setAge(47);

        assertEquals(personToTest.getAge(),47);

    }


}

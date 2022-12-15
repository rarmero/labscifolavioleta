import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;


public class TestReadJson {


    @Test
    public void readJson() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        URL url = this.getClass()
                .getClassLoader()
                .getResource("person.json");

        assert url != null;
        FileReader fileReader = new FileReader(url.getFile());

       JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

        assertEquals("rafa",jsonObject.get("name"));
    }
}


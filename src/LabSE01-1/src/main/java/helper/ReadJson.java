package helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadJson {

    public ReadJson(){}

    public JSONObject ReadJsonFromFile(String file) throws IOException, ParseException {

    JSONParser parser = new JSONParser();

        URL url = this.getClass()
                .getClassLoader()
                .getResource(file);

        FileReader fileReader = new FileReader(url.getFile());

        Object obj = parser.parse(fileReader);

    JSONObject jsonObject =  (JSONObject) obj;

    return  jsonObject;

}

}

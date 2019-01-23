import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by A-8559 on 23-01-2019.
 */
public class ExcellenceFilter implements  ExcellenceFilterInterface {

    public String getURL(String region) {
        String URL="https://gaiaro-tier2.us-west-2.prod.expedia.com/features/"+region+"/features?type=hotel&verbose=2&cid=geo&apk=explorer";
        return URL;
    }

    public BufferedReader getJsonFromURL(String url) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        return rd;
    }

    public JSONObject getJSONObject(BufferedReader br) {
        String jsonText = null;
        try {
            jsonText = readAll(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = jsonText.indexOf("{");
        jsonText = jsonText.substring(i);
        // jsonText=jsonText.replace("[","");
        //  jsonText=jsonText.replace("]","");
        JSONObject json = new JSONObject(jsonText.trim());
        return json;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}

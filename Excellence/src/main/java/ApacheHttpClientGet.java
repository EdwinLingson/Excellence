/**
 * Created by A-8559 on 22-01-2019.
 */
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class ApacheHttpClientGet {

    public static void main(String[] args) throws IOException {

        JSONObject json = readJsonFromUrl("https://gaiaro-tier2.us-west-2.prod.expedia.com/features/180106/features?type=hotel&verbose=2&cid=geo&apk=explorer");
        System.out.println(json.toString());
        System.out.println(json.get("id"));
    }

        private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                int i = jsonText.indexOf("{");
                jsonText = jsonText.substring(i);
               // jsonText=jsonText.replace("[","");
              //  jsonText=jsonText.replace("]","");
                JSONObject json = new JSONObject(jsonText.trim());
                return json;
            } finally {
                is.close();
            }
        }

    }



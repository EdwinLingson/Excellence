import org.json.JSONObject;

import java.io.BufferedReader;

/**
 * Created by A-8559 on 23-01-2019.
 */
public interface ExcellenceFilterInterface {
    String getURL(String region);
    BufferedReader getJsonFromURL(String URL);
    JSONObject getJSONObject(BufferedReader br);
}

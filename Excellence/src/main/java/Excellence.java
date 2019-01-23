import org.json.JSONObject;

import java.io.BufferedReader;

/**
 * Created by A-8559 on 23-01-2019.
 */
public class Excellence {
    public static void main(String[] args) {
        System.out.println(args[0]);
        String regionName=args[0];
        String region=null;
        String URL=null;
        BufferedReader br=null;
        JSONObject jsonObject=null;
        ExcellenceFilter excellenceFilter=new ExcellenceFilter();
        if (regionName.equals("Cancun, Quintana Roo, Mexico (CUN-Cancun Intl.)")){
            region="179995";
        }
        else if(regionName.equals("Montego Bay, Jamaica")){
            region="180106";
        }
        else if(regionName.equals(("Punta Cana, Dominican Republic"))){
            region="601906";
        }
        else{
            System.out.println("ERROR Destination");
            return;
        }
        URL=excellenceFilter.getURL(region);
        br=excellenceFilter.getJsonFromURL(URL);
        jsonObject=excellenceFilter.getJSONObject(br);
        System.out.println(jsonObject.get("id"));


    }
}

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;


public class GoogleSearchApiController {
    GoogleSearchApiController () {
    }
        public String [] getPictures(String param){
            HttpResponse<String> response = Unirest.get("https://google-search3.p.rapidapi.com/api/v1/images/q="+ param)
                    .header("x-rapidapi-key", "f0dc840fc9msh3c67d2cf9ecbf19p16e91bjsn04980b99238f")
                    .header("x-rapidapi-host", "google-search3.p.rapidapi.com")
                    .asString();
            System.out.println(response.getBody());
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String []ans = new String[3];
            System.out.println( jsonObject.getJSONArray("image_results").getJSONObject(0));
            for (int i=0;i<3;i++ )
            {
                JSONObject rec = jsonObject.getJSONArray("image_results").getJSONObject(i);
                JSONObject red = rec.getJSONObject("image");
                ans[i] = red.getString("src");
                System.out.println(ans[i]);
            }
            return ans;
        }
    }


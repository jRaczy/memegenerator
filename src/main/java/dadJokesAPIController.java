import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import kong.unirest.HttpResponse;
import kong.unirest.InputStreamPart;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;


import java.io.InputStream;
import java.util.List;

class DadJokesAPIController {
    public String[] getRandomJoke(){
      HttpResponse<JsonNode> response = Unirest.get("https://dad-jokes.p.rapidapi.com/random/joke")
                .header("x-rapidapi-key", "f0dc840fc9msh3c67d2cf9ecbf19p16e91bjsn04980b99238f")
                .header("x-rapidapi-host", "dad-jokes.p.rapidapi.com")
                .asJson();

      JSONObject jsoNobject = response.getBody().getObject();
      jsoNobject.getString("success");
      System.out.println( jsoNobject.getJSONArray("body").get(0));
      JSONObject rec = jsoNobject.getJSONArray("body").getJSONObject(0);
      rec.getString("setup");
      System.out.println(rec.getString("setup"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement jsonElement = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(jsonElement);
        String [] ans = new String[2];
        ans [0] = rec.getString("setup");
        ans [1] = rec.getString("punchline");
        return ans;
    }

}

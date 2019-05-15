package external.GSAPI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import external.Album;

class GSAPIToAlbumResolver implements ExternalServiceToAlbumResolver {

    public Album getAlbumFromExternal(String callResponse) {
        JsonObject first = getFirstJsonResult(callResponse);

        JsonElement extract = first.get("title");
        JsonElement yearE = first.get("year");
        JsonElement image = first.get("cover_image");

        String text;
        String path;

        if (isJsonComplete(extract, yearE, image)) {
            path = "";
            text = "No Results";
        } else {
            text = extract.getAsString() + ",year: " + yearE.getAsString();
            path = image.getAsString();
        }

        return new Album(text, path);
    }

    private boolean isJsonComplete(JsonElement extract, JsonElement yearE, JsonElement image){
        return extract == null && yearE == null && image == null;
    }

    private JsonObject getFirstJsonResult(String callResponse){
        Gson gson = new Gson();
        JsonObject jobj = gson.fromJson(callResponse, JsonObject.class);
        JsonArray results = jobj.get("results").getAsJsonArray();
        return results.get(0).getAsJsonObject();
    }
}

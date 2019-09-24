package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by chengwen on 2019-09-24
 */
public class JsonUtils2 {

    public static boolean isJson(String json) {
        if (json != null && json.length() > 0) {
            JsonElement jsonElement = null;
            try {
                jsonElement = new JsonParser().parse(json);
                return true;
            } catch (Exception e) {
            }
            if (jsonElement == null) {
                return false;
            }
            if (!jsonElement.isJsonObject()) {
                return false;
            }
        }
        return false;
    }
}

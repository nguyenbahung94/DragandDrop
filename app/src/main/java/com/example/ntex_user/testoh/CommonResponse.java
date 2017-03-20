package com.example.ntex_user.testoh;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class CommonResponse extends Validatable {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private JsonElement data;

    public int getStatus(){return code;}
    public String getMessage(){return isNotEmpty(message) ? message : "No message from server";}
    public String getData(){return  isNull(data)? "" :data.toString();}
    public JsonElement getDataObject(){return data;}
    public  <T> T parseData(Class<T> target){return  parseData(getData(),target);}
    private <T> T parseData(String json,Class<T> target){
        if (isNotEmpty(json)){
            try {
                Log.e("TAG-Hung",data.toString());
                return new Gson().fromJson(json,target);

            }catch (JsonSyntaxException e){
            }
        }
        return null;
    }
    public <T> T parseJsonTree(Class<T> target) {
        return parseJsonTree(getData(), target);
    }

    private <T> T parseJsonTree(String json, Class<T> target) {
        try {
            return parseData(pleaseConvertThisNextLevelJsonTree(json), target);
        } catch (ItCanNotBeHelped facepalm) {
        }
        return null;
    }
    private String pleaseConvertThisNextLevelJsonTree(String theNextLevelJsonTree) throws ItCanNotBeHelped {
        try {
            Map<String, Object> ripMyStack = toMap(new JSONObject(theNextLevelJsonTree));
            List<Object> ripMyStackAgain = new ArrayList<>();
            for (Map.Entry<String, Object> myPreciousMemory : ripMyStack.entrySet()) {
                ripMyStackAgain.add(myPreciousMemory.getValue());
            }
            return new Gson().toJson(ripMyStackAgain.toArray());
        } catch (JSONException e) {
        }
        throw new ItCanNotBeHelped();
    }
    private static class ItCanNotBeHelped extends Exception {

        private ItCanNotBeHelped() {
            super("Sorry, we have nothing to do with this god damn JSON");
        }
    }
    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }
    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}

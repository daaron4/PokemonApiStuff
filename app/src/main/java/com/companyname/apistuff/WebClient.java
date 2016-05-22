package com.companyname.apistuff;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by David on 5/20/2016.
 */
public class WebClient {

    private static final String baseUrl = "http://pokeapi.co/api/v2/";
    private static final String param = "pokemon/";

    private static WebClient instance;
    private static ApiResponseHandler responseHandler;

    private WebClient() {

    }

    public static WebClient getInstance(ApiResponseHandler handler) {
        responseHandler = handler;
        if(instance == null) {
            instance = new WebClient();
        }
        return instance;
    }

    public void doRequest(int id) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(baseUrl + param + id, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {
                try {
                    int id = responseBody.getInt("id");
                    String name = responseBody.getString("name");
                    int baseExperience = responseBody.getInt("base_experience");
                    int height = responseBody.getInt("height");
                    boolean isDefault = responseBody.getBoolean("is_default");
                    int order = responseBody.getInt("order");
                    int weight = responseBody.getInt("weight");

                    SimplePokemon simplePokemon = new SimplePokemon(id, name, baseExperience, height, isDefault, order, weight);
                    responseHandler.handleResponse(simplePokemon);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        });
    }

    public interface ApiResponseHandler{
        void handleResponse(SimplePokemon response);
    }
}

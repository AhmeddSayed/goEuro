/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreative.goeuro;

import org.json.JSONObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Ahmed
 */
public class APICaller {

    JSONObject query(String aCity) {
        JSONArray responseArray;
        JSONObject theResponse = new JSONObject();
        try {
            // constructing an httpclient
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            // constructing the query
            HttpGet query = new HttpGet("http://api.goeuro.com/api/v2/position/suggest/en/" + aCity);
            // executing
            CloseableHttpResponse response = httpClient.execute(query);
            // handling the responce in an array
            String json_string = EntityUtils.toString(response.getEntity());
            responseArray = new JSONArray(json_string);

            // updating the response variable
            theResponse = responseArray.getJSONObject(0);

        } catch (IOException | ParseException | JSONException e) {
            System.err.println("Error in communication with the API");
        }

        return theResponse;
    }
}

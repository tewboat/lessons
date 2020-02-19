package com.example.httpexample.repository.jsonplaceholder;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonPlaceholderRepository {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public String getRawJson(String urlPath) throws IOException {
        try {
                URL url = new URL(baseUrl + urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.connect();

            int responseCode = connection.getResponseCode();

            switch (responseCode) {
                case 200:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String tmpLine;
                    while ((tmpLine = br.readLine()) != null) {
                        sb.append(tmpLine).append("\n");
                    }
                    br.close();
                    return sb.toString();
                case 404:
                    Log.e("JSON_PLCHLDR_REPOSITORY", "Page not found");
                    break;
                case 400:
                    Log.e("JSON_PLCHLDR_REPOSITORY", "Bad request");
                    break;
                case 500:
                    Log.e("JSON_PLCHLDR_REPOSITORY", "Internal server error");
                    break;
            }
            return null;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}

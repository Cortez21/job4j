package ru.job4j.javadotnet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Weather {

    public static void main(String[] args) {
        var query = "https://weather.com/uk-UA/weather/today/l/721275a2e48c2ce13c360c2d74dd3067f31a03a7d91aec6cf4ed3e75a9fef747";
        try {
            var connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

                BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;
                while ((line = bf.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                bf.close();

                String splitter = "<div class=\"today_nowcard-temp\"><span class=\"\">";
                System.out.println(String.format("%s %s" , "Temperature in Khmelnitsky city is:", sb.toString().split(splitter)[1].substring(0, 2)));
            } else {
                System.out.println(String.format("Connection failed: %s", connection.getResponseCode()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

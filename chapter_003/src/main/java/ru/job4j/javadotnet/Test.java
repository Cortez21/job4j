package ru.job4j.javadotnet;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }


        String query = "https://portal.alpm.com.ua";
        HttpURLConnection connection = null;
        String cookieString = "_ga=GA1.3.1939077366.1551894560; _gid=GA1.3.65112970.1551894560; portal3030=9109d956ad2e1cf551c9c274d755630d; sessioncode=5c2a93e4cf00705ccf8af8bdcdb9aa33";
        try {

            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            connection.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7,pl;q=0.6");
            connection.setRequestProperty("Host", "portal.alpm.com.ua");
            connection.setRequestProperty("Referer", "https://portal.alpm.com.ua/index.php?action=");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/71.0.3578.98 Chrome/71.0.3578.98 Safari/537.36");
            connection.setRequestProperty("Cookie", cookieString);
//            connection.setRequestProperty("Action", "login");
//            connection.setRequestProperty("login", "m.yunysov");
//            connection.setRequestProperty("password", "1111");

            connection.connect();


            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

                BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                Map head = connection.getHeaderFields();
                for (Object value : head.values()) {
                    System.out.println(value.toString());
                }
                String line;

                while ((line = bf.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                bf.close();

                System.out.println(sb.toString());
            } else {
                System.out.println(String.format("Connection failed: %s", connection.getResponseCode()));
            }


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

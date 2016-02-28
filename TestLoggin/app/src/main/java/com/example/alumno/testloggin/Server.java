package com.example.alumno.testloggin;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by Alumno on 28/02/2016.
 */


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class Server {



    /**
     * Created by Alumno on 28/02/2016.
     */


        private static final int CONNECTION_TIMEOUT = 10000;
        private static final int DATARETRIEVAL_TIMEOUT = 10000;

        private static String requestUrl(String url, String postParameters) {

            HttpURLConnection urlConnection = null;
            try {
                URL urlToRequest = new URL(url);
                urlConnection = (HttpURLConnection) urlToRequest.openConnection();
                urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);

                if (postParameters != null) {


                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setFixedLengthStreamingMode(
                            postParameters.getBytes().length);
                    urlConnection.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded;charset=UTF-8");

                    PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                    out.print(postParameters);
                    out.close();
                }

                int statusCode = urlConnection.getResponseCode();
                if (statusCode != HttpURLConnection.HTTP_OK) {

                }



                InputStream in =
                        new BufferedInputStream(urlConnection.getInputStream());
                String respuesta = getResponseText(in);
                Log.i("stuff", respuesta);
                return respuesta;




            } catch (MalformedURLException e) {

            } catch (SocketTimeoutException e) {

            } catch (IOException e) {

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return null;
        }

        private static String getResponseText(InputStream in) {
            try {
                Reader reader = new InputStreamReader(in, "UTF-8");
                char[]tamanio=new char[6];
                reader.read(tamanio);
                int tam = Integer.parseInt(new String(tamanio));

                char[] buffer = new char[tam];
                reader.read(buffer);
                String fff = new String(buffer);
                return fff;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }



    public static boolean login(final String user, final String password){

        final boolean[] isLogged = {false};
        String res = requestUrl("http://zubatomic.es/randomProjects/testSafeLogin/login.php", "user="+user+"&pass="+password);



        return res.equals("success");

    }

}

package com.example.alumno.flappybanana;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.nio.CharBuffer;
import java.util.ArrayList;

public class DeathScreen extends AppCompatActivity {

    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int DATARETRIEVAL_TIMEOUT = 10000;


    static MyView myView;

    int highScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_screen);
        final String totalScore = getIntent().getStringExtra("score");
        final TextView score = (TextView)findViewById(R.id.score);


        highScore = leerPuntos();
        if(Integer.parseInt(totalScore) > highScore){
            guardarPuntos(totalScore);
            highScore = Integer.parseInt(totalScore);
        }

        score.setText("Score: " + totalScore + ". Highscore: " + highScore);






        AsyncTask<Object, Object, String> a = new AsyncTask<Object, Object, String>() {

            @Override
            protected String doInBackground(Object... params) {
                return requestUrl("http://justmine.me/prueba.php", "puntuacion="+totalScore);
            }

            @Override
            protected void onPostExecute(String response) {
                int globalHighScore = Integer.parseInt(response);



                int r = 0;






                r = (int)(Math.random() * 4 + 44); //44-48






                double r1 = Double.parseDouble(totalScore) / globalHighScore;
                double r2 = Double.parseDouble(totalScore) / highScore;

                if(r1 > 1){
                    r = (int)(Math.random() * 3 + 44);
                    //buen mensaje 44-47
                }else if(r1 == 1){
                    r = (int)(Math.random() * 1 + 48);
                    //casi mensage 48-49
                }else if(r2 > 1){
                    r = (int)(Math.random() * 2 + 41);
                    //buen mensaje 41-43
                }else if(r2 == 1){
                    r = (int)(Math.random() * 1 + 39);
                    //casi mensaje 39-40
                }else if(r1 > 0.8){
                    r = (int)(Math.random() * 1 + 37);
                    //casi mensaje 37-38
                }else if(r2 > 0.8){
                    r = (int)(Math.random() * 3 + 33);
                    //casi mensaje 33-36
                }else if(r2 > 0.45){
                    r = (int)(Math.random() * 12 + 20);
                    //decent mensaje 20-32
                }else{
                    r = (int)(Math.random() * 19 + 0);
                    //mal mensage 0-19
                }




                ArrayList<String> sayings = new ArrayList<String>();

                //Bad score 0-19
                sayings.add("You should be trying again by now");sayings.add("Really? Is that the best you can do?");sayings.add("I have seen better scores");sayings.add("That score is sad.");sayings.add("You could have done so much better!");sayings.add("Just click the back button...");sayings.add("So, what do you consider good exactly?");sayings.add("I thought we recruited the good players not, you...");sayings.add("Why are you still here, I'm trying to sleep...");sayings.add("You could try harder next time...");sayings.add("You literaly lasted about 3 milliseconds");sayings.add("I am anything but proud of you.");sayings.add("Please get a good score next time...");sayings.add("There is no adjective bad enough to describe that score.");sayings.add("That is not a good score.");sayings.add("What a bad score!");sayings.add("You lasted so little, I wasn't able to see you play.");sayings.add("Bad");sayings.add("Bad");sayings.add("Bad");

                //Decent score 20-32
                sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");sayings.add("Decent");

                //Close to high score 33-36
                sayings.add("Almost there. A bit more and you get a new high score!");sayings.add("Almost there. A bit more and you get a new high score!");sayings.add("Almost there. A bit more and you get a new high score!");sayings.add("Almost there. A bit more and you get a new high score!");

                //Close to global score 37-38
                sayings.add("OMG. So close to a new high score!");sayings.add("OMG. So close to a new high score!");

                //Really close to high score 39-40
                sayings.add("SO CLOSE!!! JUST ONE MORE!");sayings.add("SO CLOSE!!! JUST ONE MORE!");

                //New local high score 41-43
                sayings.add("YES!!! NEW HIGH SCORE!!");sayings.add("YES!!! NEW HIGH SCORE!!");sayings.add("YES!!! NEW HIGH SCORE!!");

                //New global high score 44-47
                sayings.add("YOU ARE THE BEST IN THE WORLD NOW!!");sayings.add("YOU ARE THE BEST IN THE WORLD NOW!!");sayings.add("YOU ARE THE BEST IN THE WORLD NOW!!");sayings.add("YOU ARE THE BEST IN THE WORLD NOW!!");

                //Really close to global score 48-49
                sayings.add("REALLY?! You could have been the WORLD CHAMPION");sayings.add("REALLY?! You could have been the WORLD CHAMPION");




                TextView medalTXT = (TextView)findViewById(R.id.medalTXT);
                medalTXT.setText("Global high score: " + response + " " + r + " " + sayings.get(r));



            }
        };
        a.execute();

    }

    private int leerPuntos() {

        File file = new File(this.getFilesDir(), "highscore");
        try {
            FileInputStream input = new FileInputStream(file);
            InputStreamReader ir = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(ir);
            String string = br.readLine();
            int highScore = Integer.parseInt(string);
            return highScore;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;

    }

    private void guardarPuntos(String totalScore) {
        String filename = "highscore";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, this.MODE_PRIVATE);
            outputStream.write(totalScore.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myView.restart();




    }







    public static String requestUrl(String url, String postParameters) {

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
            return new String(buffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }




}

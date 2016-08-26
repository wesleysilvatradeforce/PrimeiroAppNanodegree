package wlsilva.com.br.primeirodeprojeto.util;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import wlsilva.com.br.primeirodeprojeto.BuildConfig;


/**
 * Created by wesleysilva on 8/21/16.
 */

public class Request {

    private static String TAG = Request.class.getCanonicalName();

    public String conection(boolean type) throws IOException {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            String orderType = this.getOrderMovie(type);

            URL url = new URL(this.getUri(orderType));

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            return buffer.toString();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return null;
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    private String getOrderMovie(boolean order){
        String QUEUE_TYPE_POPULAR = "popular";
        String QUEUE_TYPE_TOP_RATED = "top_rated";
        return (order) ? QUEUE_TYPE_POPULAR : QUEUE_TYPE_TOP_RATED;
    }

    private String getUri(String order){
        String BASEURL = "http://api.themoviedb.org/3/movie/";
        String QUEUE_API_KEY = "api_key";
        String API_KEY = BuildConfig.THE_MOVIE_DB_API;

        Uri uri = Uri.parse(BASEURL).buildUpon()
                .appendPath(order)
                .appendQueryParameter(QUEUE_API_KEY, API_KEY)
                .build();
        return uri.toString();
    }
}

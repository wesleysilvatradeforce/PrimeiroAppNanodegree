package wlsilva.com.br.primeirodeprojeto.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import wlsilva.com.br.primeirodeprojeto.movies.Movie;


public class ConvertJsonToMovie {

    public ArrayList<Movie> getConvert(String value) throws JSONException {

        if(value.isEmpty()){
            return new ArrayList<>();
        }

        JSONObject jsonObject = new JSONObject(value);

        JSONArray resultJson = jsonObject.getJSONArray("results");
        ArrayList<Movie> listMoview = new ArrayList<>();

        for(int i=0; i<resultJson.length(); i++){
            Movie movie = new Movie();
            JSONObject resultObject = resultJson.getJSONObject(i);
            movie.setSynopsis(this.getSynopsis(resultObject));
            movie.setTitle(this.getTitle(resultObject));
            movie.setDate(this.getDate(resultObject));
            movie.setRating(this.getRating(resultObject));
            movie.setPathImage(this.getPathImage(resultObject));
            listMoview.add(movie);
        }
        return listMoview;
    }

    private String getSynopsis(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("overview");
    }

    private String getTitle(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("original_title");
    }

    private String getDate(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("release_date");
    }

    private int getRating(JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt("vote_average");
    }

    private String getPathImage(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("poster_path");
    }
}

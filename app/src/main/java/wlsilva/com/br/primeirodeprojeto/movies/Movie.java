package wlsilva.com.br.primeirodeprojeto.movies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wesleysilva on 8/16/16.
 */

public class Movie implements Parcelable {
    private final String BASE_URL_IMG = "http://image.tmdb.org/t/p/";
    private final String SIZE_IMAGE = "w185";

    private String pathImage;
    private String title;
    private String synopsis;
    private int rating;
    private String date;

    public Movie() {
    }

    public Movie(Parcel in) {
        pathImage = in.readString();
        title = in.readString();
        synopsis = in.readString();
        rating = in.readInt();
        date = in.readString();
    }

    public void setPathImage(String image){
        this.pathImage = BASE_URL_IMG+"/"+SIZE_IMAGE+"/"+image;
    }

    public String getPathImage(){
        return this.pathImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getRating() {
        return rating ;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pathImage);
        dest.writeString(title);
        dest.writeString(synopsis);
        dest.writeInt(rating);
        dest.writeString(date);
    }

    public final static Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>(){

        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}

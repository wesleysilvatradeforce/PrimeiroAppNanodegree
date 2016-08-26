package wlsilva.com.br.primeirodeprojeto.movies;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenceMovieActivity extends PreferenceActivity {

    private final String TAG_FRAGMENT = "fragment_preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .add(android.R.id.content,new PreferenceMovieFragment(),TAG_FRAGMENT)
                .commit();
    }

}

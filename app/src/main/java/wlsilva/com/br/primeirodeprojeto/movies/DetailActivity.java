package wlsilva.com.br.primeirodeprojeto.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wlsilva.com.br.primeirodeprojeto.R;

public class DetailActivity extends AppCompatActivity {

    public static final String MOVIE = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent() != null){
            Movie movie = getIntent().getParcelableExtra(MOVIE);
            DetailMovieFragment fragment = DetailMovieFragment.getInstace(movie);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_detail, fragment, MOVIE)
                    .commit();
        }
    }
}

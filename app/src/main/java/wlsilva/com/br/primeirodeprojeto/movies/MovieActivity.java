package wlsilva.com.br.primeirodeprojeto.movies;

import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;

import java.io.IOException;

import wlsilva.com.br.primeirodeprojeto.R;
import wlsilva.com.br.primeirodeprojeto.movies.ListMoviesFragment;
import wlsilva.com.br.primeirodeprojeto.util.Request;

public class MovieActivity extends AppCompatActivity {

    private ListMoviesFragment mListMoviesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mListMoviesFragment = new ListMoviesFragment();

        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.activity_movie,mListMoviesFragment);
        mFragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        mListMoviesFragment = null;
        super.onDestroy();
    }
}

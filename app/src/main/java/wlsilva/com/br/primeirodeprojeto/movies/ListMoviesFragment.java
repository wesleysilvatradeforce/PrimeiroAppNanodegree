package wlsilva.com.br.primeirodeprojeto.movies;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import wlsilva.com.br.primeirodeprojeto.R;
import wlsilva.com.br.primeirodeprojeto.util.ConvertJsonToMovie;
import wlsilva.com.br.primeirodeprojeto.util.Request;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListMoviesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private final String TAG = ListMoviesFragment.class.getCanonicalName();
    private GridView mGridView;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ListMovieAdapter mAdapter;
    private MovieAsync async;

    public ListMoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_movies, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.gridview);

        mAdapter = new ListMovieAdapter(movieList);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(this);
        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.async =  new MovieAsync();
        this.async.execute();
    }

    @Override
    public void onStop() {
        super.onStop();
        this.movieList.clear();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(),DetailActivity.class);
        intent.putExtra(DetailActivity.MOVIE, this.movieList.get(position));
        startActivity(intent);
    }

    private class MovieAsync extends AsyncTask<String , Void, ArrayList<Movie>> {
        private final String TAG = MovieAsync.class.getCanonicalName();
        @Override
        protected ArrayList<Movie> doInBackground(String... params) {

            Request request = new Request();
            try {

                //Get preference choice
                Boolean orderChoice  = PreferenceManager.getDefaultSharedPreferences(getActivity())
                        .getBoolean(getString(R.string.pref_key), false);

                //Request Network return string
                String resultRequestNetwork = request.conection(orderChoice);
                //Check return  is null or empty
                if(resultRequestNetwork != null){
                    ConvertJsonToMovie convertJson = new ConvertJsonToMovie();
                    //Convert String json to object List this the Movies
                    return convertJson.getConvert(resultRequestNetwork);
                }
                return null;
            } catch (IOException e) {
                //Log Error
                Log.e(TAG, "Error: "+e.getMessage());
                return null;
            } catch (JSONException e) {
                //Log error
                Log.e(TAG, "Error: "+e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {

            //Check is the movies is null
            if(movies != null){
                movieList.addAll(movies);
                mAdapter.notifyDataSetChanged();
            } else {

                //Show if will have eror in request
                Toast.makeText(
                        getActivity(),
                        getActivity().getString(R.string.error_network),
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(this.async != null &&this.async.getStatus() == AsyncTask.Status.RUNNING){
            this.async.cancel(true);
        }
        this.async = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.movie_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_pref_order:
                Intent intent = new Intent(getActivity(), PreferenceMovieActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}

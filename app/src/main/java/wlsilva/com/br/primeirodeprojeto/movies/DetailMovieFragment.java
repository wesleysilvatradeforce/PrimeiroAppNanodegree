package wlsilva.com.br.primeirodeprojeto.movies;

import android.content.Context;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import wlsilva.com.br.primeirodeprojeto.R;
public class DetailMovieFragment extends Fragment {

    private static final String MOVIE = "movie";

    private ImageView mMovieImage;
    private TextView mTitle;
    private RatingBar mRating;
    private TextView mData;
    private TextView mSynopsis;

    public static DetailMovieFragment getInstace(Movie movie){
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(MOVIE, movie);

        DetailMovieFragment fragment = new DetailMovieFragment();
        fragment.setArguments(mBundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_detail_movie, container, false);

        this.bindView(viewRoot);

        this.setValueView((Movie) getArguments().getParcelable(MOVIE));

        return viewRoot;
    }

    public void bindView(View rootView){
        this.mMovieImage = (ImageView) rootView.findViewById(R.id.img_moview);
        this.mTitle = (TextView) rootView.findViewById(R.id.title);
        this.mRating = (RatingBar) rootView.findViewById(R.id.ratingBar);
        this.mData = (TextView) rootView.findViewById(R.id.data);
        this.mSynopsis = (TextView) rootView.findViewById(R.id.synopsis);
    }

    public void setValueView(Movie movie){
        this.mTitle.setText(movie.getTitle());
        this.mRating.setRating(movie.getRating());
        this.mData.setText(movie.getDate());
        this.mSynopsis.setText(movie.getSynopsis());

        Picasso.with(getActivity()).load(movie.getPathImage()).into(this.mMovieImage);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

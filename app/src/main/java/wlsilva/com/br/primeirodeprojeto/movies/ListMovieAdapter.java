package wlsilva.com.br.primeirodeprojeto.movies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import wlsilva.com.br.primeirodeprojeto.R;

public class ListMovieAdapter extends BaseAdapter {

    private List<Movie> sData;

    public ListMovieAdapter(List<Movie> data) {
        this.sData = data;
    }

    @Override
    public int getCount() {
        return sData != null ? sData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return sData != null ? sData.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear(){
        sData.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater lInflater = (LayoutInflater) parent.getContext().getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);

            convertView = lInflater.inflate(R.layout.adapter_moview,null);
        }

        ImageView mImageView = (ImageView) convertView.findViewById(R.id.img_moview);

        Picasso.with(parent.getContext())
                .load(sData.get(position).getPathImage())
                .into(mImageView);

        return convertView;
    }
}

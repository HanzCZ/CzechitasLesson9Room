package cz.czechitas.janhanak.czechitaslesson9.activites.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cz.czechitas.janhanak.czechitaslesson9.R;
import cz.czechitas.janhanak.czechitaslesson9.data.Movie;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;
    private final List<Movie> movies;

    public CustomListAdapter(Activity context, List<Movie> movies) {
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        //this code gets references to objects in the list_item.xml file
        TextView name = rowView.findViewById(R.id.name);
        TextView info = rowView.findViewById(R.id.info);
        ImageView icon = rowView.findViewById(R.id.icon);

        //this code sets the values of the objects to values from the arrays
        try {
            name.setText(movies.get(position).name);
            info.setText(movies.get(position).description);
            Glide.with(context).load(movies.get(position).image).into(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowView;
    }
}

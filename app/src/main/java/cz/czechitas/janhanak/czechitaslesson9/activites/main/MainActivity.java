package cz.czechitas.janhanak.czechitaslesson9.activites.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import com.orhanobut.hawk.Hawk;

import java.util.Collections;
import java.util.List;

import cz.czechitas.janhanak.czechitaslesson9.R;
import cz.czechitas.janhanak.czechitaslesson9.activites.login.LoginActivity;
import cz.czechitas.janhanak.czechitaslesson9.data.Movie;
import cz.czechitas.janhanak.czechitaslesson9.room.AppDatabase;
import cz.czechitas.janhanak.czechitaslesson9.room.DatabaseInstance;
import cz.czechitas.janhanak.czechitaslesson9.service.ApiService;
import cz.czechitas.janhanak.czechitaslesson9.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomListAdapter adapter;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        ApiService apiService = RetrofitInstance.getRetrofitInstance().
                create(ApiService.class);

        //Inicializace roomu
        db = DatabaseInstance.getRoomInstance(this);

        adapter = new CustomListAdapter(MainActivity.this, db.userDao().getAll());
        listView.setAdapter(adapter);

        Call<List<Movie>> call = apiService.getAllMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                //TODO tohle je mainThread!
                //fix nulloveho ctvrteho objektu
                List<Movie> movies = response.body();
                movies.removeAll(Collections.singleton(null));

                db.userDao().insertAll(movies);
                adapter = new CustomListAdapter(MainActivity.this, db.userDao().getAll());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Chyba", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                Hawk.delete("logged");
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

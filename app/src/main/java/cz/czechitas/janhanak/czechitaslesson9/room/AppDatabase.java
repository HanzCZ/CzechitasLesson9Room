package cz.czechitas.janhanak.czechitaslesson9.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import cz.czechitas.janhanak.czechitaslesson9.data.Movie;

@Database(entities = {Movie.class}, version = 6, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDao userDao();
}

package cz.czechitas.janhanak.czechitaslesson9.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Movie {

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int movieId;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    public String name;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    public String description;

    @SerializedName("image")
    @ColumnInfo(name = "image")
    public String image;
}

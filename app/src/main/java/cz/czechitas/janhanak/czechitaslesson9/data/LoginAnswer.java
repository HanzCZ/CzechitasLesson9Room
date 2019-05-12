package cz.czechitas.janhanak.czechitaslesson9.data;

import com.google.gson.annotations.SerializedName;

public class LoginAnswer {

    @SerializedName("status")
    public String status;
    @SerializedName("user")
    public String user;
}

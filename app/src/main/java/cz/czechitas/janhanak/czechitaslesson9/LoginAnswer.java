package cz.czechitas.janhanak.czechitaslesson9;

import com.google.gson.annotations.SerializedName;

public class LoginAnswer {

    @SerializedName("status")
    String status;
    @SerializedName("user")
    String user;
}

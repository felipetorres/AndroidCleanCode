package br.com.app.androidcleancode.api;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("userAccount") private UserAccount userAccount;
    @SerializedName("error") private LoginError error;
}

class UserAccount {
    @SerializedName("userId") private long id;
    @SerializedName("name") String name;
    @SerializedName("bankAccount") private String account;
    @SerializedName("agency") private String agency;
    @SerializedName("balance") private double balance;
}

class LoginError {
    @SerializedName("code") private int code;
    @SerializedName("message") private String message;
}

package com.sulaimanms.presensimdnu.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sulaiman MS on 5/30/2017.
 */

public class Data {
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("last_activity")
    @Expose
    private String lastActivity;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity;
    }

}

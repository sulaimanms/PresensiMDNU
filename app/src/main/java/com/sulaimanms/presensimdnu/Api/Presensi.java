package com.sulaimanms.presensimdnu.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sulaiman MS on 5/30/2017.
 */

public class Presensi {
    @SerializedName("nis")
    @Expose
    private String nis;
    @SerializedName("nama")
    @Expose
    private String nama;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

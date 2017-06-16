package com.sulaimanms.presensimdnu.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Sulaiman MS on 5/30/2017.
 */

public class Kirim {
    @SerializedName("nis")
    @Expose
    private String nis;
    @SerializedName("tgl_presensi")
    @Expose
    private String tglPresensi;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("kd_kelas")
    @Expose
    private String kdKelas;
    @SerializedName("nip_ustad")
    @Expose
    private String nipUstad;

    public Kirim() {
    }

    public Kirim(String nis, String tglPresensi, String keterangan, String kdKelas, String nipUstad) {
        this.nis = nis;
        this.tglPresensi = tglPresensi;
        this.keterangan = keterangan;
        this.kdKelas = kdKelas;
        this.nipUstad = nipUstad;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getTglPresensi() {
        return tglPresensi;
    }

    public void setTglPresensi(String tglPresensi) {
        this.tglPresensi = tglPresensi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKdKelas() {
        return kdKelas;
    }

    public void setKdKelas(String kdKelas) {
        this.kdKelas = kdKelas;
    }

    public String getNipUstad() {
        return nipUstad;
    }

    public void setNipUstad(String nipUstad) {
        this.nipUstad = nipUstad;
    }
}

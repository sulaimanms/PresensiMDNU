package com.sulaimanms.presensimdnu.face;

import com.sulaimanms.presensimdnu.Api.HasilPresensi;
import com.sulaimanms.presensimdnu.Api.Kirim;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Sulaiman MS on 6/4/2017.
 */

public interface Attend {
    @POST("insert_presensi")
    Call<HasilPresensi> kirimData(@Body List<Kirim> data);
}

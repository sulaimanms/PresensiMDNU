package com.sulaimanms.presensimdnu.face;

import com.sulaimanms.presensimdnu.Api.Presensi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sulaiman MS on 5/30/2017.
 */

public interface Kelas {
    @GET("data_santri/{tingkat}")
    Call<List<Presensi>> getRepos(@Path("tingkat") String user);
}

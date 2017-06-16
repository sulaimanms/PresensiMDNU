package com.sulaimanms.presensimdnu.face;

import com.sulaimanms.presensimdnu.Api.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Sulaiman MS on 5/30/2017.
 */

public interface Login {
    @FormUrlEncoded
    @POST("auth")
    Call<User> login(@Field("user_id") String user_id,
                     @Field("password") String password
    );
}

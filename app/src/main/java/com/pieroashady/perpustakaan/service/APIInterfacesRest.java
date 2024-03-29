package com.pieroashady.perpustakaan.service;

/**
 * Created by user on 1/10/2018.
 */


import com.pieroashady.perpustakaan.model.Surveyor;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by anupamchugh on 09/01/17.
 */

 public interface APIInterfacesRest {

   @GET("getsurveyors")
    Call<List<Surveyor>> getUser();

   @POST("addsurveyor")
   Call<Surveyor> addUser();

   @POST("update/surveyor")
 Call<Surveyor>  updateUser(@Query("surveyorId") String surveyorId);

   @GET("delete/surveyor")
 Call<Surveyor> deleteUser(@Query("surveyorId") String surveyorId);

 @FormUrlEncoded
 @POST("api/auth/login")
 Call<ResponseBody> loginRequest(@Field("surveyorId") String surveyorId,
                                 @Field("password") String password);


//    @GET("users")
//    Call<com.juaracoding.absensi.model.reqres.User> getUserReqres(@Query("page") String page);

//    @GET("posts")
//    Call<List<Post>> getPost();

//    @GET("comments")
//    Call<List<Comment>> getComment(@Query("postId") String postId);


   /* @FormUrlEncoded
    @POST("api/user/login")
    Call<Authentication> getAuthentication(@Field("username") String username, @Field("password") String password);

    @GET("api/user_mobile/all")
    Call<Authentication> getUser(@Query("username_k") String user);

   @GET("api/komplain/ticket")
   Call<KomplainModel> getTicket(@Query("username") String username);

    @FormUrlEncoded
    @POST("api/komplain/add")
    Call<UpdateKomplain> addKomplain(@Field("username_komplain") String username, @Field("kode_edc") String kode_edc, @Field("masalah") String masalah, @Field("notes_komplain") String notes);

    @GET("api/edc_problem/all")
    Call<MasalahEdcModel> getEDCProblem();
*//*
    @GET("api/dataorder/all")
    Call<ModelOrder> getOrder(@Query("username") String user);



/*
            @Part MultipartBody.Part img1,
           @Part MultipartBody.Part img2,
           @Part MultipartBody.Part img3,
 *//*

   @Multipart
   @POST("api/dataorder/update")
   Call<Komplain> updateData(

           @Part("pod_date") RequestBody podate,
           @Part("status") RequestBody status,
           @Part("lat") RequestBody lat,
           @Part("lon") RequestBody lon,
           @Part("poddate") RequestBody poddate,
           @Part("recievedate") RequestBody recievedate,
           @Part("id") RequestBody id,
           @Part MultipartBody.Part img1


   );


   @Multipart
   @POST("api/komplain/update")
   Call<UpdateKomplain> sendImage(
           @Part("id") RequestBody id,
           @Part("username_penanganan") RequestBody username_komplain,
           @Part("hasil_penanganan") RequestBody masalah,
           @Part("tanggal_penanganan") RequestBody kode_edc,
           @Part("notes_penanganan") RequestBody notes_komplain,
           @Part("status") RequestBody status,
           @Part MultipartBody.Part img1


   );*/

}


package com.example.eatitserver.Remote;



import com.example.eatitserver.Common.Common;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGeoCoordinates {

    @GET("maps/api/geocode/json")
    Call<String> getGeoCode(@Query("address") String address, @Query("key") String api);

    @GET("maps/api/directions/json")
    Call<String> getDirections(@Query("origin") String origin,@Query("destination") String destination, @Query("key") String api);


}

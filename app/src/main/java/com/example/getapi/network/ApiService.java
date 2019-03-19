package com.example.getapi.network;

import com.example.getapi.ResponseTeam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ResponseTeam> getDataTeams();

}

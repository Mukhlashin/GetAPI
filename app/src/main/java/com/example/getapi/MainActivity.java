package com.example.getapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.getapi.adapter.TeamsAdapter;
import com.example.getapi.network.ConfigRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTeam;
    TeamsAdapter adapter;
    List<TeamsItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.rv_teams);
        rvTeam.setLayoutManager(new LinearLayoutManager(this));

        getDataTeams();

    }
        private void getDataTeams() {
        ConfigRetrofit.getInstance().getDataTeams().enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new TeamsAdapter(MainActivity.this, data);
                    rvTeam.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable t) {

            }
        });
    }
}

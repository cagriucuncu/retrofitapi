package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
List<Character>characterList;
    RecyclerView recyclerView;
    RecyclerView review;
List<RickLocations>locationsList;
String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyclerView);
        review=findViewById(R.id.card);
        locationsList=new ArrayList<>();
        Retrofit retrofit= new Retrofit.Builder()


                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LocationsApi locationsApi=retrofit.create(LocationsApi.class);
                Call<JSONResponse> call=locationsApi.getLocations();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                    JSONResponse jsonResponse = response.body();
                locationsList=new ArrayList<>(Arrays.asList(jsonResponse.getResults()));

           //     for (RickLocations ricklocations:slocationsList) {
               //     String responsetest="";
                 //   responsetest+=ricklocations.getResidents();
                  //  textView.append(""+responsetest+" ");
                    //locationsList.add(ricklocations);

PutDataIntoRecyclerView(locationsList);


          //      }
                for (RickLocations ricklocations:locationsList) {
                    if (ricklocations.getResidents().isEmpty() != true) {
                    for(int i=0;i<ricklocations.getResidents().size();i++){

                        url = String.valueOf(ricklocations.getResidents().get(i));
                        Log.d("tag", url);


                    }
                    }
                }

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });


    }





    private void PutDataIntoRecyclerView(List<RickLocations> locationsList) {

        Horadapter horadapter=new Horadapter(this,locationsList,review);
        LinearLayoutManager layoutManager1= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(horadapter);

    }


    public void PutDataIntoReview(List<Character>characterList) {
        this.characterList = characterList;
        Characteradapter characteradapter=new Characteradapter(this,characterList);
        LinearLayoutManager layoutManager2= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        review.setLayoutManager(layoutManager2);
        review.setAdapter(characteradapter);
    }




}
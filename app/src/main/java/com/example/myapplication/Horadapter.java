package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* sasASasasaSA



public class Horadapter extends RecyclerView.Adapter<Horadapter.MyViewHolder> {

    private RecyclerView review;
    private Context mContext;
    private List<RickLocations> locationsList;
    private List<Character> characterList = new ArrayList<>();
    private String url;
    private RecyclerView mainRecyclerView;

    public Horadapter(Context mContext, List<RickLocations> locationsList, RecyclerView mainRecyclerView) {
        this.mContext = mContext;
        this.locationsList = locationsList;
        this.mainRecyclerView = mainRecyclerView;
    }
    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
        notifyDataSetChanged();
    }


    public List<Character> getCharacterList() {
        return characterList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.location_item, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(locationsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return locationsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ArrayList<String> links = new ArrayList<String>();

            RickLocations rickLocations = locationsList.get(position);
            for (int i = 0; i < rickLocations.getResidents().size(); i++) {

                if (rickLocations.getResidents().isEmpty() != true) {

                    url = String.valueOf(rickLocations.getResidents().get(i));
                    Log.d("pos", url);
                    links.add(url);
                }


            }
            for (String link : links) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://rickandmortyapi.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                LocationsApi api = retrofit.create(LocationsApi.class);
                Call<Character> call = api.getCharacters(link);
                call.enqueue(new Callback<Character>() {
                    @Override
                    public void onResponse(Call<Character> call, Response<Character> response) {
                        if (response.isSuccessful()) {
                            Character character = response.body();
                            characterList.add(character);
                            setCharacterList(characterList);
                            String riko=null;
                            Log.d(riko, character.getName());



                        }
                    }

                    @Override
                    public void onFailure(Call<Character> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }

            Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();

        }
    }
}





*/




public  class Horadapter extends RecyclerView.Adapter<Horadapter.MyViewHolder> {

    public List<Character> getCharacterList() {
        return characterList;
    }
private RecyclerView review;
    private  Context mContext;
    private List<RickLocations>locationsList;
    private List<Character> characterList = new ArrayList<>();
    String  url;
    public Horadapter(Context mContext, List<RickLocations> locationsList, RecyclerView review) {
        this.mContext = mContext;
        this.locationsList = locationsList;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v;
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.location_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.title.setText(locationsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return locationsList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            title=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            ArrayList<String>links=new ArrayList<String>();
            MainActivity obj= new MainActivity();
         //
               RickLocations rickLocations=locationsList.get(position);
                for(int i=0;i<rickLocations.getResidents().size();i++){

                    if (rickLocations.getResidents().isEmpty() != true) {

                        url = String.valueOf(rickLocations.getResidents().get(i));
                        Log.d("pos", url);
                        links.add(url);
                    }


                }
                        for (String link:links) {
                            Retrofit retrofit= new Retrofit.Builder()
                                    .baseUrl("https://rickandmortyapi.com/api/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

                            LocationsApi api=retrofit.create(LocationsApi.class);
                            Call<Character> call=api.getCharacters(link);
                     call.enqueue(new Callback<Character>() {
                         @Override
                         public void onResponse(Call<Character> call, Response<Character> response) {
                             if(response.isSuccessful()){
                                Character character= response.body();

            characterList.add(character);




                                     Log.d("riko",character.getName());

                                 }




                             }
                      //   }

                         @Override
                         public void onFailure(Call<Character> call, Throwable t) {
t.printStackTrace();
                         }
                     });


                        }





            Toast.makeText(mContext,"position"+position,Toast.LENGTH_SHORT).show();


        }
    }


}

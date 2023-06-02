package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Characteradapter extends RecyclerView.Adapter<Characteradapter.MyViewHolder> {
    private Context mContext;
    private List<Character>charactersList;
    String  url;
    public Characteradapter(Context mContext, List<Character> charactersList) {
        this.mContext = mContext;
        this.charactersList = charactersList;

    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi;
        LayoutInflater layoutInflate= LayoutInflater.from(mContext);
        vi=layoutInflate.inflate(R.layout.character_item,parent,false);
        return new MyViewHolder(vi);

    }
    @Override
    public void onBindViewHolder(@NonNull Characteradapter.MyViewHolder holder, int position) {
        holder.chars.setText(charactersList.get(position).getName());
    }
    public int getItemCount() {
        return charactersList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView chars;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            chars=itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }}

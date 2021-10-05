package com.example.lab02_animation_nvhung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMusic extends RecyclerView.Adapter<AdapterMusic.ViewHolder> {

    private Context mContext;
    private ArrayList<music> mHeros;
    private onClickListener mClickListener;

    public interface onClickListener {
        void onItemClick(int position);
    }

    public void setOnClick(onClickListener listener){
        this.mClickListener = listener;
    }

    public AdapterMusic(Context mContext, ArrayList<music> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.list_music, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView, mClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        music mssic = mHeros.get(position);

        holder.imgAVT.setImageResource(mssic.getImg());
        holder.tvNameMu.setText(mssic.getMusicName());
        holder.tvNameAu.setText(mssic.getAuthorName());
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAVT;
        private TextView tvNameMu;
        private TextView tvNameAu;

        public ViewHolder(@NonNull View itemView,onClickListener listener) {
            super(itemView);
            imgAVT = itemView.findViewById(R.id.imgAVT);
            tvNameMu = itemView.findViewById(R.id.tvNameMu);
            tvNameAu = itemView.findViewById(R.id.tvNameAu);

            imgAVT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mClickListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mClickListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}

package com.enes.krypto.adaptir;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.krypto.R;
import com.enes.krypto.model.cryptomodel;

import java.util.ArrayList;
import java.util.List;

public class adaptir extends RecyclerView.Adapter<adaptir.row> {
    private ArrayList<cryptomodel> cryptomodelArrayList;
    private String[] colors = {"#DFFF00","#FFBF00","#6495ED","#CCCCFF","#DE3163","#9FE2BF","#FF0000","#808080","#000080","#800080"};

    public adaptir (ArrayList<cryptomodel> cryptomodelArrayList){
        this.cryptomodelArrayList = cryptomodelArrayList ;
    }

    @NonNull
    @Override
    public row onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new row(view);
    }

    @Override
    public void onBindViewHolder(@NonNull row holder, int position) {
        holder.bind(cryptomodelArrayList.get(position),colors,position);  //reclerviewa krypto paralarımız ve tutarları gönderdik renkerle birlikte
    }

    @Override
    public int getItemCount() {
        return cryptomodelArrayList.size();
    }


    public class row extends RecyclerView.ViewHolder {
        TextView text_name;
        TextView text_price;

        public row(@NonNull View itemView) {
            super(itemView);

            text_name = itemView.findViewById(R.id.text_name);
            text_price = itemView.findViewById(R.id.text_price);



        }
        public void bind(cryptomodel cryptomodel,String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position % 10]));
            text_name = itemView.findViewById(R.id.text_name);
            text_price = itemView.findViewById(R.id.text_price);

            text_name.setText(cryptomodel.getCurrency());
            text_price.setText(cryptomodel.getPrice());


        }
    }


}

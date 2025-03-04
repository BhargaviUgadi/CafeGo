package com.example.shoppingappliaction;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class CoffeListRecyclerView extends RecyclerView.Adapter<CoffeListRecyclerView.ViewHolder> {

    private List<String> coffee_name;
    private Context context1;
    private int selectedPosition = -1;
    private CoffeeName coffeeNameListener;
    boolean isCoffeePosition;
    String coffeeName;
    public CoffeListRecyclerView(List<String> coffee_list,String coffeeName ,boolean isCoffee, Context context, CoffeeName coffeeNameListener) {
        this.coffee_name = coffee_list;
        this.context1 = context;
        this.coffeeName = coffeeName;
        this.isCoffeePosition = isCoffee;
        this.coffeeNameListener = coffeeNameListener;
    }

    @NonNull
    @Override
    public CoffeListRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeListRecyclerView.ViewHolder holder, int position) {
        holder.coffe_name_tv.setText(coffee_name.get(position));

//        if(!coffeeName.isEmpty() && coffeeName != null){
            if(isCoffeePosition){
                isCoffeePosition =false;
                holder.coffe_name_tv.setTextColor(Color.WHITE);
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context1, R.color.orange));
                coffeeNameListener.setcoffeeName(coffee_name.get(position),"");

            }
            else {
                if (position == selectedPosition) {
                    holder.coffe_name_tv.setTextColor(Color.WHITE);
                    holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context1, R.color.orange));
                } else {
                    holder.coffe_name_tv.setTextColor(Color.BLACK);
                    holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context1, R.color.white));
                }
            }

//        }
//        else {
//            for (int i = 0; i < coffee_name.size(); i++) {
//                if (coffee_name.get(i) == coffeeName) {
//                    selectedPosition = position;
//                    Log.e("SlectedPostition",selectedPosition+"");
//                    // break;  // uncomment to get the first instance
//                }
//            }
//
//        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                notifyDataSetChanged();

                if (coffeeNameListener != null) {
                    coffeeNameListener.setcoffeeName(coffee_name.get(position),"");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return coffee_name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView coffe_name_tv;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coffe_name_tv = itemView.findViewById(R.id.coffee_name_tv);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}

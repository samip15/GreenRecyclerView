package com.example.greenrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {
    private static final String TAG = "GreenAdapter";
    //total no of items
    private int mNumberItems;

    public GreenAdapter(int numberItems) {
        mNumberItems = numberItems;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
       int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(layoutIdForListItem,viewGroup,false);
        NumberViewHolder numberViewHolder = new NumberViewHolder(view);
        return numberViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: #"+position );
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumtv;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemNumtv = itemView.findViewById(R.id.tv_item_number);
        }
        void bind(int listIndex){
            listItemNumtv.setText(String.valueOf(listIndex));
        }
    }
}
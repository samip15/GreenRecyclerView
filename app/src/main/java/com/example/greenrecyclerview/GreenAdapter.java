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
    //view holder counts
    private static int VIEW_HOLDER_COUNT;

    //item list

    final private ListClickListner mOnclickListner;

    public GreenAdapter(int numberItems, ListClickListner OnclickListner) {
        mNumberItems = numberItems;
        VIEW_HOLDER_COUNT = 0;
        mOnclickListner = OnclickListner;
    }

    public interface ListClickListner {
        void onListItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        NumberViewHolder numberViewHolder = new NumberViewHolder(view);
        numberViewHolder.viewHolderIndex.setText("View holder Index" + VIEW_HOLDER_COUNT);
        int backgroundColorForViewHolder = ColorUtils.getViewHolderBackgroundColorFromInstance(context, VIEW_HOLDER_COUNT);
        numberViewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);
        VIEW_HOLDER_COUNT++;
        Log.e(TAG, "onCreateViewHolder: number of view holder " + VIEW_HOLDER_COUNT);
        return numberViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {

        Log.e(TAG, "onBindViewHolder: #" + position);
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemNumtv, viewHolderIndex;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemNumtv = itemView.findViewById(R.id.tv_item_number);
            viewHolderIndex = itemView.findViewById(R.id.view_holder_instance);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            listItemNumtv.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View v) {
            int clickPosition =  getAdapterPosition();
            mOnclickListner.onListItemClick(clickPosition);
        }
    }
}

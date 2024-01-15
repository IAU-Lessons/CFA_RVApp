package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    IElementClickListener elementClickListener;

    Context context;
    List<DataModel> list;

    public DataAdapter(Context context, List<DataModel> list,IElementClickListener elementClickListener){
        this.context = context;
        this.list = list;
        this.elementClickListener = elementClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.elementview, parent, false);
        ProductViewHolder holder = new ProductViewHolder(view, this.elementClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        DataModel model = this.list.get(position);
        holder.setDatas(model);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

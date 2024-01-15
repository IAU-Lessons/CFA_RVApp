package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    IElementClickListener elementClickListener;

    ImageView productIv;
    TextView productNameField;
    TextView productPriceField;

    Button addCartBtn;

    public ProductViewHolder(@NonNull View itemView, IElementClickListener elementClickListener) {
        super(itemView);
        this.elementClickListener = elementClickListener;
        productIv = itemView.findViewById(R.id.productImageView);
        productNameField = itemView.findViewById(R.id.productNameField);
        productPriceField = itemView.findViewById(R.id.productPriceField);
        addCartBtn = itemView.findViewById(R.id.addCart);
        addCartBtn.setOnClickListener(this);
    }

    public void setDatas(DataModel data){
        productIv.setImageDrawable(data.GetImage());
        productNameField.setText(data.GetName());
        productPriceField.setText(data.GetPrice());
    }

    @Override
    public void onClick(View view) {
        int pos = getLayoutPosition();
        this.elementClickListener.ElementClicked(pos);
    }
}

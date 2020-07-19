package com.noura.anwar.new4shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noura.anwar.new4shop.Moodle.Item;
import com.noura.anwar.new4shop.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private Context context;
    private List<Item> itemList;
    private int layout = -1;
    private boolean isMostRequest = false;

    public ItemAdapter(List<Item>items){
        this.itemList = items ;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      this.context = parent.getContext();
      if (layout!=-1){
          return new ItemViewHolder(LayoutInflater.from(context).inflate(layout,null,false));
      }else{
          return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.items,null,false));
      }
    }
    public void setLayout(int layout) {
        this.layout = layout;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.imgProduct.setBackgroundResource(itemList.get(position).getImage());
        if (isMostRequest && position == 0) {
            holder.shadowColor.setVisibility(View.VISIBLE);
            holder.tvTitle.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

public void setMostRequest(boolean isMostRequest){
        this.isMostRequest = isMostRequest;

}

public class ItemViewHolder extends RecyclerView.ViewHolder{
    TextView tvTitle, tvCategory, tvPrice;
    ImageView imgProduct;
    View shadowColor;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_product_title);
       // tvCategory = itemView.findViewById(R.id.tv_product_category);
        tvPrice = itemView.findViewById(R.id.tv_product_price);
        imgProduct = itemView.findViewById(R.id.img_product);
        shadowColor = itemView.findViewById(R.id.view_shadow);

    }
}
}

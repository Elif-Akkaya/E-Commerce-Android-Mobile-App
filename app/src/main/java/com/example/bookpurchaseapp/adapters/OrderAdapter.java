package com.example.bookpurchaseapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookpurchaseapp.DBHelper;
import com.example.bookpurchaseapp.R;
import com.example.bookpurchaseapp.ReceiveOrderActivity;
import com.example.bookpurchaseapp.models.Order_Model;
import com.example.bookpurchaseapp.models.Main_Model;
import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<Order_Model> list;
    Context cont;

    public OrderAdapter(ArrayList<Order_Model> list, Context cont) {
        this.list = list;
        this.cont = cont;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.sample_order,parent,false);
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        final Order_Model model = list.get (position);
        holder.image_book.setImageResource(model.getImage_book());
        holder.name_book.setText(model.getName_book());
        holder.name_author.setText(model.getName_author());
        holder.order_no.setText(model.getOrder_no());
        holder.price_book.setText(model.getPrice_book());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                DBHelper helper = new DBHelper(cont);
               if(helper.deletedOrders(model.getOrder_no())>0){
                   Toast.makeText(cont,"Deleted",Toast.LENGTH_SHORT).show();
               }
                else{
                    Toast.makeText(cont,"Error",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_book;
        TextView name_book, name_author, order_no, price_book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_book = itemView.findViewById(R.id.image_book);
            name_book = itemView.findViewById(R.id.name_book);
            name_author = itemView.findViewById(R.id.name_author);
            order_no = itemView.findViewById(R.id.order_no);
            price_book = itemView.findViewById(R.id.price_book);
        }
    }

}

package com.example.bookpurchaseapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bookpurchaseapp.R;
import com.example.bookpurchaseapp.ReceiveOrderActivity;
import com.example.bookpurchaseapp.models.Main_Model;

import java.util.ArrayList;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<Main_Model> list;
    Context cont;

    public MainAdapter(ArrayList<Main_Model> list, Context cont) {
        this.list = list;
        this.cont = cont;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.example_book_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Main_Model model = list.get (position);
        holder.image_book.setImageResource(model.getImage_book());
        holder.book_name.setText(model.getBook_name());
        holder.author_name.setText(model.getAuthor_name());
        holder.price.setText(model.getPrice());
        holder.category.setText(model.getCategory());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cont, ReceiveOrderActivity.class);
                intent.putExtra("image", model.getImage_book());
                intent.putExtra("book_name", model.getBook_name());
                intent.putExtra("author_name", model.getAuthor_name());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("category", model.getCategory());
                intent.putExtra("language", model.getLanguage());
                cont.startActivity(intent);
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
        TextView book_name,author_name, price, category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_book = itemView.findViewById(R.id.image_book);
            book_name = itemView.findViewById(R.id.text_book_name);
            author_name = itemView.findViewById(R.id.text_author_name);
            price = itemView.findViewById(R.id.text_price);
            category = itemView.findViewById(R.id.text_category);


        }
    }
}

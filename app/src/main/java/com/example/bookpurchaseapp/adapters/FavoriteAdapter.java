package com.example.bookpurchaseapp.adapters;

import android.content.Context;
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
import com.example.bookpurchaseapp.models.Favorite_Model;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    ArrayList<Favorite_Model> list;
    Context cont;

    public FavoriteAdapter(ArrayList<Favorite_Model> list, Context cont) {
        this.list = list;
        this.cont = cont;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.sample_favorite__model,parent,false);
        return new FavoriteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        final Favorite_Model model = list.get (position);
        holder.image_book.setImageResource(model.getImage_book());
        holder.book_name.setText(model.getBook_name());
        holder.author_name.setText(model.getAuthor_name());
        holder.price.setText(model.getPrice());
        holder.category.setText(model.getCategory());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DBHelper helper_a = new DBHelper(cont);
                if(helper_a.deletedFavorites(model.getId())>0){
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
    public int getItemCount() {
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

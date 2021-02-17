package com.example.bookpurchaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.bookpurchaseapp.adapters.FavoriteAdapter;
import com.example.bookpurchaseapp.adapters.MainAdapter;
import com.example.bookpurchaseapp.databinding.ActivityFavoriteBinding;
import com.example.bookpurchaseapp.databinding.ActivityMainBinding;
import com.example.bookpurchaseapp.models.Favorite_Model;
import com.example.bookpurchaseapp.models.Main_Model;
import com.example.bookpurchaseapp.models.Order_Model;

import java.util.ArrayList;

public class ActivityFavorite extends AppCompatActivity {

    ActivityFavoriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper_a = new DBHelper(this);
        ArrayList<Favorite_Model> list = helper_a.getFavorites();

        FavoriteAdapter adapter = new FavoriteAdapter(list, this);
        binding.favoriteRw.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.favoriteRw.setLayoutManager(layoutManager);
    }
}

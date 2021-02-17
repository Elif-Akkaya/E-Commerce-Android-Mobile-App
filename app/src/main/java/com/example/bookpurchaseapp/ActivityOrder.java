package com.example.bookpurchaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.bookpurchaseapp.adapters.OrderAdapter;
import com.example.bookpurchaseapp.adapters.MainAdapter;
import com.example.bookpurchaseapp.databinding.ActivityOrderBinding;
import com.example.bookpurchaseapp.models.Order_Model;
import com.example.bookpurchaseapp.models.Main_Model;

import java.util.ArrayList;

public class ActivityOrder extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<Order_Model> list = helper.getOrders();

        OrderAdapter adapter = new OrderAdapter(list, this);
        binding.orderRw.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRw.setLayoutManager(layoutManager);
    }
}
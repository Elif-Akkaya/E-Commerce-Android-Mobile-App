package com.example.bookpurchaseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookpurchaseapp.databinding.ActivityMainBinding;
import com.example.bookpurchaseapp.databinding.ActivityReceiveOrderBinding;

import static android.view.Gravity.CENTER;

public class ReceiveOrderActivity extends AppCompatActivity {

    ActivityReceiveOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReceiveOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image", 0);
        final int description = getIntent().getIntExtra("description", 0);
        final String book_name = getIntent().getStringExtra("book_name");
        final String author_name = getIntent().getStringExtra("author_name");
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String language = getIntent().getStringExtra("language");
        final String category = getIntent().getStringExtra("category");

        binding.nextImage.setImageResource(image);
        binding.nextPrice.setText(String.format("%d", price));
        binding.nextName.setText(book_name);
        binding.nextAuthor.setText(author_name);
        binding.description.setText(description);
        binding.language.setText(language);
        binding.category.setText(category);

        final DBHelper helper = new DBHelper(this);
        binding.buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertOrder(binding.editName.getText().toString(), binding.editAddress.getText().toString(),
                        binding.editTextPhone.getText().toString(), price,
                        Integer.parseInt(binding.numberOfOrder.getText().toString()),
                        image, book_name, author_name, description, language);
                if (isInserted){
                    Toast.makeText(ReceiveOrderActivity.this, "Your order has been taken",Toast.LENGTH_SHORT).show();
            }
                else
                    Toast.makeText(ReceiveOrderActivity.this, "Error",Toast.LENGTH_SHORT).show();
        }
    });
        final DBHelper helper_a = new DBHelper(this);
        binding.buttonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper_a.insertFavorite(binding.editName.getText().toString(),
                        binding.editTextPhone.getText().toString(), price,
                        image, book_name, author_name, description, category);
                if (isInserted){
                    Toast.makeText(ReceiveOrderActivity.this, "Your favorite has been added",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(ReceiveOrderActivity.this, "Error",Toast.LENGTH_SHORT).show();
            }
        });
}}
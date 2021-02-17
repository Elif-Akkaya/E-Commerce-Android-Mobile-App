package com.example.bookpurchaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.bookpurchaseapp.adapters.MainAdapter;
import com.example.bookpurchaseapp.databinding.ActivityMainBinding;
import com.example.bookpurchaseapp.models.Main_Model;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Main_Model> list = new ArrayList<>();
        list.add(new Main_Model(R.drawable.yuzuklerin_efendisi, "YÜZÜKLERİN EFENDİSİ", "J.R.R Tolkien","100", "Science Fiction",R.string.description_yuzuklerin_efendisi, "Turkish"));
        list.add(new Main_Model(R.drawable.dogu_expresinde_cinayet,"DOĞU EXPRESİNDE CİNAYET", "Agatha Christie","20", "Whodunit",R.string.description_dogu_ekspresinde_cinayet,"Turkish"));
        list.add(new Main_Model(R.drawable.harry_potter_series, "HARRY POTTER SERIES", "J.K Rowling","630", "Science Fiction",R.string.description_harry_potter_series,"English"));
        list.add(new Main_Model(R.drawable.kurk_mantolu_madonna, "KÜRK MANTOLU MADONNA", "Sabahattin Ali","10", "Novel",R.string.description_kurk_mantolu_madonna,"Turkish"));
        list.add(new Main_Model(R.drawable.kuyucakli_yusuf, "KUYUCAKLI YUSUF", "Sabahattin Ali","8", "Novel",R.string.description_kuyucaklı_yusuf,"Turkish"));
        list.add(new Main_Model(R.drawable.seker_portakali_serisi, "ŞEKER PORTAKALI SERİSİ", "Jose Marue De Vasconcelos","48", "Novel",R.string.description_seker_portakalı_serisi, "Turkish"));
        list.add(new Main_Model(R.drawable.suc_ve_ceza, "SUÇ VE CEZA", "Fyodor Dostoyevski","20", "Novel",R.string.description_suc_ve_ceza,"Turkish"));
        list.add(new Main_Model(R.drawable.yeraltindan_notlar, "YERALTINDAN NOTLAR", "Fyodor Dostoyevski","11", "Novel",R.string.description_yeraltindan_notlar,"Turkish"));
        list.add(new Main_Model(R.drawable.hayatadon, "HAYATA DÖN", "Gülseren Budayıcıoğlu","35", "Psychology",R.string.description_hayata_don,"Turkish"));
        list.add(new Main_Model(R.drawable.bir_psikiyatristin_gizli_defteri, "BİR PSİKİYATRİSTİN GİZLİ DEFTERİ", "Garry Small & Gigi Vorgan","37", "Psychology",R.string.description_bir_psikiyatristin_gizli_defteri,"Turkish"));
        list.add(new Main_Model(R.drawable.ruh_koleksiyoncusu, "RUH KOLEKSİYONCUSU", "Tess Gerritsen","36", "Whodunit",R.string.description_ruh_koleksiyoncusu,"Turkish"));
        list.add(new Main_Model(R.drawable.the_little_prince, "THE LITTLE PRINCE", "Antoine de Saint_Exupery","5", "Story",R.string.description_little_prince,"English"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.RecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.RecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, ActivityOrder.class));
                break;
            case R.id.favorites:
                startActivity(new Intent(MainActivity.this, ActivityFavorite.class));
                break;
            case R.id.aboutus:
                startActivity(new Intent(MainActivity.this, AboutUs.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.dictionaryapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dictionaryapp.R;
import com.example.dictionaryapp.database.DatabaseAccess;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvDict;
    private static final String DATABASE1 = "anh_viet.db";
    private static final String DATABASE2 = "viet_anh.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDict = findViewById(R.id.lv_dic);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this, DATABASE1);
        databaseAccess.open();
        List<String> words = databaseAccess.getAnhViet();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        lvDict.setAdapter(adapter);
    }
}
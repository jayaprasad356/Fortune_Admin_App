package com.app.fortuneadmin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fortuneadmin.OnSelectedListener;
import com.app.fortuneadmin.adapters.FavAdapter;
import com.app.fortuneadmin.models.Messages;

import java.util.ArrayList;

public class FavoriteMessageActivity extends AppCompatActivity {
    Activity activity;
    OnSelectedListener onSelectedListener;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_message);
        activity=FavoriteMessageActivity.this;
        onSelectedListener=new OnSelectedListener() {
            @Override
            public void onSingleMessageSelected(String Message) {
                Intent intent = new Intent();
                intent.putExtra("message", Message);
                setResult(101, intent);
                finish();
            }

            @Override
            public void onMultiMessageSelected(ArrayList message) {
                Intent intent = new Intent();
                intent.putExtra("message", message);
                setResult(102, intent);
                finish();
            }
        };
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        sendButton=findViewById(R.id.sendButton);

        ArrayList<Messages> modelMessages = new ArrayList<>();
        modelMessages.add(new Messages("Hello World!"));
        modelMessages.add(new Messages("How are you?"));
        modelMessages.add(new Messages("I am" ));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

        FavAdapter adapter = new FavAdapter(modelMessages,onSelectedListener,activity,sendButton);
        recyclerView.setAdapter(adapter);
    }

}
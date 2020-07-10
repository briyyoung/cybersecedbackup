package com.example.cyberseced;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LearningEntry extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static final String CHOICE = "ggg";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button frmBtn;
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_entry);

        startRecyclerView();

        bottomNavigation = findViewById(R.id.navigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(this);


    }

    private void startRecyclerView() {
        mRecyclerView = findViewById(R.id.mainActivityView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        LearningAdapter.RecyclerViewClickListener listener = new LearningAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Modules modules = Modules.getModules().get(position);
                Intent intent = new Intent(LearningEntry.this, LearningHome.class);
                intent.putExtra(CHOICE, modules.getName());

                startActivity(intent);

            }
        };

        mAdapter = new LearningAdapter(Modules.getModules(), listener);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.navigation_home:
                Intent intent2 = new Intent(LearningEntry.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.navigation_quiz:
                Intent intent3 = new Intent(LearningEntry.this, Quiz.class);
                startActivity(intent3);
                break;
            case  R.id.navigation_forum:
                Intent intent1 = new Intent(LearningEntry.this, ForumHome.class);
                startActivity(intent1);
                break;
        }


        return false;
    }
}
package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickedListener {

    private ArrayList<Person> personList;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();

        recyclerView = findViewById(R.id.recyclerview_list);

        personAdapter = new PersonAdapter(personList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personAdapter);

    }

    private ArrayList<Person> generateData(){

        personList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Person person = new Person("firstname" + i, "lastname" + i, i);
            personList.add(person);
        }
        Log.i(TAG, "firstname: " + personList.get(3).getFirstName());
        return personList;
    }

    @Override
    public void onItemClicked(Person person) {

        Toast.makeText(this,"person name is " + person.getFirstName(), Toast.LENGTH_LONG).show();

    }
}

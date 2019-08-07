package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> personArrayList;
    private OnPersonClickedListener listener;

    //initialize the above two member variables inside the class constructor
    public PersonAdapter(ArrayList<Person> personArrayList, OnPersonClickedListener listener) {
        this.personArrayList = personArrayList;
        this.listener = listener;
    }

    //create the viewholder object passing it the layout reference and the listener
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new PersonViewHolder(view);
    }

    //bind the view holder to the data from a given position on the list
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        Person person = personArrayList.get(position);
        holder.tvFirstname.setText(person.getFirstName());
        holder.tvLastname.setText(person.getLastName());
        holder.tvAge.setText(String.valueOf(person.getAge()));
        holder.bind(person, listener);
    }

    //get the total item count
    @Override
    public int getItemCount() {

        return personArrayList.size();
    }


    //the view holder is the backbone of the recyclerview adapter as it
    // provides the references to the child view to display the data.
    public class PersonViewHolder extends RecyclerView.ViewHolder {

        public TextView tvFirstname;
        public TextView tvLastname;
        public TextView tvAge;


        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstname = itemView.findViewById(R.id.tv_firstname);
            tvLastname = itemView.findViewById(R.id.tv_lastname);
            tvAge = itemView.findViewById(R.id.tv_age);
        }

        public void bind(final Person person, final OnPersonClickedListener listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(person);
                }
            });
        }
    }

    public interface OnPersonClickedListener{

        void onItemClicked(Person person);
    }
}

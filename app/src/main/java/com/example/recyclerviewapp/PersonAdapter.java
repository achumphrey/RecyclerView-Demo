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
    private OnPersonClickedListener onPersonClickedListener;

    //initialize the above two member variables inside the class constructor
    public PersonAdapter(ArrayList<Person> personArrayList, OnPersonClickedListener onPersonClickedListener) {
        this.personArrayList = personArrayList;
        this.onPersonClickedListener = onPersonClickedListener;
    }

    //create the viewholder object passing it the layout reference and the listener
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new PersonViewHolder(view, onPersonClickedListener);
    }

    //bind the view holder to the data from a given position on the list
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        Person person = personArrayList.get(position);
        holder.tvFirstname.setText(person.getFirstName());
        holder.tvLastname.setText(person.getLastName());
        holder.tvAge.setText(String.valueOf(person.getAge()));
    }

    //get the total item count
    @Override
    public int getItemCount() {

        return personArrayList.size();
    }


    //the view holder is the backbone of the recyclerview adapter as it
    // provides the references to the child view to display the data.
    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvFirstname;
        public TextView tvLastname;
        public TextView tvAge;
        public OnPersonClickedListener onPersonClickedListener;

        public PersonViewHolder(@NonNull View itemView, OnPersonClickedListener onPersonClickedListener) {
            super(itemView);
            tvFirstname = itemView.findViewById(R.id.tv_firstname);
            tvLastname = itemView.findViewById(R.id.tv_lastname);
            tvAge = itemView.findViewById(R.id.tv_age);
            this.onPersonClickedListener = onPersonClickedListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Person person = personArrayList.get(getAdapterPosition());
            onPersonClickedListener.onItemClicked(person);
        }
    }

    public interface OnPersonClickedListener{

        void onItemClicked(Person person);
    }
}

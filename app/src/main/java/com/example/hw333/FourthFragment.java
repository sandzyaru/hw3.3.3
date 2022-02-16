package com.example.hw333;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FourthFragment extends Fragment {
    private Button btnNextFragment;
    private TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle chemodan =getArguments();
        name=view.findViewById(R.id.name3);
        if (chemodan!=null){
            String name=chemodan.getString("key2");
            this.name.setText(name);
        }
        btnNextFragment=view.findViewById(R.id.next_fragment);
        btnNextFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Fragment fragmentFifth = new FifthFragment();
                fragmentFifth.setArguments(chemodan);
                chemodan.putString("key3",name.getText().toString());
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container3,fragmentFifth).
                        addToBackStack("").commit();
            }
        });
    }
}
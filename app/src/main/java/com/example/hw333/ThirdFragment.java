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

public class ThirdFragment extends Fragment {
    private Button btnNextFragment;
    private TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle chemodan =getArguments();
        name=view.findViewById(R.id.name2);
        if (chemodan!=null){
            String name=chemodan.getString("key1");
            this.name.setText(name);
        }
        btnNextFragment=view.findViewById(R.id.next_fragment2);
        btnNextFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Fragment fragmentFourth = new FourthFragment();
                chemodan.putString("key2",name.getText().toString());
                fragmentFourth.setArguments(chemodan);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentFourth).
                        addToBackStack("").commit();
            }
        });
    }
}
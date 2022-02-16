package com.example.hw333;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFragment extends Fragment {
    private Button btnNextFragment;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNextFragment=view.findViewById(R.id.next_fragment);
        editText=view.findViewById(R.id.edit_text);
        Bundle chemodan = new Bundle();
        chemodan.putString("key",editText.getText().toString());
        Fragment fragmentSecond = new SecondFragment();
        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentSecond.setArguments(chemodan);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentSecond).
                        addToBackStack("").commit();
            }
        });
    }
}
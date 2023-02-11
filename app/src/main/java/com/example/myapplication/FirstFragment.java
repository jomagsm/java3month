package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private TextView resultText;
    public static final String KEY_FOR_RESULT = "k";
    private Button plusBtn, minusBtn, getResultBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initListener();
    }

    private void init() {
        resultText = requireActivity().findViewById(R.id.ff_textview);
        resultText.setText("0");
        plusBtn = requireActivity().findViewById(R.id.ff_plus_btn);
        minusBtn = requireActivity().findViewById(R.id.ff_minus_btn);
        getResultBtn = requireActivity().findViewById(R.id.ff_get_result_btn);
    }

    private void initListener() {
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer resultInteger = Integer.parseInt(resultText.getText().toString());
                resultInteger++;
                resultText.setText(resultInteger.toString());
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer resultInteger = Integer.parseInt(resultText.getText().toString());
                resultInteger--;
                resultText.setText(resultInteger.toString());
            }
        });
        getResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_FOR_RESULT, resultText.getText().toString());
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, secondFragment).addToBackStack(null).commit();
            }
        });
    }
}
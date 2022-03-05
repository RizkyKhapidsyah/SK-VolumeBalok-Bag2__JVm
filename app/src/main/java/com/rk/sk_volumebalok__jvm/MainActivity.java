package com.rk.sk_volumebalok__jvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    private static final String STATE_RESULT = "Pertahankan_Isi_Inputan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String pertahananDataInput = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(pertahananDataInput);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean apakahInputKosong = false;

            if (TextUtils.isEmpty(inputLength)) {
                apakahInputKosong = true;
                edtLength.setError("Harap diisi nilai Panjang!");
                edtLength.requestFocus();
            }

            if (TextUtils.isEmpty(inputWidth)) {
                apakahInputKosong = true;
                edtWidth.setError("Harap diisi nilai Lebar!");
                edtWidth.requestFocus();
            }

            if (TextUtils.isEmpty(inputHeight)) {
                apakahInputKosong = true;
                edtHeight.setError("Harap diisi nilai Tinggi!");
                edtHeight.requestFocus();
            }

            if (!apakahInputKosong) {
                double volume = Double.valueOf(inputLength) * Double.valueOf(inputWidth) * Double.valueOf(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
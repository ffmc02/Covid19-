package com.example.covidstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidstats.datafetch.CovidApi;
import com.example.covidstats.datafetch.model.GlobalData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.covidstats.MESSAGE";
    ProgressBar progressBar;
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        progressBar = findViewById(R.id.ProgresGlobal);
        editText = findViewById(R.id.editTextCountry);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi covidApi = retrofit.create(CovidApi.class);
        covidApi.getGlobalData()
                .enqueue(new Callback<GlobalData>() {
                    @Override
                    public void onResponse(Call<GlobalData> call, Response<GlobalData> response) {
                        textView.setText(response.body().toString());
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<GlobalData> call, Throwable t) {
                        System.out.println(t);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            String country = editText.getText().toString();
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            intent.putExtra(EXTRA_MESSAGE, country);
            startActivity(intent);
        }
    }

    public void LENGTH_SHORT(View view)

    {
        Toast.makeText(getApplicationContext(), "World = monde, France, USA = état unis, Spain= espagne, Italy= italie, \n" +
                "        Germany =allemangne, Peru= Perou, Belgium= belgique, Japan=Japon \n" +
                "        et bien d\'autre \n  si vous souhaitez un autre pays mette son Nom  en anglais Et la Premiere lettre en capital", Toast.LENGTH_LONG).show();
    }

}
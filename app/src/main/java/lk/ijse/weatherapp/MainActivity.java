package lk.ijse.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import lk.ijse.weatherapp.Retrofit.ApiClient;
import lk.ijse.weatherapp.Retrofit.ApiInterface;
import lk.ijse.weatherapp.Retrofit.Example;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView search;
    TextView tempText,humidityText,descText,countryText,time;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=findViewById(R.id.searchBtn);
        tempText=findViewById(R.id.tempText);
        humidityText=findViewById(R.id.humidityText);
        descText=findViewById(R.id.descText);
        editText=findViewById(R.id.textField);
        countryText=findViewById(R.id.countryText);
        time=findViewById(R.id.timeText);

        search. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we call API
                getWeaherData(editText.getText().toString().trim());
            }
        });
    }

    private void getWeaherData(String name){
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call = apiInterface.getWeatherData(name);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                tempText.setText("Temp :"+" "+response.body().getMain().getTemp()+" °C");
                descText.setText("Feels Like :"+" "+response.body().getMain().getFeels_like());
                humidityText.setText("Humidity :"+" "+response.body().getMain().getHumidity());
                countryText.setText("Country Name :"+""+response.body().getSystem().getCountry());

                //find date & time
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat std = new SimpleDateFormat("HH:mm a \nE, MMM dd yyyy");
                String date = std.format(calendar.getTime());
                time.setText("Time and Date :"+" "+date);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

}
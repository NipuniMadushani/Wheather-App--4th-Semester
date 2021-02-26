package lk.ijse.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class System {
    @SerializedName("country")
    String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

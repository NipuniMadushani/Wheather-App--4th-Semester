package lk.ijse.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("main")
    private Main main;

    @SerializedName("sys")
    private System system;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }
}

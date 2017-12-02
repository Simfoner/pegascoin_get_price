import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://stocks.exchange")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Request getTicker() {
        return getRetrofitInstance().create(Request.class);
    }
}
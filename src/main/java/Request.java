
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.ArrayList;


public interface Request {
    @GET("/api2/ticker")
    Call<ArrayList<Market>> getTicker();

}
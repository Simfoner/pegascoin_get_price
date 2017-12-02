import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketList {
    @SerializedName("")
    private List<Market> markets;

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }
}



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Market {

    @SerializedName("min_order_amount")
    @Expose
    private String minOrderAmount;
    @SerializedName("ask")
    @Expose
    private String ask;
    @SerializedName("bid")
    @Expose
    private String bid;
    @SerializedName("last")
    @Expose
    private String last;
    @SerializedName("lastDayAgo")
    @Expose
    private String lastDayAgo;
    @SerializedName("vol")
    @Expose
    private String vol;
    @SerializedName("spread")
    @Expose
    private String spread;
    @SerializedName("buy_fee_percent")
    @Expose
    private String buyFeePercent;
    @SerializedName("sell_fee_percent")
    @Expose
    private String sellFeePercent;
    @SerializedName("market_name")
    @Expose
    private String marketName;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;
    @SerializedName("server_time")
    @Expose
    private String serverTime;

    public String getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(String minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLastDayAgo() {
        return lastDayAgo;
    }

    public void setLastDayAgo(String lastDayAgo) {
        this.lastDayAgo = lastDayAgo;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getBuyFeePercent() {
        return buyFeePercent;
    }

    public void setBuyFeePercent(String buyFeePercent) {
        this.buyFeePercent = buyFeePercent;
    }

    public String getSellFeePercent() {
        return sellFeePercent;
    }

    public void setSellFeePercent(String sellFeePercent) {
        this.sellFeePercent = sellFeePercent;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

}
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;

public class GetPriceBot implements IListener<MessageReceivedEvent>{
    public static final String GET_PRICE_BOT_TOKEN = "Mzg2MjY3OTQ3NjE1OTExOTM5.DQNdRA.KXd86vjMcv2UtLsnzKN5V8Uyz7Y";

    private IDiscordClient dscordClient;
    private boolean isConnected;
    private String lastPrice;

    public GetPriceBot(){
        this.isConnected = false;
    }

    private void regBot(){
        EventDispatcher dispatcher = dscordClient.getDispatcher();
        dispatcher.registerListener(this);
    }

    public void login() throws DiscordException{
        ClientBuilder cBuilder = new ClientBuilder();
        cBuilder.withToken(GetPriceBot.GET_PRICE_BOT_TOKEN);
        dscordClient = cBuilder.login();
        regBot();

        this.isConnected = true;
    }

    public void handle(final MessageReceivedEvent event){
        Request request = Services.getTicker();
        Call<ArrayList<Market>> call = request.getTicker();
        if(event.getMessage().getChannel().getName().equals("price")){
            if(event.getMessage().getContent().equals("/get price")){
                try{
                    call.enqueue(new Callback<ArrayList<Market>>() {
                        public void onResponse(Call<ArrayList<Market>> call, Response<ArrayList<Market>> response) {
                            lastPrice = "Last price: "+response.body().get(25).getLast()+" btc  Ask: "+response.body().get(25).getAsk()+" btc  Bid: "+response.body().get(25).getBid()+" btc";
                        }
                        public void onFailure(Call<ArrayList<Market>> call, Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    });
                    Thread.sleep(1000);
                    if(lastPrice!=null) {
                        new MessageBuilder(this.dscordClient).withChannel(event.getMessage().getChannel()).withContent(lastPrice).build();
                    }
                }
                catch(RateLimitException e){
                    System.err.println("Ошибка при отправке сообщения: " + e.getMessage());
                    e.printStackTrace();
                }
                catch(DiscordException e){
                    System.err.println("Ошибка при отправке сообщения: " + e.getMessage());
                    e.printStackTrace();
                }
                catch(MissingPermissionsException e){
                    System.err.println("Ошибка при отправке сообщения: " + e.getMessage());
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){

        GetPriceBot echoDiscordBot = new GetPriceBot();

        try{
            echoDiscordBot.login();
            System.out.println("Бот успешно подключен.");
        }
        catch(DiscordException e){
            System.err.println("Ошибка при подключении бота к Discord: " + e.getMessage());
        }
    }
}
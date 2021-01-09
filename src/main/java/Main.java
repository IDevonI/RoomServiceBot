import events.ChannelNames;
import events.JustChattingEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {
        JDA jda;
        //String token=System.getenv("TOKEN");
        try {
            jda = JDABuilder.createDefault("Nzk3MjM3Njg5NzAzMjAyODI2.X_jjdQ.TPvQni8vyLnjBkGopbYwyLwOEq0").enableIntents(GatewayIntent.GUILD_PRESENCES).build();
            jda.addEventListener(new JustChattingEvent());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}

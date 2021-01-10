import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {
        JDA jda;
        String token=System.getenv("TOKEN");
        try {
            jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.GUILD_PRESENCES).build();
            jda.addEventListener(new JustChattingEvent());
            jda.addEventListener(new LoLEvent());
            jda.addEventListener(new AmongUsEvent());
            jda.addEventListener(new ApexLegendsEvent());
            jda.addEventListener(new CounterStrikeEvent());
            jda.addEventListener(new DeadByDaylightEvent());
            jda.addEventListener(new MinecraftEvent());
            jda.addEventListener(new PhasmoEvent());
            jda.addEventListener(new RocketLeagueEvent());
            jda.addEventListener(new TfTEvent());
            jda.addEventListener(new ValorantEvent());
            jda.addEventListener(new WorldOfTanksEvent());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}

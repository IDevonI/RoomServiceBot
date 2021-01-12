package events;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import org.jetbrains.annotations.NotNull;
import utils.ChannelNames;

import java.util.Objects;


public class WorldOfTanksEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event)
    {
        new Thread(() -> {
            Guild guild = event.getMember().getGuild();
            String name;
            if (event.getChannelJoined().getId().equals("797304533528346674")) {
                boolean found = true;
                int i;
                for (i = 1; found; i++) {
                    found = ChannelNames.wot.contains(i);
                }
                ChannelNames.wot.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " WoT";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        new Thread(() -> {
            Guild guild = event.getMember().getGuild();
            String name;
            if (event.getChannelJoined().getId().equals("797304533528346674")) {
                if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797303984393420860") && !event.getChannelLeft().getId().equals("797304533528346674")) {
                    if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("WoT") && !event.getChannelLeft().getName().contains("➕")) {
                        ChannelNames.wot.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
                        try {
                            event.getChannelLeft().delete().queue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                boolean found = true;
                int i;
                for (i = 1; found; i++) {
                    found = ChannelNames.wot.contains(i);
                }
                ChannelNames.wot.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " WoT";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797303984393420860") && !event.getChannelLeft().getId().equals("797304533528346674")) {
                if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("WoT") && !event.getChannelLeft().getName().contains("➕")) {
                    ChannelNames.wot.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
                    try {
                        event.getChannelLeft().delete().queue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event)
    {
        new Thread(() -> {
            if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797303984393420860") && !event.getChannelLeft().getId().equals("797304533528346674")) {
                if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("WoT") && !event.getChannelLeft().getName().contains("➕")) {
                    ChannelNames.wot.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
                    try {
                        event.getChannelLeft().delete().queue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

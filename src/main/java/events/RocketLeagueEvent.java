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


public class RocketLeagueEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event)
    {
        new Thread(() -> {
            Guild guild = event.getMember().getGuild();
            String name;
            if (event.getChannelJoined().getId().equals("797300562529878038")) {
                boolean found = true;
                int i;
                for (i = 1; found; i++) {
                    found = ChannelNames.rocketLeague.contains(i);
                }
                ChannelNames.rocketLeague.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " Rocket League";
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
            if (event.getChannelJoined().getId().equals("797300562529878038")) {
                if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797299044475994152") && !event.getChannelLeft().getId().equals("797300562529878038")) {
                    if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("Rocket League") && !event.getChannelLeft().getName().contains("➕")) {
                        ChannelNames.rocketLeague.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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
                    found = ChannelNames.rocketLeague.contains(i);
                }
                ChannelNames.rocketLeague.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " Rocket League";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797299044475994152") && !event.getChannelLeft().getId().equals("797300562529878038")) {
                if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("Rocket League") && !event.getChannelLeft().getName().contains("➕")) {
                    ChannelNames.rocketLeague.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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
            if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797299044475994152") && !event.getChannelLeft().getId().equals("797300562529878038")) {
                if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("Rocket League") && !event.getChannelLeft().getName().contains("➕")) {
                    ChannelNames.rocketLeague.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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

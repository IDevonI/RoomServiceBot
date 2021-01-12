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


public class TfTEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event)
    {
        new Thread(() -> {
            Guild guild = event.getMember().getGuild();
            String name;
            if (event.getChannelJoined().getId().equals("797302488629641236")) {
                boolean found = true;
                int i;
                for (i = 1; found; i++) {
                    found = ChannelNames.tft.contains(i);
                }
                ChannelNames.tft.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " TFT";
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
            if (event.getChannelJoined().getId().equals("797302488629641236")) {
                if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797300812191105055") && !event.getChannelLeft().getId().equals("797302488629641236")) {
                    if (event.getChannelLeft().getMembers().isEmpty()) {
                        ChannelNames.tft.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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
                    found = ChannelNames.tft.contains(i);
                }
                ChannelNames.tft.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " TFT";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797300812191105055") && !event.getChannelLeft().getId().equals("797302488629641236")) {
                if (event.getChannelLeft().getMembers().isEmpty()) {
                    ChannelNames.tft.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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
            if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797300812191105055") && !event.getChannelLeft().getId().equals("797302488629641236")) {
                if (event.getChannelLeft().getMembers().isEmpty()) {
                    ChannelNames.tft.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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

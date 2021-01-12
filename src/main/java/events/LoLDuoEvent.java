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


public class LoLDuoEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event)
    {
        new Thread(() -> {
            Guild guild = event.getMember().getGuild();
            String name;
            if (event.getChannelJoined().getId().equals("797839642103513118")) {
                boolean found = true;
                int i;
                for (i = 1; found; i++) {
                    found = ChannelNames.lolDuo.contains(i);
                }
                ChannelNames.lolDuo.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " DuoQ";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                ca = ca.setUserlimit(2);
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
            if (event.getChannelJoined().getId().equals("797839642103513118")) {
                if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728") && !event.getChannelLeft().getId().equals("797839642103513118")) {
                    if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("DuoQ") && !event.getChannelLeft().getName().contains("➕")) {
                        ChannelNames.lolDuo.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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
                    found = ChannelNames.lolDuo.contains(i);
                }
                ChannelNames.lolDuo.add(i - 1);
                name = "「\uD83D\uDD08」 #" + (i - 1) + " DuoQ";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                ca = ca.setUserlimit(2);
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728") && !event.getChannelLeft().getId().equals("797839642103513118")) {
                if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("DuoQ") && !event.getChannelLeft().getName().contains("➕")) {
                    ChannelNames.lolDuo.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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
            if (Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728") && !event.getChannelLeft().getId().equals("797839642103513118")) {
                if (event.getChannelLeft().getMembers().isEmpty() && event.getChannelLeft().getName().contains("DuoQ") && !event.getChannelLeft().getName().contains("➕")) {
                    ChannelNames.lolDuo.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6, 7)));
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

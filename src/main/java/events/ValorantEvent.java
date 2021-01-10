package events;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import utils.ChannelNames;

import java.util.Objects;


public class ValorantEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
    {
        Guild guild = event.getMember().getGuild();
        String name;
        if (event.getChannelJoined().getId().equals("797303690523705385")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.valorant.contains(i);
            }
            ChannelNames.valorant.add(i-1);
            name="「\uD83D\uDD08」 Valorant #"+ (i-1);
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        Guild guild = event.getMember().getGuild();
        String name;
        if (event.getChannelJoined().getId().equals("797303690523705385")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.valorant.contains(i);
            }
            ChannelNames.valorant.add(i-1);
            name="「\uD83D\uDD08」 Valorant #"+ (i-1);
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797302657597308929")&&!event.getChannelLeft().getId().equals("797303690523705385"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.valorant.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(event.getChannelLeft().getName().length()-1)));
                event.getChannelLeft().delete().queue();
            }
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
    {
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797302657597308929")&&!event.getChannelLeft().getId().equals("797303690523705385"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.valorant.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(event.getChannelLeft().getName().length()-1)));
                event.getChannelLeft().delete().queue();
            }
        }
    }
}

package events;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import utils.ChannelNames;
import utils.Randomizer;

import java.util.Objects;


public class LoLEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
    {
        Guild guild = event.getMember().getGuild();
        String name;
        if (event.getChannelJoined().getId().compareTo("797300475237498890")==0) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.lol.contains(i-1);
            }
            ChannelNames.lol.add(i-1);
            name="「\uD83D\uDD08」 LoL #"+ (i-1);
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
        if (event.getChannelJoined().getId().compareTo("797300475237498890")==0) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.lol.contains(i-1);
            }
            ChannelNames.lol.add(i-1);
            name="「\uD83D\uDD08」 LoL #"+ (i-1);
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.lol.remove(Integer.parseInt(String.valueOf(event.getChannelLeft().getName().charAt(event.getChannelLeft().getName().length()-1))));
                event.getChannelLeft().delete().queue();
            }
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
    {
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.lol.remove(Integer.parseInt(String.valueOf(event.getChannelLeft().getName().charAt(event.getChannelLeft().getName().length()-1))));
                event.getChannelLeft().delete().queue();
            }
        }
    }
}

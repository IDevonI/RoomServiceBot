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
        if (event.getChannelJoined().getId().equals("797300475237498890")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                System.out.println(i);
                found=ChannelNames.lol.contains(i-1);
            }
            System.out.println(i);
            ChannelNames.lol.add(i-2);
            name="「\uD83D\uDD08」 LoL #"+ (i-2);
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
        if (event.getChannelJoined().getId().equals("797300475237498890")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                System.out.println(i);
                found=ChannelNames.lol.contains(i-1);
            }
            System.out.println(i);
            ChannelNames.lol.add(i-2);
            name="「\uD83D\uDD08」 LoL #"+ (i-2);
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728")&&!event.getChannelLeft().getId().equals("797300475237498890"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.lol.remove(Integer.parseInt(event.getChannelLeft().getName().substring(event.getChannelLeft().getName().length()-1)));
                event.getChannelLeft().delete().queue();
            }
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
    {
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797297810139250728")&&!event.getChannelLeft().getId().equals("797300475237498890"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.lol.remove(Integer.parseInt(event.getChannelLeft().getName().substring(event.getChannelLeft().getName().length()-1)));
                event.getChannelLeft().delete().queue();
            }
        }
    }
}

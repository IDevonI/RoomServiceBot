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


public class JustChattingEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
    {
        Guild guild = event.getMember().getGuild();
        String name = "OutOfNames";
        if (event.getChannelJoined().getName().compareTo("➕│Just Chatting") == 0) {
            for(int i=0;i<=10;i++)
            {
                if(ChannelNames.chattingAvailable[i]==1)
                {
                    ChannelNames.chattingAvailable[i]=0;
                    name=ChannelNames.chattingNames[i];
                    break;
                }
            }
            ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
            ca=ca.setParent(event.getChannelJoined().getParent());
            VoiceChannel vc = ca.complete();
            System.out.println(event.getMember());
            try {
                guild.moveVoiceMember(event.getMember(), vc).queue();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        Guild guild = event.getMember().getGuild();
        String name = "OutOfNames";
        if (event.getChannelJoined().getName().compareTo("➕│Just Chatting") == 0) {
            for(int i=0;i<=10;i++)
            {
                if(ChannelNames.chattingAvailable[i]==1)
                {
                    ChannelNames.chattingAvailable[i]=0;
                    name=ChannelNames.chattingNames[i];
                    break;
                }
            }
            ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
            ca = ca.setParent(event.getChannelJoined().getParent());
            VoiceChannel vc = ca.complete();
            System.out.println(event.getMember());
            try {
                guild.moveVoiceMember(event.getMember(), vc).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getName().equals("JUST CHATTING")&&!event.getChannelLeft().getName().equals("➕│Just Chatting"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                for(int i=0;i<=10;i++)
                {
                    if(ChannelNames.chattingNames[i].equals(event.getChannelLeft().getName()))
                    {
                        ChannelNames.chattingAvailable[i]=1;
                        break;
                    }
                }
                event.getChannelLeft().delete().queue();
            }
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
    {
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getName().equals("JUST CHATTING")&&!event.getChannelLeft().getName().equals("➕│Just Chatting"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                for(int i=0;i<=10;i++)
                {
                    if(ChannelNames.chattingNames[i].equals(event.getChannelLeft().getName()))
                    {
                        ChannelNames.chattingAvailable[i]=1;
                        break;
                    }
                }
                event.getChannelLeft().delete().queue();
            }
        }
    }
}

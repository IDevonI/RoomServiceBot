package events;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import utils.ChannelNames;
import utils.Randomizer;

import java.util.Objects;


public class JustChattingEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
    {
        Guild guild = event.getMember().getGuild();
        String name = "OutOfNames";
        if (event.getChannelJoined().getId().equals("797635390185930782")) {
            Randomizer randomizer = new Randomizer();
            int[] a = randomizer.giveRandom(0, ChannelNames.chattingNames.length, ChannelNames.chattingNames.length);
            for (int i = 0; i < ChannelNames.chattingNames.length; i++) {
                if (ChannelNames.chattingAvailable[a[i]] == 1) {
                    ChannelNames.chattingAvailable[a[i]] = 0;
                    name = ChannelNames.chattingNames[a[i]];
                    break;
                }
            }
            if(!name.equals("OutOfNames")) {
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else
            {
                event.getMember().getUser().openPrivateChannel().queue(
                        (channel)-> channel.sendMessage("Limit pokoi jest aktualnie wyczerpany!Spróbuj później.").queue());
            }
        }
    }
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        Guild guild = event.getMember().getGuild();
        String name = "OutOfNames";
        if (event.getChannelJoined().getId().equals("797635390185930782")) {
            for(GuildChannel g:event.getGuild().getChannels())
            {
                if(Objects.requireNonNull(g.getParent()).getId().equals("797635390185930782")&&g.getMembers().isEmpty())
                {
                    g.delete().queue();
                }
            }
            Randomizer randomizer= new Randomizer();
            int[] a=randomizer.giveRandom(0,ChannelNames.chattingNames.length,ChannelNames.chattingNames.length);
            for(int i=0;i<ChannelNames.chattingNames.length;i++)
            {
                if(ChannelNames.chattingAvailable[a[i]]==1)
                {
                    ChannelNames.chattingAvailable[a[i]]=0;
                    name=ChannelNames.chattingNames[a[i]];
                    break;
                }
            }
            if(!name.equals("OutOfNames")) {
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else
            {
                event.getMember().getUser().openPrivateChannel().queue(
                        (channel)-> channel.sendMessage("Limit pokoi jest aktualnie wyczerpany!Spróbuj później.").queue());
            }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797228633613795418")&&!event.getChannelLeft().getId().equals("797635390185930782"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                for(int i=0;i<ChannelNames.chattingNames.length;i++)
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
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797228633613795418")&&!event.getChannelLeft().getId().equals("797635390185930782"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                for(int i=0;i<ChannelNames.chattingNames.length;i++)
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

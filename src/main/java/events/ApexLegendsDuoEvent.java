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


public class ApexLegendsDuoEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
    {
        Guild guild = event.getMember().getGuild();
        String name;
        if (event.getChannelJoined().getId().equals("797319417008488478")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.apexLegendsDuo.contains(i);
            }
            ChannelNames.apexLegendsDuo.add(i-1);
            name="「\uD83D\uDD08」 #"+(i-1)+" ApexDuo";
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
    }
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        Guild guild = event.getMember().getGuild();
        String name;
        if (event.getChannelJoined().getId().equals("797319417008488478")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.apexLegendsDuo.contains(i);
            }
            ChannelNames.apexLegendsDuo.add(i-1);
            name="「\uD83D\uDD08」 #"+(i-1)+" ApexDuo";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                ca = ca.setUserlimit(2);
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797318951465910292")&&!event.getChannelLeft().getId().equals("797319417008488478"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.apexLegendsDuo.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(16,17)));
                event.getChannelLeft().delete().queue();
            }
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
    {
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797318951465910292")&&!event.getChannelLeft().getId().equals("797319417008488478"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.apexLegendsDuo.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(16,17)));
                event.getChannelLeft().delete().queue();
            }
        }
    }
}

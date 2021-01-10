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


public class WorldOfTanksPlutonEvent extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
    {
        Guild guild = event.getMember().getGuild();
        String name;
        if (event.getChannelJoined().getId().equals("797840295383400458")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.wotPluton.contains(i);
            }
            ChannelNames.wotPluton.add(i-1);
            name="「\uD83D\uDD08」 #"+(i-1)+" Pluton";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                ca = ca.setUserlimit(3);
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
        if (event.getChannelJoined().getId().equals("797840295383400458")) {
            boolean found=true;
            int i;
            for(i=1;found;i++)
            {
                found=ChannelNames.wotPluton.contains(i);
            }
            ChannelNames.wotPluton.add(i-1);
            name="「\uD83D\uDD08」 #"+(i-1)+" Pluton";
                ChannelAction<VoiceChannel> ca = guild.createVoiceChannel(name);
                ca = ca.setParent(event.getChannelJoined().getParent());
                ca = ca.setUserlimit(3);
                VoiceChannel vc = ca.complete();
                try {
                    guild.moveVoiceMember(event.getMember(), vc).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797303984393420860")&&!event.getChannelLeft().getId().equals("797840295383400458"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.wotPluton.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6,7)));
                try {
                    event.getChannelLeft().delete().queue();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
    {
        if(Objects.requireNonNull(event.getChannelLeft().getParent()).getId().equals("797303984393420860")&&!event.getChannelLeft().getId().equals("797840295383400458"))
        {
            if(event.getChannelLeft().getMembers().isEmpty())
            {
                ChannelNames.wotPluton.removeElement(Integer.parseInt(event.getChannelLeft().getName().substring(6,7)));
                try {
                    event.getChannelLeft().delete().queue();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

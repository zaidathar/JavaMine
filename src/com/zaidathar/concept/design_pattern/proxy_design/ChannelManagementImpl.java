package com.zaidathar.concept.design_pattern.proxy_design;

import java.util.HashMap;
import java.util.Map;

public class ChannelManagementImpl implements ChannelManagement{

    // Using as local DB storage
    private Map<String,Channel> channelDB = new HashMap<>();



    @Override
    public void createChannel(Channel channel) throws Exception {
        System.out.println("Create Channel Main call ");


        String channelId = channel.getChannelId();

        if(channelDB.containsKey(channelId)) {
            System.out.println("Channel already exists");
            throw new Exception("Channel already exists");
        }

        channelDB.put(channelId,channel);
    }

    @Override
    public void updateChannel(Channel channel) throws Exception {
        System.out.println("Update channel by in Main method");
        String channelId = channel.getChannelId();
        if(!channelDB.containsKey(channelId)){
            System.out.println("Channel not found !!");
            throw new Exception("Channel not found !!");
        }
        Channel existingChannel = channelDB.get(channelId);


        existingChannel.setChannelId(channel.getChannelId());
        existingChannel.setName(channel.getName());
        existingChannel.setDescription(channel.getDescription());

        channelDB.put(channelId,existingChannel);
    }

    @Override
    public void deleteChannel(String channelId) throws Exception {
        System.out.println("Delete channel in Main method");
        if(!channelDB.containsKey(channelId)){
            System.out.println("Channel not found ");
            throw new Exception("Channel not found");
        }

        channelDB.remove(channelId);
    }

    @Override
    public Channel getChannelDetail(String channelId) throws Exception {
        System.out.println("Get channel detail in main method");
        if(!channelDB.containsKey(channelId)){
            System.out.println("Channel not found ");
            throw new Exception("Channel not found");
        }

        return channelDB.get(channelId);
    }
}

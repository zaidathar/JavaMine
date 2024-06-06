package com.zaidathar.concept.design_pattern.proxy_design;

import java.util.Arrays;

public class ProxyDemo {
    public static void main(String[] args)  {
        Channel channel = new Channel("ch000001","First Channel","first channel", Arrays.asList("user1","user2","user3"));
        ChannelManagementProxy channelManagement = new ChannelManagementProxy();
        try {
            channelManagement.createChannel("ADMIN", channel);
            Channel existing = channelManagement.getChannelDetail("ADMIN","", channel.getChannelId());
            System.out.println(existing.toString());
            channel.setName("Updated name");
            channelManagement.updateChannel("USER","user1",channel);
            existing = channelManagement.getChannelDetail("USER","user2", channel.getChannelId());
            System.out.println("After update : "+existing.toString());

        }
        catch (Exception e){
            System.out.println("Exception caught in proxy demo : "+e.getMessage());
        }
    }
}

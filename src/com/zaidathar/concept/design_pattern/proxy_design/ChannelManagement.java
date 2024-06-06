package com.zaidathar.concept.design_pattern.proxy_design;

public interface ChannelManagement {
    void createChannel(Channel channel) throws  Exception;
    void updateChannel(Channel channel) throws Exception;
    void deleteChannel(String channelId) throws Exception;
    Channel getChannelDetail(String channelId) throws Exception;
}

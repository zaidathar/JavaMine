package com.zaidathar.concept.design_pattern.proxy_design;

public class ChannelManagementProxy {

    private ChannelManagementImpl channelManagement = new ChannelManagementImpl();

    public void createChannel(String userRole, Channel channel) throws Exception {
        System.out.println("Create Channel call by "+userRole);
        if(!userRole.equals("ADMIN")) {
            System.out.println("Access Denied !!");
            throw new Exception("Access Denied !!");
        }

        channelManagement.createChannel(channel);
        System.out.println("Channel successfully created by "+userRole+" with id "+ channel.getChannelId());
    }

    
    public void updateChannel(String userRole, String userId, Channel channel) throws Exception {
        System.out.println("Update channel by "+ userId + " with access role "+userRole);
        String channelId = channel.getChannelId();

        isUserIsAuthorizedForChannel(userRole, userId,channelId);

        channelManagement.updateChannel(channel);
        System.out.println("Channel update successfully by "+userRole);
    }

    
    public void deleteChannel(String userRole, String channelId) throws Exception {
        System.out.println("Update channel by "+userRole+" for channel "+channelId);

        if(!userRole.equals("ADMIN")){
            System.out.println("Only admin can delete the ");
        }
        channelManagement.deleteChannel(channelId);
    }

    
    public Channel getChannelDetail(String userRole, String userId, String channelId) throws Exception {
        System.out.println("get channel detail by "+userId+" with access role "+userRole+" for channel "+channelId);

        isUserIsAuthorizedForChannel(userRole,userId,channelId);
        return channelManagement.getChannelDetail(channelId);
    }

    private boolean isUserIsAuthorizedForChannel(String userRole,String userId, String channelId) throws Exception{
        Channel existingChannel = channelManagement.getChannelDetail(channelId);

        if(!userRole.equals("ADMIN") && !existingChannel.getAuthorizedUsers().contains(userId)){
            System.out.println("User "+userId+" is authorized to access channel "+ channelId);
            throw new Exception("You are not authorized user of this channel");
        }

        return true;
    }
}

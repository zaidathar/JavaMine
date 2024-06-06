package com.zaidathar.concept.design_pattern.proxy_design;

import java.util.List;

public class Channel {
    private String channelId;
    private String name;
    private String description;
    private List<String> authorizedUsers;

    public Channel(String channelId, String name, String description, List<String> authorizedUsers) {
        this.channelId = channelId;
        this.name = name;
        this.description = description;
        this.authorizedUsers = authorizedUsers;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public void setAuthorizedUsers(List<String> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorizedUsers=" + authorizedUsers +
                '}';
    }
}

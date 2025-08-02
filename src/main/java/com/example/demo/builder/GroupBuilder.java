package com.example.demo.builder;

import com.example.demo.Group;

public class GroupBuilder {
    private Group group;
    private String groupName;

    private Long groupId;

    public GroupBuilder() {
        this.group = new Group();
    }

    public GroupBuilder withGroupName(String groupName) {
        this.group.setGroupName(groupName);
        return this;
    }

    public GroupBuilder withGroupId(Long groupId) {
        this.group.setGroupId(groupId);
        return this;
    }

    public Group build() {
        return this.group;
    }

}

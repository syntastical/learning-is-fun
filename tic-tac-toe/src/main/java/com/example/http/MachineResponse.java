package com.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MachineResponse {
    Integer id;
    Item item;
    Move move;
    @JsonProperty("version_group")
    VersionGroup versionGroup;

    public Integer getId() {
        return id;
    }

    public MachineResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public MachineResponse setItem(Item item) {
        this.item = item;
        return this;
    }

    public Move getMove() {
        return move;
    }

    public MachineResponse setMove(Move move) {
        this.move = move;
        return this;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public MachineResponse setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
        return this;
    }
}

class Item {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Item setUrl(String url) {
        this.url = url;
        return this;
    }
}

class Move {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public Move setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Move setUrl(String url) {
        this.url = url;
        return this;
    }
}

class VersionGroup {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public VersionGroup setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public VersionGroup setUrl(String url) {
        this.url = url;
        return this;
    }
}

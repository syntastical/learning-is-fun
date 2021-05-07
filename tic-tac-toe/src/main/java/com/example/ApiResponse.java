package com.example;

//import java.util.List;
import java.util.Map;

public class ApiResponse {

    private Map<String, String> username = Map.of("", "");
    private Map<String, String> credentials = Map.of("", "");

    private Map[] maps = {username, credentials};

    public Map<String, String> getUsername() {
        return username;
    }

    public void setUsername(Map<String, String> username) {
        this.username = username;
    }

    public Map[] getMaps() {
        return maps;
    }

    public void setMaps(Map[] maps) {
        this.maps = maps;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }
}

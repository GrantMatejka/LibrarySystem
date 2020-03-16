package edu.calpoly.csc365.entity;

public class User {
    private Integer id;
    private String username;
    private String name;
    private String permissionLevel;


    public User() {
        this.id = null;
        this.username = null;
        this.name = null;
        this.permissionLevel = null;
    }

    public User(Integer id, String username, String name, String permissionLevel) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.permissionLevel = permissionLevel;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionLevel() {
        return this.permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public User id(Integer id) {
        this.id = id;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User permissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", name='" + getName() + "'" +
                ", permissionLevel='" + getPermissionLevel() + "'" +
                "}";
    }

}
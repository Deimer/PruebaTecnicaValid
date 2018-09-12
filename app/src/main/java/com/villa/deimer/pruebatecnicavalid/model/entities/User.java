package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private String user;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField(canBeNull = false)
    private boolean session;

    public User() {}
    public User(String user, String password, boolean session) {
        this.user = user;
        this.password = password;
        this.session = session;
    }

    public int getId() {
        return id;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public boolean isSession() {
        return session;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setSession(boolean session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", session=" + session +
                '}';
    }
}

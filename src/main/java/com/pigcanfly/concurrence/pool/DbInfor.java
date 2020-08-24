package com.pigcanfly.concurrence.pool;

/**
 * @author tobbyquinn
 * @date 2020/02/16
 */
public class DbInfor {
    private String username;
    private String password;
    public DbInfor(){
        this("default","default");
    }
    public DbInfor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DbInfor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

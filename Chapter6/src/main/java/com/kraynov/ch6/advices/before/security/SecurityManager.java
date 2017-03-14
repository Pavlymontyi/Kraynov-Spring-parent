package com.kraynov.ch6.advices.before.security;

public class SecurityManager{

    private static ThreadLocal<UserInfo> userInfo = new ThreadLocal<>();

    public void login(String userName, String password){
        userInfo.set(new UserInfo(userName, password));
    }

    public void logout(){
        userInfo.remove();
    }

    public UserInfo getLoggedUser(){
        return userInfo.get();
    }
}

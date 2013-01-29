package com.gmail.libra.learn.oddfilter;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserInformation {
    public User find(String id);
    public List<User> list();
}

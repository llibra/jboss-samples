package com.gmail.libra.learn.oddfilter;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface Logger {
    public void log(User user, String numbersString);
    public List<Log> list();
}

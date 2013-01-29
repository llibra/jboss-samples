package com.gmail.libra.learn.oddfilter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"") // —\–ñŒê‚È‚Ì‚Å""‚ÅˆÍ‚Þ
@SuppressWarnings("serial")
public class User implements Serializable {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Log> logs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s (%s %s):%n", id, lastName, firstName));

        for (Log l : logs) {
            builder.append(l.toString());
            builder.append("\n");
        }

        return builder.toString();
    }
}

package com.example.linktracker.Link.entities;

public class Link {

    private Long id;
    private String link;
    private String pass;
    private Long counter;

    public Link(Long id, String link, String pass) {
        this.id = id;
        this.link = link;
        this.pass = pass;
        this.counter = 0L;
    }

    public Link(Long id, String link) {
        this.id = id;
        this.link = link;
        this.counter = 0L;
        this.pass = "";
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}

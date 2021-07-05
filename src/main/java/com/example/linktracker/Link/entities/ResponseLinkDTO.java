package com.example.linktracker.Link.entities;

public class ResponseLinkDTO {

    private Long id;
    private String link;
    private Long counter;

    public ResponseLinkDTO(Long id, String link, Long counter) {
        this.id = id;
        this.link = link;
        this.counter = counter;
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

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public static ResponseLinkDTO convert(Link link) {
        return new ResponseLinkDTO(link.getId(), link.getLink(), link.getCounter());
    }
}

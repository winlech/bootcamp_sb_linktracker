package com.example.linktracker.Link.entities;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class RequestLinkDTO {

    private static Long id = 1L;
    @URL
    @NotBlank
    private String link;
    private String pass;
    private Long counter;

    public RequestLinkDTO() {
    }

    public RequestLinkDTO(String link, String pass, Long counter) {
        this.link = link;
        this.pass = pass;
        this.counter = counter;
    }

    public RequestLinkDTO(String link, Long counter) {
        this.link = link;
        this.pass = "";
        this.counter = counter;
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        RequestLinkDTO.id = id;
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

    public static Link convert(RequestLinkDTO linkDto) {
        return new Link(id++, linkDto.link, linkDto.pass);
    }
}

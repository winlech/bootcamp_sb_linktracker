package com.example.linktracker.Link.services;

import com.example.linktracker.Link.LinkRepository;
import com.example.linktracker.Link.entities.Link;
import com.example.linktracker.Link.entities.ResponseLinkDTO;
import com.example.linktracker.exception.WrongPasswordException;
import org.springframework.stereotype.Service;

@Service
public class ReadLinkService {

    private final LinkRepository linkRepository;

    public ReadLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public ResponseLinkDTO execute(Long id, String pass) {
        Link link = linkRepository.findById(id);
        Long counter;

        if (link.getPass() != null && !link.getPass().equals(pass))
            throw new WrongPasswordException();
        counter = link.getCounter();

        link.setCounter(++counter);
        return ResponseLinkDTO.convert(link);
    }

    public Long counter(Long id, String pass) {
        Link link = linkRepository.findById(id);

        if (link.getPass() != null && !link.getPass().equals(pass))
            throw new WrongPasswordException();

        return link.getCounter();
    }

}

package com.example.linktracker.Link.services;

import com.example.linktracker.Link.LinkRepository;
import com.example.linktracker.Link.entities.Link;
import com.example.linktracker.Link.entities.RequestLinkDTO;
import com.example.linktracker.Link.entities.ResponseLinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLinkService {

    private LinkRepository linkRepository;

    @Autowired
    public CreateLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public ResponseLinkDTO execute(RequestLinkDTO requestLinkDto) {
        Link link = RequestLinkDTO.convert(requestLinkDto);
        linkRepository.save(link);
        return ResponseLinkDTO.convert(link);
    }
}

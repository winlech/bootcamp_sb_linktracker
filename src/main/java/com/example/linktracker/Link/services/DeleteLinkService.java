package com.example.linktracker.Link.services;

import com.example.linktracker.Link.LinkRepository;
import com.example.linktracker.Link.entities.Link;
import com.example.linktracker.exception.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DeleteLinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public DeleteLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String execute(Long id, String pass) {
        Link link = linkRepository.findById(id);

        if (link.getPass() != null && !link.getPass().equals(pass))
            throw new WrongPasswordException();

        linkRepository.delete(id);
        return "Invalidado com sucesso";
    }
}

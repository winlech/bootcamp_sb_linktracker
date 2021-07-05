package com.example.linktracker.Link;

import com.example.linktracker.Link.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LinkRepository {

    private static List<Link> links = new ArrayList<>();

    public boolean save(Link link) {
        try {
            links.add(link);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public Link findById(Long id) {
       return links.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .get();
    }

    public void delete(Long id) {
        links = links.stream()
                .filter(l -> !l.getId().equals(id))
                .collect(Collectors.toList());
    }
}

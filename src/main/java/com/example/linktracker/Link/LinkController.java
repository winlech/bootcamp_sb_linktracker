package com.example.linktracker.Link;

import com.example.linktracker.Link.entities.RequestLinkDTO;
import com.example.linktracker.Link.entities.ResponseLinkDTO;
import com.example.linktracker.Link.services.CreateLinkService;
import com.example.linktracker.Link.services.DeleteLinkService;
import com.example.linktracker.Link.services.ReadLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final CreateLinkService createLinkService;
    private final ReadLinkService readLinkService;
    private final DeleteLinkService deleteLinkService;

    @Autowired
    public LinkController(CreateLinkService createLinkService, ReadLinkService readLinkService, DeleteLinkService deleteLinkService) {
        this.createLinkService = createLinkService;
        this.readLinkService = readLinkService;
        this.deleteLinkService = deleteLinkService;
    }

    @PostMapping
    public ResponseEntity<ResponseLinkDTO> create(@Valid @RequestBody RequestLinkDTO requestLinkDTO) {
        return new ResponseEntity<>(createLinkService.execute(requestLinkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public RedirectView redirect(@PathVariable Long id,
                                @RequestHeader(value = "senha", defaultValue = "") String pass) {
        ResponseLinkDTO responseLinkDTO = readLinkService.execute(id, pass);
        return new RedirectView(responseLinkDTO.getLink());
    }

    @GetMapping("/metrics/{id}")
    public Long counter(@PathVariable Long id,
                                @RequestHeader(value = "senha", defaultValue = "") String pass) {
        return readLinkService.counter(id, pass);
    }

    @DeleteMapping("/invalidate/{id}")
    public String invalidate(@PathVariable Long id,
                            @RequestHeader(value = "senha", defaultValue = "") String pass) {
        return deleteLinkService.execute(id, pass);
    }

}

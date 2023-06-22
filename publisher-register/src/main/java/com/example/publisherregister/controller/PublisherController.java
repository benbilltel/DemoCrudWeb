package com.example.publisherregister.controller;

import com.example.publisherregister.model.Publisher;
import com.example.publisherregister.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    @GetMapping("/all")
    public List<Publisher> getAllPublisher(){
        return publisherService.getAllPublisher();
    }
    @GetMapping("/{id}")
    public Optional<Publisher> getPublisherById(@PathVariable Long id ){
        return publisherService.getPublisherById(id);
    }
    @PostMapping("/create")
    public Publisher createPublisher(@RequestBody Publisher publisher){
        return publisherService.createPublisher(publisher);
    }
    @PutMapping("/update")
    public Publisher updatePublisher(@RequestBody Publisher publisher){
        return publisherService.updatePublisher(publisher);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        publisherService.deleteById(id);
    }
}

package com.example.publisherregister.service;

import com.example.publisherregister.model.Publisher;
import com.example.publisherregister.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }
    public Optional<Publisher> getPublisherById(Long id){
        return publisherRepository.findById(id);
    }
    public Publisher createPublisher( Publisher publisher){
        return publisherRepository.save(publisher);
    }
    public Publisher updatePublisher(Publisher publisher){
        return  publisherRepository.save(publisher);
    }
    public void deleteById(Long id){
        publisherRepository.deleteById(id);
    }
}

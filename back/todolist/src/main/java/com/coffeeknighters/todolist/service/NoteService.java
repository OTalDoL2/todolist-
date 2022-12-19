package com.coffeeknighters.todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.coffeeknighters.todolist.repository.ValidRepository;

@Service
public class NoteService {
    private ValidRepository valid;
    
    public NoteService(ValidRepository valid) {
        this.valid = valid;
    }
    
    @Transactional
    public Boolean deleteNotes(@PathVariable Long id){
        valid.deleteById(id);
        return true;
    }
}

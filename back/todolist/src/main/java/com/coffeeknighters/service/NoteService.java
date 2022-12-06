package com.coffeeknighters.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.coffeeknighters.todolist.repository.ValidRepository;

public class NoteService {
    private ValidRepository valid;
    @Transactional
    public Boolean deleteNotes(@PathVariable Long id){
        valid.deleteById(id);
        return true;
    }
}

package com.coffeeknighters.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeknighters.service.NoteService;
import com.coffeeknighters.todolist.models.Notes;
import com.coffeeknighters.todolist.repository.NotesRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    NotesRepository notesRepository;
    NoteService noteService;

    @GetMapping
    public List<Notes> listarNotas(){
        return notesRepository.findAll();
    }

    @GetMapping("/nota/{id}")
    public Notes notaIndividual(@PathVariable(value = "id") long id){
        return notesRepository.findById(id);
    }
    
    @PostMapping("/nota")
    public Notes criarNota(@RequestBody Notes notes){
        return notesRepository.save(notes);
    }
    
    @DeleteMapping("/{id}")
    public boolean deletaNota(@PathVariable Long id) {
        noteService.deleteNotes(id);
        return true;
        // notesRepository.delete(notes);
    }
    
    @PutMapping("/nota")
    public Notes atualizaNotas(@RequestBody Notes notes) {
        return notesRepository.save(notes);
    }
}
package com.coffeeknighters.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeknighters.todolist.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{
    Notes findById(long id);
    // Notes delete(long id);
}
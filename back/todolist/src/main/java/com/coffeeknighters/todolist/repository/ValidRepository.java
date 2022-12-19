package com.coffeeknighters.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeknighters.todolist.models.Notes;

public interface ValidRepository extends JpaRepository<Notes, Long> {
    Integer deleteById(String id);    
}

package com.coffeeknighters.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeknighters.todolist.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{
    Notes findById(long id);
    // Notes delete(long id);
}

/*
package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

//O JPA já tem métodos prontos, para o banco. LOgo é necessário apenas criar 
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long id);
}
 */
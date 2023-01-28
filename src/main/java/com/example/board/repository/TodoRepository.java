package com.example.board.repository;

import com.example.board.entity.Member;
import com.example.board.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findById(Long id);
    Optional<Todo> findByIsDone(boolean isDone);
    List<Todo> findAll();
}

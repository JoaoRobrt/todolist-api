package com.joao.demo.repository;

import com.joao.demo.entity.Todo;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    @Query("SELECT MAX(t.priority) FROM Todo t")
    Integer findMaxPriority();

    @Query("SELECT t FROM Todo t WHERE t.userEntity.username = :username")
    List<Todo> findAllbyUser(@Param("username") String username, Sort sort);
}

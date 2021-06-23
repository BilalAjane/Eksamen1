package com.example.demo.repository;

import com.example.demo.model.Sogn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SognRepo extends JpaRepository<Sogn, Long> {

    Optional<Sogn> findSognBySognnavn(String sognnavn);
}
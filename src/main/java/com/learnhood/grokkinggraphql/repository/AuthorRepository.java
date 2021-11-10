package com.learnhood.grokkinggraphql.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnhood.grokkinggraphql.model.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {}

package com.learnhood.grokkinggraphql.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnhood.grokkinggraphql.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {
  List<Post> findAllByAuthor_Id(UUID authroId);
}

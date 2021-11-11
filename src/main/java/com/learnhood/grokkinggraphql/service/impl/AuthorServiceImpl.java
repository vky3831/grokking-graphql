package com.learnhood.grokkinggraphql.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnhood.grokkinggraphql.dto.AuthorDto;
import com.learnhood.grokkinggraphql.model.Author;
import com.learnhood.grokkinggraphql.repository.AuthorRepository;
import com.learnhood.grokkinggraphql.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public List<AuthorDto> getAuthors() {
    List<Author> all = authorRepository.findAll();
    return all.stream()
        .map(
            author -> {
              return AuthorDto.builder()
                  .id(author.getId())
                  .name(author.getName())
                  .email(author.getEmail())
                  .build();
            })
        .collect(Collectors.toList());
  }

  @Override
  public AuthorDto getAuthorById(UUID authorId) {
    Author author = authorRepository.findById(authorId).get();
    return AuthorDto.builder()
        .id(author.getId())
        .email(author.getEmail())
        .name(author.getName())
        .build();
  }

  @Override
  public UUID createAuthor(AuthorDto authorDto) {
    Author author = Author.builder().name(authorDto.getName()).email(authorDto.getEmail()).build();
    Author author_saved = authorRepository.saveAndFlush(author);
    return author_saved.getId();
  }
}

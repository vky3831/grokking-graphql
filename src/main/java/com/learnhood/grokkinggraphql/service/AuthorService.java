package com.learnhood.grokkinggraphql.service;

import java.util.List;
import java.util.UUID;

import com.learnhood.grokkinggraphql.dto.AuthorDto;

public interface AuthorService {
  List<AuthorDto> getAuthors();

  AuthorDto getAuthorById(UUID authorId);
}

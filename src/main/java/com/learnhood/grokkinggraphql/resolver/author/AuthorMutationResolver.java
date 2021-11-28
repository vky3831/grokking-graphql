package com.learnhood.grokkinggraphql.resolver.author;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learnhood.grokkinggraphql.dto.AuthorDto;
import com.learnhood.grokkinggraphql.service.AuthorService;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

  private final AuthorService authorService;

  @Autowired
  public AuthorMutationResolver(AuthorService authorService) {
    this.authorService = authorService;
  }

  public UUID createAuthor(AuthorDto authorDto) {
    return authorService.createAuthor(authorDto);
  }
}

package com.learnhood.grokkinggraphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learnhood.grokkinggraphql.dto.AuthorDto;
import com.learnhood.grokkinggraphql.service.AuthorService;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {
  private final AuthorService authorService;

  @Autowired
  public AuthorQueryResolver(AuthorService authorService) {
    this.authorService = authorService;
  }

  public List<AuthorDto> getAuthors() {
    return authorService.getAuthors();
  }
}

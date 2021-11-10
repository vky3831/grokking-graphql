package com.learnhood.grokkinggraphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.learnhood.grokkinggraphql.dto.AuthorDto;
import com.learnhood.grokkinggraphql.dto.PostDto;
import com.learnhood.grokkinggraphql.service.AuthorService;

@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {

  private final AuthorService authorService;

  @Autowired
  public PostFieldResolver(AuthorService authorService) {
    this.authorService = authorService;
  }

  public AuthorDto getAuthor(PostDto postDto) {
    return authorService.getAuthorById(postDto.getAuthorId());
  }
}

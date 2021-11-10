package com.learnhood.grokkinggraphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.learnhood.grokkinggraphql.dto.AuthorDto;
import com.learnhood.grokkinggraphql.dto.PostDto;
import com.learnhood.grokkinggraphql.service.PostService;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {

  private final PostService postService;

  @Autowired
  public AuthorFieldResolver(PostService postService) {
    this.postService = postService;
  }

  public List<PostDto> posts(AuthorDto authorDto) {
    return postService.getAllPostByAuthorId(authorDto.getId());
  }
}

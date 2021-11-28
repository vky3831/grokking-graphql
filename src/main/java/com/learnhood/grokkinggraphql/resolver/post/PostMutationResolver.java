package com.learnhood.grokkinggraphql.resolver.post;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learnhood.grokkinggraphql.dto.PostDto;
import com.learnhood.grokkinggraphql.service.PostService;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {

  private final PostService postService;

  @Autowired
  public PostMutationResolver(PostService postService) {
    this.postService = postService;
  }

  public UUID createPost(PostDto postDto) {
    return postService.createAuthor(postDto);
  }
}

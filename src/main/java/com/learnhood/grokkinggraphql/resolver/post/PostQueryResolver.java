package com.learnhood.grokkinggraphql.resolver.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learnhood.grokkinggraphql.dto.PostDto;
import com.learnhood.grokkinggraphql.service.PostService;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

  private final PostService postService;

  @Autowired
  public PostQueryResolver(PostService postService) {
    this.postService = postService;
  }

  public List<PostDto> recentPosts(int count, int offset) {
    return postService.getRecentPosts(count, offset);
  }
}

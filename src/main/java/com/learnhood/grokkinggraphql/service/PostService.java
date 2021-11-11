package com.learnhood.grokkinggraphql.service;

import java.util.List;
import java.util.UUID;

import com.learnhood.grokkinggraphql.dto.PostDto;

public interface PostService {
  List<PostDto> getAllPostByAuthorId(UUID authorId);

  List<PostDto> getRecentPosts(int count, int offset);

  UUID createAuthor(PostDto postDto);
}

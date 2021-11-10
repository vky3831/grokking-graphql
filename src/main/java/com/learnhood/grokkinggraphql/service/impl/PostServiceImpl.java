package com.learnhood.grokkinggraphql.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.learnhood.grokkinggraphql.dto.PostDto;
import com.learnhood.grokkinggraphql.model.Post;
import com.learnhood.grokkinggraphql.repository.PostRepository;
import com.learnhood.grokkinggraphql.service.PostService;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<PostDto> getAllPostByAuthorId(UUID authorId) {
    List<Post> all = postRepository.findAllByAuthor_Id(authorId);
    return all.stream()
        .map(
            post -> {
              return PostDto.builder()
                  .id(post.getId())
                  .title(post.getTitle())
                  .description(post.getDescription())
                  .category(post.getCategory())
                  .authorId(authorId)
                  .build();
            })
        .collect(Collectors.toList());
  }

  @Override
  public List<PostDto> getRecentPosts(int count, int offset) {
    PageRequest pageRequest = PageRequest.of(offset, count);
    Page<Post> all = postRepository.findAll(pageRequest);

    return all.stream()
        .map(
            post -> {
              return PostDto.builder()
                  .id(post.getId())
                  .authorId(post.getAuthor().getId())
                  .category(post.getCategory())
                  .description(post.getDescription())
                  .title(post.getTitle())
                  .build();
            })
        .collect(Collectors.toList());
  }
}

package com.learnhood.grokkinggraphql.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
  private UUID id;
  private String title;
  private String category;
  private String description;
  private UUID authorId;
}

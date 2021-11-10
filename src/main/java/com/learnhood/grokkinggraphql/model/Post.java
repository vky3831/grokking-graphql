package com.learnhood.grokkinggraphql.model;

import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
  @Type(type = "uuid-char")
  private UUID id;

  private String title;
  private String category;
  private String description;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;
}

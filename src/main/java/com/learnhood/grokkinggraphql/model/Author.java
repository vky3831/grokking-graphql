package com.learnhood.grokkinggraphql.model;

import java.util.Set;
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
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
  @Type(type = "uuid-char")
  private UUID id;

  private String name;
  private String email;

  @OneToMany(mappedBy = "author")
  private Set<Post> posts;
}

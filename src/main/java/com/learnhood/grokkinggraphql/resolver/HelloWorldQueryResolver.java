package com.learnhood.grokkinggraphql.resolver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learnhood.grokkinggraphql.dto.MessageDto;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

  public String getHelloWorld() {
    return "Hello! Gonjalis";
  }

  public String getGreetingMessage(String firstName, String secondName) {
    if (Objects.isNull(secondName)) secondName = "";
    return String.format("Welcome %s %s", firstName, secondName);
  }

  public MessageDto getMessage() {
    return MessageDto.builder().id(UUID.randomUUID()).text("unique").build();
  }

  public List<Integer> getRollDice() {
    return Arrays.asList(1, 2, 3, 4, 5);
  }
}

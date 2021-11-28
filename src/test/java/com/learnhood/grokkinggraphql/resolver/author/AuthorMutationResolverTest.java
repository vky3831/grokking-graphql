package com.learnhood.grokkinggraphql.resolver.author;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.learnhood.grokkinggraphql.TestApplication;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = TestApplication.class)
class AuthorMutationResolverTest {

  @Autowired GraphQLTestTemplate graphQLTestTemplate;

  @Test
  public void shouldAbleToCreateAuthor() throws IOException {
    GraphQLResponse graphQLResponse =
        graphQLTestTemplate.postForResource("request/author-mutation.graphqls");
    String uuid = graphQLResponse.get("$.data.createAuthor");
    MatcherAssert.assertThat(uuid, Matchers.is(Matchers.notNullValue()));
  }
}

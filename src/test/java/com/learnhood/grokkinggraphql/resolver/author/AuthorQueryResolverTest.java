package com.learnhood.grokkinggraphql.resolver.author;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import java.io.IOException;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.learnhood.grokkinggraphql.FileReaderUtil;
import com.learnhood.grokkinggraphql.TestApplication;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = TestApplication.class)
class AuthorQueryResolverTest {

  @Autowired GraphQLTestTemplate graphQLTestTemplate;

  @Test
  public void shouldAbleToGetAuthorData() throws IOException, JSONException {
    GraphQLResponse graphQLResponse =
        graphQLTestTemplate.postForResource("request/author-query.graphqls");
    MatcherAssert.assertThat(graphQLResponse.isOk(), IsEqual.equalTo(true));
    assertEquals(
        FileReaderUtil.read("response/author-query.json"),
        graphQLResponse.getRawResponse().getBody(),
        true);
  }
}

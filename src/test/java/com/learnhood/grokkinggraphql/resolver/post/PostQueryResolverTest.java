package com.learnhood.grokkinggraphql.resolver.post;

import static org.junit.jupiter.api.Assertions.*;
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
class PostQueryResolverTest {
  @Autowired GraphQLTestTemplate graphQLTestTemplate;

  @Test
  public void shouldAbleToGetRecentPostData() throws IOException, JSONException {
    GraphQLResponse graphQLResponse =
        graphQLTestTemplate.postForResource("request/recentPosts-query.graphqls");
    MatcherAssert.assertThat(graphQLResponse.isOk(), IsEqual.equalTo(true));
    assertEquals(
        FileReaderUtil.read("response/recentPosts-query.json"),
        graphQLResponse.getRawResponse().getBody(),
        true);
  }
}

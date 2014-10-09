package de.mosaic4cap.webapp.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ResponseBuilderTest {

  @Autowired
  private ResponseBuilder builder;

  @Test
  public void autowiredResponseBuilder() throws Exception {
    assertThat(builder, notNullValue());
  }
}
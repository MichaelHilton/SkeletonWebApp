package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void knowsAboutName() throws Exception {
    assertThat(queryProcessor.process("What is your name?"), containsString("Michael"));
  }


  @Test
  public void knowsAboutlargest() throws Exception {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 27, 4, 91?"), containsString("91"));
  }


  @Test
  public void knowsAboutPlus() throws Exception {
    assertThat(queryProcessor.process("What is 44 plus 14?"), containsString("58"));
  }
  
}

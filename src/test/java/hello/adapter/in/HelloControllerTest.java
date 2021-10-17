package hello.adapter.in;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
class HelloControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void getHello() throws Exception {
    this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello new user")));
  }

  @Test
  void testCreate() throws Exception {
    Hello hello = new Hello();
    hello.setName("James");
    hello.setWord("word");
    MvcResult mvcResult = this.mockMvc.perform(post("/create").contentType("application/json")
        .content(objectMapper.writeValueAsString(hello))).andDo(print()).andExpect(status().isOk()).andReturn();

    String json = mvcResult.getResponse().getContentAsString();
    Hello resHello = new ObjectMapper().readValue(json, Hello.class);
    assertNotNull(resHello.getUuid());
  }
}
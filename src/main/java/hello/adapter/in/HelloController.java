package hello.adapter.in;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

  @GetMapping(value = "hello")
  public String getHello() {
    log.info("Hello! generating some data... ");
    return "Hello new user ID: " + UUID.randomUUID();
  }

  @PostMapping(value = "create")
  public String getHello(@RequestBody Hello hello) {
    log.info("creating hello");
    return "Hello new user ID: " + UUID.randomUUID();
  }
}

package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping("/stats")
    public String stats() {
        return "my simple stats";
    }

    @RequestMapping("/json")
    public ResponseEntity<HashMap<String, String>> json() {
        HashMap<String, String> response = new HashMap<>();
        response.put("path", "/json");
        response.put("name", "Abhay");
        response.put("version", "v1");
        response.put("date", Instant.now().toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

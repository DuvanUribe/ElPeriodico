package uptc.frw.el_periodico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Ping")
public class PingController {

@GetMapping
public String getResponse() {

    return  "Hola mundo";
}

}

package com.synopsis.microservicios.david.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/david")
public class DavidController {

    @Autowired
    private Environment env;
    @GetMapping("validation")
    public Object getAll() {
        return env.getProperty("custom.david");
    }
}

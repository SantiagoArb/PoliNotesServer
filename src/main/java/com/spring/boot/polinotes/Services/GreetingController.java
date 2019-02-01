package com.spring.boot.polinotes.Services;

import com.spring.boot.polinotes.Greeting;
import com.spring.boot.polinotes.heroe;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @CrossOrigin
    @GetMapping("/heroes")
    public ArrayList getHeroes(@RequestParam(value="valor")String value){
        
        heroe hero = new heroe();
        
        return hero.superHeroes();
    }
}

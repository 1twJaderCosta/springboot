package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.springboot.service.RestService;

@RestController
@RequestMapping("/watch")
public class WatchController {

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public String getById(@PathVariable("id") String id) {
        String params = "i="+id;
        RestService res = new RestService(params);
        return res.getOMDBApi();
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "*")
    public String search(@RequestParam("word") String word) {
        String params = "s="+word;
        RestService res = new RestService(params);
        return res.getOMDBApi();
    }

}
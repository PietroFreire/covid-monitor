package com.covidmonitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "index";

    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Deu bom!");
        return "Ola, mundo!";

    }

//    private List<User> users = new ArrayList<>();
//
//    @GetMapping("/{id}")
//    public User user(@PathVariable("id") Long id) {
//        System.out.println("O id é " + id);
//
//        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
//
//        if (userFind.isPresent()) {
//            return userFind.get();
//        }
//
//        return null;
//    }
//
//    @PostMapping("/")
//    public User user(@RequestBody User user) {
//        users.add(user);
//        return user;
//    }
//
//    @GetMapping("/list")
//    public List<User> list() {
//        return users;
//    }
}
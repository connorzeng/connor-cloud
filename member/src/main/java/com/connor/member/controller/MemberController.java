package com.connor.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

//    @RequestMapping("/registMember")
//    public String registMember(){
//
//        return "registMember ...";
//    }


//    @RequestMapping("/qryMember")
//    public String qryMember(){
//
//        return "qryMember ...";
//    }

    @GetMapping("/")
    public ResponseEntity index() {
        return new ResponseEntity("index error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/sleep")
    public String sleep() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello Nacos Discovery " + string;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return String.valueOf(a / b);
    }
}

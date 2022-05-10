package com.example.warbackend;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WarController {

  War game = new War();

  @GetMapping("/war")
  public War wargame(@RequestParam(value = "name", defaultValue = "null") String player){
    // todo implement war
    if()// if null then do uuid


    return null;
  }

  public War wargame(@RequestParam(value = "name"), @RequestParam(value = "")){
    // todo implement war


      return null;
  }

  @GetMapping("/getwinsfor")
  public Wins Wins(@RequestParam(value = "id")String query){


    return null;
  }





}

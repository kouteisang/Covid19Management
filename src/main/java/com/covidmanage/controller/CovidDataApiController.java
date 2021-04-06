package com.covidmanage.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin(origins = "http://10.151.60.110:8080", maxAge = 3600)
@RestController
@RequestMapping("/coviddata")
public class CovidDataApiController {

}

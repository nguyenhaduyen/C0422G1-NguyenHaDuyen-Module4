package com.example.controller;

import com.example.model.Smartphone;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/smartphone")
public class SmartphoneRestController {
    @Autowired
    private ISmartphoneService iSmartphoneService;
    @GetMapping("/list")
    public ResponseEntity<List<Smartphone>> listSmartphone () {
        List<Smartphone> smartphoneList = iSmartphoneService.findAll();
        if(smartphoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphoneList,HttpStatus.OK);
    }
    @PostMapping ("/create")
    public ResponseEntity<Void> createSmartphone (@RequestBody Smartphone smartphone) {
        iSmartphoneService.add(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/showUpdate")
    public ResponseEntity<Smartphone> showUpdate (@RequestParam int id) {
        Smartphone smartphone = iSmartphoneService.findById(id);
        return new ResponseEntity<>(smartphone,HttpStatus.OK);
    }
    @PostMapping ("/saveUpdate")
    public ResponseEntity<Void> saveUpdate (@RequestBody Smartphone smartphone) {
        iSmartphoneService.update(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

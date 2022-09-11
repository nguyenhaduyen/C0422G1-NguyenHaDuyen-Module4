package com.example.controller;

import com.example.contract.model.AttachFacility;
import com.example.contract.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AttachFacilityRestController {
    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("/listAttachFacility")
    public ResponseEntity<List<AttachFacility>> listFacility(@RequestParam int id) {
        List<AttachFacility> facilityList = iAttachFacilityService.showAttachFacility(id);
        if (facilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }
}

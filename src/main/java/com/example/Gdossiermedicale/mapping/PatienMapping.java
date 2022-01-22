package com.example.Gdossiermedicale.mapping;


import com.example.Gdossiermedicale.beans.Patien;
import com.example.Gdossiermedicale.services.PatienServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/patien")
public class PatienMapping {
    private final com.example.Gdossiermedicale.services.PatienServices PatienServices;
    @Autowired
    public PatienMapping(PatienServices PatienServices){
        this.PatienServices=PatienServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Patien>> getAllMedcinsByTicket () {
        List<Patien> patiens = PatienServices.findAllPatiens();
        return new ResponseEntity<>(patiens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patien> getMedcinById (@PathVariable("id") Long id) {
        Optional<Patien> Patien = PatienServices.findPatienById(id);
        return new ResponseEntity(Patien, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Patien> addMedcin(@RequestBody Patien Patien) {
        Patien newPatien = PatienServices.addPatien(Patien);
        return new ResponseEntity<>(newPatien, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Patien> updateMedcin(@RequestBody Patien Patien) {
        Patien uPatien = PatienServices.updatePatien(Patien);
        return new ResponseEntity<>(uPatien, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedcin(@PathVariable("id") Long id) {
        PatienServices.deletePatien(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}




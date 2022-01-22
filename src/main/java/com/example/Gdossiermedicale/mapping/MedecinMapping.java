package com.example.Gdossiermedicale.mapping;


import com.example.Gdossiermedicale.beans.Medecin;
import com.example.Gdossiermedicale.services.MedecinServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/medecin")
public class MedecinMapping {
    private final MedecinServices medecinServices;
    @Autowired
    public MedecinMapping(MedecinServices medecinServices){
        this.medecinServices=medecinServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Medecin>> getAllMedcinsByTicket () {
        List<Medecin> medcins = medecinServices.findAllMedecins();
        return new ResponseEntity<>(medcins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getMedcinById (@PathVariable("id") Long id) {
        Optional<Medecin> medecin = medecinServices.findMedecinById(id);
        return new ResponseEntity(medecin, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Medecin> addMedcin(@RequestBody Medecin medecin) {
        Medecin newmedecin = medecinServices.addMedecin(medecin);
        return new ResponseEntity<>(newmedecin, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Medecin> updateMedcin(@RequestBody Medecin medecin) {
        Medecin umedecin = medecinServices.updateMedecin(medecin);
        return new ResponseEntity<>(umedecin, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedcin(@PathVariable("id") Long id) {
        medecinServices.deleteMedecin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}




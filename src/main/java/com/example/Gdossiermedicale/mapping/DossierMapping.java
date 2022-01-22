package com.example.Gdossiermedicale.mapping;


import com.example.Gdossiermedicale.beans.Dossier;
import com.example.Gdossiermedicale.services.DossierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/dossier")
public class DossierMapping {
    private final DossierServices RDVServices;
    @Autowired
    public DossierMapping(DossierServices RDVServices){
        this.RDVServices=RDVServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Dossier>> getAllMedcinsByTicket () {
        List<Dossier> medcins = RDVServices.findAllRDVs();
        return new ResponseEntity<>(medcins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getMedcinById (@PathVariable("id") Long id) {
        Optional<Dossier> RDV = RDVServices.findDossieryId(id);
        return new ResponseEntity(RDV, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Dossier> addMedcin(@RequestBody Dossier Dossier) {
        Dossier newRDV = RDVServices.addDossier(Dossier);
        return new ResponseEntity<>(newRDV, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Dossier> updateMedcin(@RequestBody Dossier Dossier) {
        Dossier uRDV = RDVServices.updateDossier(Dossier);
        return new ResponseEntity<>(uRDV, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedcin(@PathVariable("id") Long id) {
        RDVServices.deleteDossier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}




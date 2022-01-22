package com.example.Gdossiermedicale.mapping;

import com.example.Gdossiermedicale.beans.Admin;
import com.example.Gdossiermedicale.services.AdminServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/secretaire")
public class AdminMapping {
    private final AdminServices AdminServices;
    @Autowired
    public AdminMapping(AdminServices AdminServices){
        this.AdminServices=AdminServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAllMedcinsByTicket () {
        List<Admin> medcins = AdminServices.findAllSecretaires();
        return new ResponseEntity<>(medcins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getMedcinById (@PathVariable("id") Long id) {
        Optional<Admin> Secretaire = AdminServices.findSecretaireById(id);
        return new ResponseEntity(Secretaire, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Admin> addMedcin(@RequestBody Admin Secretaire) {
        Admin newSecretaire = AdminServices.addSecretaire(Secretaire);
        return new ResponseEntity<>(newSecretaire, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login (@RequestBody Admin secretaire) {
        Admin secretaire1 = AdminServices.findByLoginAndPassword(secretaire);
        return new ResponseEntity<>(secretaire1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Admin> updateMedcin(@RequestBody Admin Secretaire) {
        Admin uSecretaire = AdminServices.updateSecretaire(Secretaire);
        return new ResponseEntity<>(uSecretaire, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedcin(@PathVariable("id") Long id) {
        AdminServices.deleteSecretaire(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}




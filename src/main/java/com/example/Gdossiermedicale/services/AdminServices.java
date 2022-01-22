package com.example.Gdossiermedicale.services;

import com.example.Gdossiermedicale.Idao.AdminDao;
import com.example.Gdossiermedicale.beans.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AdminServices {

    private final AdminDao AdminDao;
    @Autowired
    public AdminServices(AdminDao AdminDao){
        this.AdminDao=AdminDao;
    }

    public Admin findByLoginAndPassword(Admin secretaire){
        return AdminDao.findByLoginAndPassword(secretaire.getLogin(),secretaire.getPassword());
    }
    public Admin addSecretaire(Admin Secretaire) {
        return AdminDao.save(Secretaire);
    }
    public List<Admin> findAllSecretaires(){
        return AdminDao.findAll();

    }
    public Admin updateSecretaire(Admin Secretaire){
        return AdminDao.save(Secretaire);
    }
    public Optional<Admin> findSecretaireById (long id){
        return AdminDao.findById(id);
    }
    public void deleteSecretaire(long id){
        AdminDao.deleteById(id);
    }


}

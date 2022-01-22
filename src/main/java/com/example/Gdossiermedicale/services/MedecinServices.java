package com.example.Gdossiermedicale.services;

import com.example.Gdossiermedicale.Idao.MedecinDao;
import com.example.Gdossiermedicale.beans.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedecinServices {

    private final MedecinDao medecinDao;
    @Autowired
    public MedecinServices(MedecinDao medecinDao){
        this.medecinDao=medecinDao;
    }

    public Medecin addMedecin(Medecin medecin) {
        return medecinDao.save(medecin);
    }
    public List<Medecin> findAllMedecins(){
        return medecinDao.findAll();

    }
    public Medecin updateMedecin(Medecin medecin){
        return medecinDao.save(medecin);
    }
    public Optional<Medecin> findMedecinById (long id){
        return medecinDao.findById(id);
    }
    public void deleteMedecin(long id){
        medecinDao.deleteById(id);
    }


}

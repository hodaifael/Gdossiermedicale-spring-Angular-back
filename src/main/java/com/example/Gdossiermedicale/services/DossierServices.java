package com.example.Gdossiermedicale.services;


import com.example.Gdossiermedicale.Idao.DossierDao;
import com.example.Gdossiermedicale.beans.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DossierServices {

    private final DossierDao RDVDao;
    @Autowired
    public DossierServices(DossierDao RDVDao){
        this.RDVDao=RDVDao;
    }

    public Dossier addDossier(Dossier Dossier) {
        return RDVDao.save(Dossier);
    }
    public List<Dossier> findAllRDVs(){
        return RDVDao.findAll();

    }
    public Dossier updateDossier(Dossier Dossier){
        return RDVDao.save(Dossier);
    }
    public Optional<Dossier> findDossieryId (long id){
        return RDVDao.findById(id);
    }
    public void deleteDossier(long id){
        RDVDao.deleteById(id);
    }


}

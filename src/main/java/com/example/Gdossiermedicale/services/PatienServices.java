package com.example.Gdossiermedicale.services;

import com.example.Gdossiermedicale.Idao.PatienDao;
import com.example.Gdossiermedicale.beans.Patien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PatienServices {

    private final PatienDao patienDao;
    @Autowired
    public PatienServices(PatienDao patienDao){
        this.patienDao=patienDao;
    }

    public Patien addPatien(Patien Patien) {
        return patienDao.save(Patien);
    }
    public List<Patien> findAllPatiens(){
        return patienDao.findAll();

    }
    public Patien updatePatien(Patien Patien){
        return patienDao.save(Patien);
    }
    public Optional<Patien> findPatienById (long id){
        return patienDao.findById(id);
    }
    public void deletePatien(long id){
        patienDao.deleteById(id);
    }


}

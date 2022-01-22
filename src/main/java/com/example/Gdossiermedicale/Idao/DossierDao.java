package com.example.Gdossiermedicale.Idao;

import com.example.Gdossiermedicale.beans.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierDao extends JpaRepository<Dossier,Long> {
}

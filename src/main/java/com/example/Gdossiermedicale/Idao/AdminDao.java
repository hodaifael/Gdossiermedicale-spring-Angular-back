package com.example.Gdossiermedicale.Idao;

import com.example.Gdossiermedicale.beans.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Long> {
    Admin findByLoginAndPassword(String login, String password);

}

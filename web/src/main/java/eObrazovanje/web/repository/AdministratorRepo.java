package eObrazovanje.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eObrazovanje.web.model.Administrator;

public interface AdministratorRepo extends JpaRepository<Administrator, Long> {

}

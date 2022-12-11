package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Train;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

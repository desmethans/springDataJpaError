package be.vdab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

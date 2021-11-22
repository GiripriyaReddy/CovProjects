package com.cov.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cov.beans.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}

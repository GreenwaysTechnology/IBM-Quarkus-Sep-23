package com.ibm.quarkus.data.dao.entity;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
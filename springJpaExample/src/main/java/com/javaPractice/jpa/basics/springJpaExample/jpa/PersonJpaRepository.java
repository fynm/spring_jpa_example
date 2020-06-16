package com.javaPractice.jpa.basics.springJpaExample.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.javaPractice.jpa.basics.springJpaExample.entity.Person;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//Respository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {
    //connect to database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class, id); //Class and Primary Key
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person =  findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
}
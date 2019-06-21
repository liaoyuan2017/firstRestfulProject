package com.rocky.dao;

import com.rocky.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    List<Person> withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);

    Person withNameAndAddressNamedQuery(String name,String address);

    @RestResource(path="nameStartsWith", rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name")String name);

    Person findByName(@Param("name")String name);

}

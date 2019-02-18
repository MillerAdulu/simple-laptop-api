package com.miller.auth.repository;

import java.util.List;

import com.miller.auth.model.Laptop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Long> {
    List<Laptop> findByName(String name);
}
package com.miller.auth.controlller;

import java.util.List;

import com.miller.auth.model.Laptop;
import com.miller.auth.repository.LaptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private LaptopRepository lRepository;

    @GetMapping
    public Iterable<Laptop> findAll() {
        return lRepository.findAll();
    }

    @GetMapping("/name/{laptopName}")
    public List<Laptop> findByName(@PathVariable String lapName) {
        return lRepository.findByName(lapName);
    }

    @GetMapping("/{id}")
    public Laptop findOne(@PathVariable Long id) {
        return lRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop laptop) {
        return lRepository.save(laptop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lRepository.findById(id).orElseThrow();
        lRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Laptop updateLaptop(@RequestBody Laptop laptop, @PathVariable Long id) {
        return lRepository.save(laptop);
    }

}
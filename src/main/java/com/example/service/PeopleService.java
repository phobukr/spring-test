package com.example.service;

import com.example.domain.PeopleEntity;
import com.example.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public PeopleEntity createPeople(PeopleEntity people) {
        return peopleRepository.save(people);
    }

    @Transactional
    public PeopleEntity updatePeople(PeopleEntity people) {
        return peopleRepository.save(people);
    }

    @Transactional
    public void deletePeople(Long personId) {
        peopleRepository.deleteById(personId);
    }

    @Transactional(readOnly = true)
    public List<PeopleEntity> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PeopleEntity getPeopleById(Long personId) {
        return peopleRepository.findById(personId).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<PeopleEntity> getPeopleByFullName(String fullName) {
        return peopleRepository.findByFullName(fullName);
    }

    @Transactional(readOnly = true)
    public List<PeopleEntity> getPeopleByIsEmployee(Boolean isEmployee) {
        return peopleRepository.findByIsEmployee(isEmployee);
    }

    @Transactional(readOnly = true)
    public List<PeopleEntity> getPeopleByIsSalesperson(Boolean isSalesperson) {
        return peopleRepository.findByIsSalesperson(isSalesperson);
    }
}

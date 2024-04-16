package com.java.pawsome.Service;

import com.java.pawsome.Model.Pet;
import com.java.pawsome.Repository.PetRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepo petRepo;

    public Pet createPet(@NonNull Pet pet) {
        return petRepo.save(pet);
    }

    public Page<Pet> getAllPet(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return petRepo.findAll(pageable);
    }

    public List<Pet> getAllPets() {
        return petRepo.findAll();
    }

    public Pet getPetById(@NonNull Integer id) {
        return petRepo.findById(id).orElse(null);
    }

    public boolean updatePet(int id, Pet pet) {
        if (getPetById(id) == null) {
            return false;
        }
        try {
            petRepo.save(pet);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deletePet(int id) {
        if (getPetById(id) == null) {
            return false;
        }
        petRepo.deleteById(id);
        return true;
    }
}

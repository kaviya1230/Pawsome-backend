package com.java.pawsome.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.pawsome.Model.Pet;
import com.java.pawsome.Service.PetService;

@RestController
@RequestMapping("/api")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/pets")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        Pet newPet = petService.createPet(pet);
        if (newPet != null) {
            return new ResponseEntity<>(newPet, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pets")
    public ResponseEntity<Page<Pet>> getAllPet(
            @RequestParam int pageNo,
            @RequestParam int pageSize,
            @RequestParam String sortBy) {
        Page<Pet> pets = petService.getAllPet(pageNo, pageSize, sortBy);
        if (!pets.isEmpty()) {
            return new ResponseEntity<>(pets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<Pet> updatePet(@PathVariable int petId, @RequestBody Pet pet) {
        boolean updated = petService.updatePet(petId, pet);
        if (updated) {
            return new ResponseEntity<>(pet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pets/{petId}")
    public ResponseEntity<Boolean> deletePet(@PathVariable int petId) {
        boolean deleted = petService.deletePet(petId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}

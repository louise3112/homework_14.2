package com.example.fileService.controllers;

import com.example.fileService.models.File;
import com.example.fileService.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    // INDEX: Get all files:
    @GetMapping(value = "/file")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    // SHOW: Get a specific file by id:
    @GetMapping(value = "/file/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id) {
        Optional<File> optionalFile = fileRepository.findById(id);

        if (optionalFile.isPresent()) {
            return new ResponseEntity<>(optionalFile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalFile, HttpStatus.NOT_FOUND);
        }
    }

    // CREATE: Add a new file:
    @PostMapping(value = "/file")
    public ResponseEntity<File> postFile(@RequestBody File file) {
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}

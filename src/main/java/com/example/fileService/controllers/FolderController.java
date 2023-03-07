package com.example.fileService.controllers;

import com.example.fileService.models.Folder;
import com.example.fileService.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    // INDEX: Get all folders:
    @GetMapping(value = "/folder")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    // SHOW: Get a specific folder by id:
    @GetMapping(value = "/folder/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id) {
        Optional<Folder> optionalFolder = folderRepository.findById(id);

        if (optionalFolder.isPresent()) {
            return new ResponseEntity<>(optionalFolder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalFolder, HttpStatus.NOT_FOUND);
        }
    }

    // CREATE: Add a new folder:
    @PostMapping(value = "/folder")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder) {
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}

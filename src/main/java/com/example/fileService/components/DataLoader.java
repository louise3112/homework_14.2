package com.example.fileService.components;

import com.example.fileService.models.File;
import com.example.fileService.models.Folder;
import com.example.fileService.models.Person;
import com.example.fileService.repositories.FileRepository;
import com.example.fileService.repositories.FolderRepository;
import com.example.fileService.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {

        Person person1 = new Person("Derek");
        personRepository.save(person1);

        Folder folder1 = new Folder("Folder 1", person1);
        Folder folder2 = new Folder("Folder 2", person1);
        folderRepository.save(folder1);
        folderRepository.save(folder2);

        File file1 = new File("File 1", ".doc", 5, folder1);
        File file2 = new File("File 2", ".xml", 10, folder1);
        File file3 = new File("File 3", ".py", 16, folder2);
        fileRepository.save(file1);
        fileRepository.save(file2);
        fileRepository.save(file3);
    }

}

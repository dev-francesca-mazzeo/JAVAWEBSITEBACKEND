package com.appweb.devfm.demo.controller;

import com.appweb.devfm.demo.entity.FileInfo;
import com.appweb.devfm.demo.services.FIleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.appweb.devfm.demo.constants.EndPoint.*;


@RestController
@RequestMapping(FILEUPLOAD)
public class FileUploadController {

    @Autowired
    FIleStoreService fileStoreService;

    @PostMapping(DEFAULT)
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        return fileStoreService.store(file);
    }


    @GetMapping(DEFAULT)
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = fileStoreService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        Stream<Path> pathStream = fileStoreService.loadAll();
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping(FILES + FILENAME)
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStoreService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
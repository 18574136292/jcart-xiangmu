package io.itcast.cfc.controller;

import io.itcast.cfc.constant.ClientExceptionConstant;
import io.itcast.cfc.exception.ClientException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    private List<String> imageList = Arrays.asList("jpg","jpeg","png");

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws ClientException, IOException {
        String originalFilename = file.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String str = split[split.length - 1];
        str = str.toLowerCase();
        boolean contains = imageList.contains(str);
        if(!contains){
            throw new ClientException(ClientExceptionConstant.IMAGE_INVALID_ERRCODE,ClientExceptionConstant.IMAGE_INVALID_ERRMSG);
        }
        String uuid = UUID.randomUUID().toString();
        String filename = String.format("%s.%s", uuid, str);
        String filepath = String.format("www/image/%s", filename);
        try(FileOutputStream outputStream = new FileOutputStream(filepath)) {
            byte[] bytes = file.getBytes();
            outputStream.write(bytes);
        }
        return filename;
    }
}

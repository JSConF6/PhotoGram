package com.jsconf.photogram.service;

import com.jsconf.photogram.config.auth.PrincipalDetails;
import com.jsconf.photogram.domain.image.ImageRepository;
import com.jsconf.photogram.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadFolder;

    public void ImageUpload(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails){
        UUID uuid = UUID.randomUUID(); // uuid
        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename(); // 1.jpg
        System.out.println("이미지 파일이름 : " + imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        // 통신, I/O -> 예외가 발생할 수 있다.
        try{
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

package com.jsconf.photogram.web.dto.image;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter @ToString
public class ImageUploadDto {
    private MultipartFile file;
    private String caption;
}

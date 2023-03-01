package com.jsconf.photogram.handler;

import com.jsconf.photogram.handler.ex.CustomValidationApiException;
import com.jsconf.photogram.handler.ex.CustomValidationException;
import com.jsconf.photogram.util.Script;
import com.jsconf.photogram.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        // CMRespDto, Script 비교
        // 1. 클라이언트에게 응답할 떄는 Script 좋음
        // 2. Ajax통신 - CMRespDto
        // 3. Andriod 통신 - CMRespDto
        return Script.back(e.getErrorMap().toString());
    }

    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<CMRespDto<?>> validationException(CustomValidationApiException e) {
        return new ResponseEntity<>(new CMRespDto(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }
}

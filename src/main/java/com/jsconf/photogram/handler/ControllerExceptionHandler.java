package com.jsconf.photogram.handler;

import com.jsconf.photogram.handler.ex.CustomValidationException;
import com.jsconf.photogram.util.Script;
import com.jsconf.photogram.web.dto.CMRespDto;
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
}

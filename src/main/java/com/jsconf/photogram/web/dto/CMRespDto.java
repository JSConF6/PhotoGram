package com.jsconf.photogram.web.dto;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class CMRespDto<T> {
    private int code; // 1(성공), -1 (실패)
    private String message;
    private T data;
}

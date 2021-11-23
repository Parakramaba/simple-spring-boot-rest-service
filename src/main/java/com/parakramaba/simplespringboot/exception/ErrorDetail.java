package com.parakramaba.simplespringboot.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorDetail {

    private int status;
    private String details;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy/MM/dd hh:mm:ss")
    private LocalDateTime localDateTime;
}

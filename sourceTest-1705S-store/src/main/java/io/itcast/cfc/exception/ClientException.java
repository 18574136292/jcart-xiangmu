package io.itcast.cfc.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class ClientException extends ServletException {
    private String errCode;

    public ClientException(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }

}

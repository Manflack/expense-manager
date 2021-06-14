package ar.com.manflack.expensemanager.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseApi extends ResponseEntity
{
    public ResponseApi(Object body, HttpStatus status)
    {
        super(body, status);
    }
}

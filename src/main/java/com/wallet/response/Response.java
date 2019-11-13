package com.wallet.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> { //<T> tipo não definido da classe

    private T data; // sucesso na api
    private List<String> errors; // erros na api

    public List<String> getErros() {
        if (this.errors == null){
            this.errors = new ArrayList<>();
        }
        return errors;
    }
}

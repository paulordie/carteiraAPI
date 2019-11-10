package com.wallet.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> { //<T> tipo não definido da classe

    private T data; // sucesso na api
    private List<String> erros; // erros na api
}

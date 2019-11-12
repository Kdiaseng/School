package br.com.kdias.School.service;


import br.com.kdias.School.exception.NotFoundException;

import java.util.Optional;

abstract class BaseService {

    void verifyNotFound(String erro, Optional<?> optional){
        if(!optional.isPresent()){
            throw new NotFoundException(erro);
        }
    }

}

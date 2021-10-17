package com.amirnadiv.server.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public interface DnaService {

    ResponseEntity checkDna(String gen);

    Boolean isGenValid (String gen);

    Boolean isGenFoundInFile (String gen);

}

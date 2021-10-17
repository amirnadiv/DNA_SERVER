package com.amirnadiv.server.controller;

 import com.amirnadiv.server.service.DnaService;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RestController;

@RestController
class DnaController {

    private final DnaService dnaService;

    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }


    @GetMapping("/genes/find/{gen}")
    public ResponseEntity<HttpStatus> findGenInFile(@PathVariable String gen) {

        return dnaService.checkDna(gen);
    }


}
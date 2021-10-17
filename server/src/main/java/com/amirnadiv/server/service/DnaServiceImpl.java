package com.amirnadiv.server.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DnaServiceImpl implements DnaService {

    @Value("${inputFilePath}")
    private String inputFilePath;

    @Value("${genRegex}")
    private String genRegex;


    @Override
    public ResponseEntity<HttpStatus> checkDna(String gen) {


        if (Boolean.FALSE.equals(isGenValid(gen))) {
            return (new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        } // 400
        else if (Boolean.TRUE.equals(isGenFoundInFile(gen))) {
            return (new ResponseEntity<>(HttpStatus.OK));
        } // 200
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } // 404

    }

    @Override
    public Boolean isGenValid(String gen) {

        return getMatcherForGen(gen).matches();

    }

    private Matcher getMatcherForGen(String gen) {
        return Pattern.compile(genRegex).matcher(gen);
    }

    @Override
    public Boolean isGenFoundInFile(String gen) {
        return getMatcherForGen(gen).find();

    }
}

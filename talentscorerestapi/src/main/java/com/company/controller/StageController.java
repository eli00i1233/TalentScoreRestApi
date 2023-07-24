package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.entityDTO.StageDTO;
import com.company.entity.Stage;
import com.company.inter.StageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequiredArgsConstructor
public class StageController {
    @Autowired
    private StageRepository stagesRepository;

    @GetMapping("/stages")
    public ResponseEntity<ResponseDTO> foreignLanguages() {
        List<Stage> stages = stagesRepository.findAll();
        List<StageDTO> stageDTOS = new ArrayList<>();

        for (Stage u : stages) {
            stageDTOS.add(new StageDTO(u));
        }
        return ResponseEntity.ok(ResponseDTO.of(stageDTOS));
    }
}

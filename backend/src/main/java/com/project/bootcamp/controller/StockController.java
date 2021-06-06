package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDto;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDto> save(@Valid @RequestBody StockDto dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDto> update(@Valid @RequestBody StockDto dto){
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDto>> findAll(){
        List<StockDto> list = new ArrayList<>();
        StockDto dto = new StockDto();
        dto.setId(1L);
        dto.setName("Magazine Luiza");
        dto.setPrice(100.90);
        dto.setVariation(100D);
        dto.setDate(LocalDate.now());
        list.add(dto);

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDto> findById(@PathVariable Long id){
        List<StockDto> list = new ArrayList<>();
        StockDto stock1 = new StockDto();
        stock1.setId(1L);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(100.90);
        stock1.setVariation(100D);
        stock1.setDate(LocalDate.now());

        StockDto stock2 = new StockDto();
        stock2.setId(2L);
        stock2.setName("Weg");
        stock2.setPrice(78.10);
        stock2.setVariation(100D);
        stock2.setDate(LocalDate.now());

        list.add(stock1);
        list.add(stock2);

        StockDto dtoSelect = list.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();

        return ResponseEntity.ok(dtoSelect);
    }
}

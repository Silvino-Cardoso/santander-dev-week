package com.project.bootcamp.service;

import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDto;
import com.project.bootcamp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDto save(StockDto dto) {
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);

        return mapper.toDto(stock);
    }
}

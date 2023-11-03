package org.example.service.impl;

import org.example.domain.AnuncioDto;
import org.example.repositories.AnuncioServiceRepository;
import org.example.service.AnuncioService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnuncioServiceImpl implements AnuncioService {

    private AnuncioServiceRepository anuncioServiceRepository;

    @Override
    public AnuncioDto create(AnuncioDto anuncioDto) {
        anuncioDto.setId(1L);
        anuncioDto.setIps(Arrays.asList("123", "321"));
        return anuncioDto;
    }

    @Override
    public List<AnuncioDto> create2(AnuncioDto anuncioDto) {
        anuncioDto.setId(1L);
        anuncioDto.setIps(Arrays.asList("123", "321"));
        List<AnuncioDto> result = anuncioServiceRepository.save(Arrays.asList(anuncioDto));
        return result;
    }

    @Override
    public List<AnuncioDto> findAll() {
        AnuncioDto anuncioDto1 = new AnuncioDto(1L, "TESTE-1", new ArrayList<>());
        AnuncioDto anuncioDto2 = new AnuncioDto(2L, "TESTE-2", Arrays.asList("IP1", "IP2"));
        AnuncioDto anuncioDto3 = new AnuncioDto(3L, "TESTE-3", null);

        return Arrays.asList(anuncioDto1, anuncioDto2, anuncioDto3);
    }
}

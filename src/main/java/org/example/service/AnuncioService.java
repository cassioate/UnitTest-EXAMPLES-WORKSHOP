package org.example.service;

import org.example.domain.AnuncioDto;

import java.util.List;

public interface AnuncioService {
    AnuncioDto create(AnuncioDto anuncioDto);

    List<AnuncioDto> create2(AnuncioDto anuncioDto);

    List<AnuncioDto> findAll();
}

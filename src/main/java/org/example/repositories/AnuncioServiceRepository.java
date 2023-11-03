package org.example.repositories;

import org.example.domain.AnuncioDto;

import java.util.List;

public interface AnuncioServiceRepository {
    List<AnuncioDto> save(List<AnuncioDto> anuncioDtos);
}

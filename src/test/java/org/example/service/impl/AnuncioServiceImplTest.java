package org.example.service.impl;

import org.example.domain.AnuncioDto;
import org.example.repositories.AnuncioServiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class AnuncioServiceImplTest {

//    private AnuncioServiceImpl anuncioService = new AnuncioServiceImpl();

    @InjectMocks
    private AnuncioServiceImpl anuncioService;

    @Mock
    private AnuncioServiceRepository anuncioServiceRepository;

    @Test
    public void createTest() {
        AnuncioDto anuncioDto = new AnuncioDto(1L, "TESTE-01", null);
        AnuncioDto result = anuncioService.create(anuncioDto);
        Assertions.assertEquals(result, anuncioDto);
    }

    @Test
    public void createTest2() {
        AnuncioDto anuncioDto = new AnuncioDto(1L, "TESTE-01", null);
        Mockito.when(anuncioServiceRepository.save(Mockito.any())).thenReturn(Arrays.asList(anuncioDto));
        List<AnuncioDto> result = anuncioService.create2(anuncioDto);
        Assertions.assertEquals(result.get(0).getId(), anuncioDto.getId());
        Assertions.assertEquals(result.get(0).getTitulo(), anuncioDto.getTitulo());
        Assertions.assertEquals(result.get(0).getIps(), anuncioDto.getIps());
    }

    @Test
    public void createTest2WasCalledOneTime() {
        AnuncioDto anuncioDto = new AnuncioDto(1L, "TESTE-01", null);
        Mockito.when(anuncioServiceRepository.save(Mockito.any())).thenReturn(Arrays.asList(anuncioDto));

        List<AnuncioDto> result = anuncioService.create2(anuncioDto);
        Assertions.assertEquals(result.get(0).getId(), anuncioDto.getId());
        Assertions.assertEquals(result.get(0).getTitulo(), anuncioDto.getTitulo());
        Assertions.assertEquals(result.get(0).getIps(), anuncioDto.getIps());

        Mockito.verify(anuncioServiceRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void createTest2Failed() {
        AnuncioDto anuncioDto = new AnuncioDto(1L, "TESTE-01", null);
        Mockito.when(anuncioServiceRepository.save(Mockito.any())).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () ->  anuncioService.create2(anuncioDto));
    }

    @Test
    public void findAllTest() {
        List<AnuncioDto> result = anuncioService.findAll();

        Assertions.assertEquals(result.size(), 3);
        Assertions.assertEquals(result.get(0).getId(), 1);
        Assertions.assertEquals(result.get(1).getId(), 2);
        Assertions.assertEquals(result.get(2).getId(), 3);
        Assertions.assertEquals(result.get(1).getIps().size(), 2);
        Assertions.assertEquals(result.get(2).getTitulo(), "TESTE-3");
    }
}
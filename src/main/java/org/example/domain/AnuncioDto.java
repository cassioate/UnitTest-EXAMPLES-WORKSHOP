package org.example.domain;

import java.util.List;

public class AnuncioDto {
    Long id;
    String titulo;
    List<String> ips;

    public AnuncioDto(Long id, String titulo, List<String> ips) {
        this.id = id;
        this.titulo = titulo;
        this.ips = ips;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }
}

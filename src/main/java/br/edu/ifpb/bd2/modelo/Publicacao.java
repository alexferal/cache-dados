package br.edu.ifpb.bd2.modelo;

import java.time.LocalDate;

public class Publicacao {

    private Integer id;
    private String corpo;
    private LocalDate data;
    private String idUsuario;

    public Publicacao(Integer id, String corpo, LocalDate data, String idUsuario) {
        this.id = id;
        this.corpo = corpo;
        this.data = data;
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "id=" + id +
                ", corpo='" + corpo + '\'' +
                ", data=" + data +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}

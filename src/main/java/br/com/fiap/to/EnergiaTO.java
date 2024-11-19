package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class EnergiaTO {
    private Long idFonteEnergia;
    @NotNull
    private String nomeFonte;
    @NotNull
    private String descricao;

    public EnergiaTO() {
    }

    public EnergiaTO(Long idFonteEnergia, String nomeFonte, String descricao) {
        this.idFonteEnergia = idFonteEnergia;
        this.nomeFonte = nomeFonte;
        this.descricao = descricao;
    }

    public Long getIdFonteEnergia() {
        return idFonteEnergia;
    }

    public void setIdFonteEnergia(Long idFonteEnergia) {
        this.idFonteEnergia = idFonteEnergia;
    }

    public String getNomeFonte() {
        return nomeFonte;
    }

    public void setNomeFonte(String nomeFonte) {
        this.nomeFonte = nomeFonte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

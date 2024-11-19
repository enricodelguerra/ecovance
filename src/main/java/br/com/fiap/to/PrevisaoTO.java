package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class PrevisaoTO {
    private Long idPrevisao;
    private Long idProjeto;
    @PastOrPresent
    private LocalDate dataPrevisao;
    @NotNull
    private String tipoEnergia;
    @NotNull
    private Double geracaoPrevisao;
    @NotNull
    private String intensidadePrevisao;

    public PrevisaoTO() {}

    public PrevisaoTO(Long idPrevisao, Long idProjeto, LocalDate dataPrevisao, String tipoEnergia, Double geracaoPrevisao, String intensidadePrevisao) {
        this.idPrevisao = idPrevisao;
        this.idProjeto = idProjeto;
        this.dataPrevisao = dataPrevisao;
        this.tipoEnergia = tipoEnergia;
        this.geracaoPrevisao = geracaoPrevisao;
        this.intensidadePrevisao = intensidadePrevisao;
    }

    public Long getIdPrevisao() {
        return idPrevisao;
    }

    public void setIdPrevisao(Long idPrevisao) {
        this.idPrevisao = idPrevisao;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public LocalDate getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(LocalDate dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public Double getGeracaoPrevisao() {
        return geracaoPrevisao;
    }

    public void setGeracaoPrevisao(Double geracaoPrevisao) {
        this.geracaoPrevisao = geracaoPrevisao;
    }

    public String getIntensidadePrevisao() {
        return intensidadePrevisao;
    }

    public void setIntensidadePrevisao(String intensidadePrevisao) {
        this.intensidadePrevisao = intensidadePrevisao;
    }
}

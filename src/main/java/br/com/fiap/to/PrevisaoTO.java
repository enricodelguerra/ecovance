package br.com.fiap.to;

import java.time.LocalDate;

public class PrevisaoTO {
    private Long idPrevisao;
    private Long idProjeto;
    private LocalDate dataPrevisao;
    private String tipoEnergia;
    private Double geracaoPrevisao;
    private String intensidadePrevisao;

    public PrevisaoTO() {}

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

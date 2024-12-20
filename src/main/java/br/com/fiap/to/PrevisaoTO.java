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

    public @PastOrPresent LocalDate getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(@PastOrPresent LocalDate dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public @NotNull String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(@NotNull String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public @NotNull Double getGeracaoPrevisao() {
        return geracaoPrevisao;
    }

    public void setGeracaoPrevisao(@NotNull Double geracaoPrevisao) {
        this.geracaoPrevisao = geracaoPrevisao;
    }

    public @NotNull String getIntensidadePrevisao() {
        return intensidadePrevisao;
    }

    public void setIntensidadePrevisao(@NotNull String intensidadePrevisao) {
        this.intensidadePrevisao = intensidadePrevisao;
    }

    public void padronizarEnergia() {
        if (tipoEnergia != null) {
            this.tipoEnergia = tipoEnergia.trim().toLowerCase();
        }
    }
    public void padronizarIntensidadePrevisao() {
        if (intensidadePrevisao != null) {
            this.intensidadePrevisao = intensidadePrevisao.trim().toLowerCase();
        }
    }

    public boolean validarPrevisao() {
        if ("alta".equalsIgnoreCase(intensidadePrevisao) && geracaoPrevisao < 1000) {
            return false; // Intensidade alta deve ter geração acima de 1000
        } else if ("media".equalsIgnoreCase(intensidadePrevisao) && (geracaoPrevisao < 500 || geracaoPrevisao >= 1000)) {
            return false; // Intensidade média deve ter geração entre 500 e 999
        } else if ("baixa".equalsIgnoreCase(intensidadePrevisao) && geracaoPrevisao >= 500) {
            return false; // Intensidade baixa deve ter geração abaixo de 500
        }
        return true;
    }
}


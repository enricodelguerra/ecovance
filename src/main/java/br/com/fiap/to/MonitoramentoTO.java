package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class MonitoramentoTO {
    private Long idMonitoramento;
    private Long idProjeto;
    @PastOrPresent
    private LocalDate dataMonitoramento;
    @NotNull
    private String tipoEnergia;
    @NotNull
    private Double geracaoAtual;
    @NotNull
    private String status;

    public MonitoramentoTO() {
    }

    public MonitoramentoTO(Long idMonitoramento, Long idProjeto, LocalDate dataMonitoramento, String tipoEnergia, Double geracaoAtual, String status) {
        this.idMonitoramento = idMonitoramento;
        this.idProjeto = idProjeto;
        this.dataMonitoramento = dataMonitoramento;
        this.tipoEnergia = tipoEnergia;
        this.geracaoAtual = geracaoAtual;
        this.status = status;
    }

    public Long getIdMonitoramento() {
        return idMonitoramento;
    }

    public void setIdMonitoramento(Long idMonitoramento) {
        this.idMonitoramento = idMonitoramento;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public @PastOrPresent LocalDate getDataMonitoramento() {
        return dataMonitoramento;
    }

    public void setDataMonitoramento(@PastOrPresent LocalDate dataMonitoramento) {
        this.dataMonitoramento = dataMonitoramento;
    }

    public @NotNull String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(@NotNull String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public @NotNull Double getGeracaoAtual() {
        return geracaoAtual;
    }

    public void setGeracaoAtual(@NotNull Double geracaoAtual) {
        this.geracaoAtual = geracaoAtual;
    }

    public @NotNull String getStatus() {
        return status;
    }

    public void setStatus(@NotNull String status) {
        this.status = status;
    }

    public void padronizarEnergia() {
        if (tipoEnergia != null) {
            this.tipoEnergia = tipoEnergia.trim().toLowerCase();
        }
    }

    public void padronizarStatus() {
        if ( status != null) {
            this.status = status.trim().toLowerCase();
        }
    }
}

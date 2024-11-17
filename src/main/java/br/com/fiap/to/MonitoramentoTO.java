package br.com.fiap.to;

import java.time.LocalDate;

public class MonitoramentoTO {
    private Long idMonitoramento;
    private Long idProjeto;
    private LocalDate dataMonitoramento;
    private String tipoEnergia;
    private Double geracaoAtual;
    //private Double capacidadeArmazenamento;
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

    public LocalDate getDataMonitoramento() {
        return dataMonitoramento;
    }

    public void setDataMonitoramento(LocalDate dataMonitoramento) {
        this.dataMonitoramento = dataMonitoramento;
    }

    public String getTipoEnergia() {
        return this.tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public Double getGeracaoAtual() {
        return geracaoAtual;
    }

    public void setGeracaoAtual(Double geracaoAtual) {
        this.geracaoAtual = geracaoAtual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

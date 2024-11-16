package br.com.fiap.to;

import java.time.LocalDate;

public class MonitoramentoTO {
    private Long idMonitoramento;
    private Long idProjeto;
    private LocalDate dataMonitoramento;
    private String TipoEnergia;
    private Double geracaoAtual;
    //private Double capacidadeArmazenamento;
    private String intensidadePrevisao;

    public MonitoramentoTO() {
    }

    public MonitoramentoTO(Long idMonitoramento, Long idProjeto, LocalDate dataMonitoramento, String tipoEnergia, Double geracaoAtual, String intensidadePrevisao) {
        this.idMonitoramento = idMonitoramento;
        this.idProjeto = idProjeto;
        this.dataMonitoramento = dataMonitoramento;
        TipoEnergia = tipoEnergia;
        this.geracaoAtual = geracaoAtual;
        this.intensidadePrevisao = intensidadePrevisao;
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
        return TipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        TipoEnergia = tipoEnergia;
    }

    public Double getGeracaoAtual() {
        return geracaoAtual;
    }

    public void setGeracaoAtual(Double geracaoAtual) {
        this.geracaoAtual = geracaoAtual;
    }

    public String getIntensidadePrevisao() {
        return intensidadePrevisao;
    }

    public void setIntensidadePrevisao(String intensidadePrevisao) {
        this.intensidadePrevisao = intensidadePrevisao;
    }
}

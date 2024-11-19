package br.com.fiap.to;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class AtividadeTO {
    private Long idAtividade;
    @NotNull
    private Long id_projeto;
    @NotNull
    private String nome;
    @NotNull
    private String descricao;
    private String responsavel;
    @PastOrPresent
    private LocalDate dataInicio;
    @Future
    private LocalDate dataFim;

    public AtividadeTO() {
    }

    public AtividadeTO(Long idAtividade, Long id_projeto, String nome, String descricao, String responsavel, LocalDate dataInicio, LocalDate dataFim) {
        this.idAtividade = idAtividade;
        this.id_projeto = id_projeto;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Long getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Long id_projeto) {
        this.id_projeto = id_projeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}

package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class ProjetoTO {
    private Long idProjeto;
    @NotNull
    private String nome;
    @NotNull
    private String descricao;
    @NotNull
    private String localizacao;
    @NotNull
    private Long idFonte;

    public ProjetoTO() {
    }

    public ProjetoTO(Long idProjeto, String nome, String descricao, String localizacao, Long idFonte) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.idFonte = idFonte;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Long getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(Long idFonte) {
        this.idFonte = idFonte;
    }

    public void padronizarLocalizacao() {
        if (localizacao != null) {
            this.localizacao = localizacao.trim().toUpperCase();
        }
    }

    // Valida se o idFonte está dentro do intervalo permitido (1 a 6)
    public boolean possuiFontesRelacionadas() {
        return idFonte >= 1 && idFonte <= 6;  // Verifica se o ID da fonte está entre 1 e 6
    }

}

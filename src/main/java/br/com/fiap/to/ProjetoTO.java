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
    private String tipoEnergia;

    public ProjetoTO() {
    }

    public ProjetoTO(Long idProjeto, String nome, String descricao, String localizacao, String tipoEnergia) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.tipoEnergia = tipoEnergia;
    }


    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotNull String nome) {
        this.nome = nome;
    }

    public @NotNull String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull String descricao) {
        this.descricao = descricao;
    }

    public @NotNull String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(@NotNull String localizacao) {
        this.localizacao = localizacao;
    }

    public @NotNull String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(@NotNull String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public void padronizarLocalizacao() {
        if (localizacao != null) {
            this.localizacao = localizacao.trim().toUpperCase();
        }
    }

    public void padronizarEnergia() {
        if (tipoEnergia != null) {
            this.tipoEnergia = tipoEnergia.trim().toLowerCase();
        }
    }

}

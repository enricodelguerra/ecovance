package br.com.fiap.to;

public class ProjetoTO {
    private Long codigo;
    private String nome;
    private String descricao;
    private String localizacao;
    private Long idfonte;

    public ProjetoTO() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Long getIdfonte() {
        return idfonte;
    }

    public void setIdfonte(Long idfonte) {
        this.idfonte = idfonte;
    }
}

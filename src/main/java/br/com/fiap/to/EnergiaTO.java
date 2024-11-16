package br.com.fiap.to;

public class EnergiaTO {
    private Long idFOnteEnergia;
    private String nomeFonte;
    private String descricao;

    public EnergiaTO() {
    }

    public EnergiaTO(Long idFOnteEnergia, String nomeFonte, String descricao) {
        this.idFOnteEnergia = idFOnteEnergia;
        this.nomeFonte = nomeFonte;
        this.descricao = descricao;
    }

    public Long getIdFOnteEnergia() {
        return idFOnteEnergia;
    }

    public void setIdFOnteEnergia(Long idFOnteEnergia) {
        this.idFOnteEnergia = idFOnteEnergia;
    }

    public String getNomeFonte() {
        return nomeFonte;
    }

    public void setNomeFonte(String nomeFonte) {
        this.nomeFonte = nomeFonte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

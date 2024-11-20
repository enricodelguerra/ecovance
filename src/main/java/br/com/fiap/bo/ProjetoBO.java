package br.com.fiap.bo;

import br.com.fiap.dao.ProjetoDAO;
import br.com.fiap.to.ProjetoTO;

import java.util.ArrayList;

public class ProjetoBO {
    ProjetoDAO ProjetoDAO;

    public ArrayList<ProjetoTO> findAll() {
        ProjetoDAO = new ProjetoDAO();
        return ProjetoDAO.findAll();
    }

    public ProjetoTO findById(Long id) {
        ProjetoDAO = new ProjetoDAO();
        return ProjetoDAO.findByid(id);
    }

    public ProjetoTO save(ProjetoTO projeto) {
        ProjetoDAO = new ProjetoDAO();
        // Valida o relacionamento com a fonte, verificando se está entre 1 e 6
        if (!projeto.possuiFontesRelacionadas()) {
            throw new IllegalArgumentException("Projeto não está associado a uma fonte válida. Fonte deve estar entre 1 e 6.");
        }
        projeto.padronizarLocalizacao();
        return ProjetoDAO.save(projeto);
    }

    public ProjetoTO edit(ProjetoTO projeto) {
        ProjetoDAO = new ProjetoDAO();
        // Valida o relacionamento com a fonte, verificando se está entre 1 e 6
        if (!projeto.possuiFontesRelacionadas()) {
            throw new IllegalArgumentException("Projeto não está associado a uma fonte válida. Fonte deve estar entre 1 e 6.");
        }
        projeto.padronizarLocalizacao();
        return ProjetoDAO.edit( projeto);
    }

    public boolean delete(Long codigo) {
        ProjetoDAO = new ProjetoDAO();
        return ProjetoDAO.delete(codigo);
    }
}

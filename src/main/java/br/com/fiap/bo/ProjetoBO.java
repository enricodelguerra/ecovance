package br.com.fiap.bo;

import br.com.fiap.dao.ProjetoDAO;
import br.com.fiap.exceptions.ProjetoValidationException;
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
        if (id == null || id <= 0) {
            throw new ProjetoValidationException("ID do projeto inválido.");
        }
        return ProjetoDAO.findByid(id);
    }

    public ProjetoTO save(ProjetoTO projeto) {
        ProjetoDAO = new ProjetoDAO();
        projeto.padronizarLocalizacao();
        projeto.padronizarEnergia();
        return ProjetoDAO.save(projeto);
    }

    public ProjetoTO edit(ProjetoTO projeto) {
        ProjetoDAO = new ProjetoDAO();
        projeto.padronizarLocalizacao();
        projeto.padronizarEnergia();
        return ProjetoDAO.edit( projeto);
    }

    public boolean delete(Long codigo) {
        ProjetoDAO = new ProjetoDAO();
        return ProjetoDAO.delete(codigo);
    }
}

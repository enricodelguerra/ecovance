package br.com.fiap.bo;

import br.com.fiap.dao.AtividadeDAO;
import br.com.fiap.exceptions.AtividadeValidationException;
import br.com.fiap.to.AtividadeTO;

import java.util.ArrayList;

public class AtividadeBO {
    AtividadeDAO AtividadeDAO;

    public ArrayList<AtividadeTO> findAll() {
        AtividadeDAO = new AtividadeDAO();
        return AtividadeDAO.findAll();
    }

    public AtividadeTO findById(Long id) {
        AtividadeDAO = new AtividadeDAO();
        if (id == null || id <= 0) {
            throw new AtividadeValidationException("ID da atividade inválido.");
        }
        return AtividadeDAO.findById(id);
    }

    public AtividadeTO save(AtividadeTO atividade) {
        AtividadeDAO = new AtividadeDAO();
        return AtividadeDAO.save(atividade);
    }

    public AtividadeTO edit( AtividadeTO atividade) {
        AtividadeDAO = new AtividadeDAO();
        return AtividadeDAO.edit(atividade);
    }

    public boolean delete(Long codigo) {
        AtividadeDAO = new AtividadeDAO();
        return AtividadeDAO.delete(codigo);
    }

}

package br.com.fiap.bo;

import br.com.fiap.dao.EnergiaDAO;
import br.com.fiap.exceptions.AtividadeValidationException;
import br.com.fiap.to.EnergiaTO;

import java.util.ArrayList;

public class EnergiaBO {
    EnergiaDAO EnergiaDAO;

    public ArrayList<EnergiaTO> findAll() {
        EnergiaDAO = new EnergiaDAO();
        return EnergiaDAO.findAll();
    }

    public EnergiaTO findById(Long id) {
        EnergiaDAO = new EnergiaDAO();
        if (id == null || id <= 0) {
            throw new AtividadeValidationException("ID da atividade inválido.");
        }
        return EnergiaDAO.findById(id);
    }

    public EnergiaTO save(EnergiaTO energia) {
        EnergiaDAO = new EnergiaDAO();
        return EnergiaDAO.save(energia);
    }

    public EnergiaTO edit( EnergiaTO energia) {
        EnergiaDAO = new EnergiaDAO();
        return EnergiaDAO.edit(energia);
    }

    public boolean delete(Long codigo) {
        EnergiaDAO = new EnergiaDAO();
         return EnergiaDAO.delete(codigo);
    }
}

package br.com.fiap.bo;

import br.com.fiap.dao.EnergiaDAO;
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
        return EnergiaDAO.findById(id);
    }

    public EnergiaTO save(EnergiaTO energia) {
        EnergiaDAO = new EnergiaDAO();
        return EnergiaDAO.save(energia);
    }

    public EnergiaTO edit(Long id, EnergiaTO energia) {
        EnergiaDAO = new EnergiaDAO();
        return EnergiaDAO.edit(id, energia);
    }

    public boolean delete(Long codigo) {
        EnergiaDAO = new EnergiaDAO();
         return EnergiaDAO.delete(codigo);
    }
}

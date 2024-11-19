package br.com.fiap.bo;

import br.com.fiap.dao.PrevisaoDAO;
import br.com.fiap.to.PrevisaoTO;

import java.util.ArrayList;

public class PrevisaoBO {
    PrevisaoDAO PrevisaoDAO;

    public ArrayList<PrevisaoTO> findAll() {
        PrevisaoDAO = new PrevisaoDAO();
        return PrevisaoDAO.findAll();
    }

    public PrevisaoTO findById(Long id) {
        PrevisaoDAO = new PrevisaoDAO();
        return PrevisaoDAO.findByid(id);
    }

    public PrevisaoTO save(PrevisaoTO previsao) {
        PrevisaoDAO = new PrevisaoDAO();
        return PrevisaoDAO.save(previsao);
    }

    public PrevisaoTO edit(PrevisaoTO previsao) {
        PrevisaoDAO = new PrevisaoDAO();
        return PrevisaoDAO.edit( previsao);
    }

    public boolean delete(Long codigo) {
        return PrevisaoDAO.delete(codigo);
    }
}

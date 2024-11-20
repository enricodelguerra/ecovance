package br.com.fiap.bo;

import br.com.fiap.dao.PrevisaoDAO;
import br.com.fiap.exceptions.AtividadeValidationException;
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
        if (id == null || id <= 0) {
            throw new AtividadeValidationException("ID da atividade inválido.");
        }
        return PrevisaoDAO.findByid(id);
    }

    public PrevisaoTO save(PrevisaoTO previsao) {
        PrevisaoDAO = new PrevisaoDAO();
        if (!previsao.validarPrevisao()) {
            throw new IllegalArgumentException("Dados de previsão inválidos para salvar.");
        }
        return PrevisaoDAO.save(previsao);
    }


    public PrevisaoTO edit(PrevisaoTO previsao) {
        PrevisaoDAO = new PrevisaoDAO();
        return PrevisaoDAO.edit( previsao);
    }

    public boolean delete(Long codigo) {
        PrevisaoDAO = new PrevisaoDAO();
        return PrevisaoDAO.delete(codigo);
    }
}

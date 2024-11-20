package br.com.fiap.bo;

import br.com.fiap.dao.MonitoramentoDAO;
import br.com.fiap.exceptions.AtividadeValidationException;
import br.com.fiap.exceptions.MonitoramentoValidationException;
import br.com.fiap.to.MonitoramentoTO;

import java.util.ArrayList;

public class MonitoramentoBO {
    MonitoramentoDAO MonitoramentoDAO;

    public ArrayList<MonitoramentoTO> findAll() {
        MonitoramentoDAO = new MonitoramentoDAO();
        return MonitoramentoDAO.findAll();
    }

    public MonitoramentoTO findById(Long id) {
        MonitoramentoDAO = new MonitoramentoDAO();
        if (id == null || id <= 0) {
            throw new AtividadeValidationException("ID da atividade inválido.");
        }
        return MonitoramentoDAO.findById(id);
    }

    public MonitoramentoTO save(MonitoramentoTO monitoramento) {
        MonitoramentoDAO = new MonitoramentoDAO();
        return MonitoramentoDAO.save(monitoramento);
    }

    public MonitoramentoTO edit(MonitoramentoTO monitoramento) {
        MonitoramentoDAO = new MonitoramentoDAO();
        // Verifica se o monitoramento está no status "finalizado" (não editável)
        if ("finalizado".equalsIgnoreCase(monitoramento.getStatus())) {
            throw new MonitoramentoValidationException("Não é possível editar um monitoramento finalizado.");
        }
        return MonitoramentoDAO.edit( monitoramento);
    }

    public boolean delete(Long codigo) {
        MonitoramentoDAO = new MonitoramentoDAO();
        return MonitoramentoDAO.delete(codigo);
    }
}

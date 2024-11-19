package br.com.fiap.bo;

import br.com.fiap.dao.MonitoramentoDAO;
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
        return MonitoramentoDAO.findById(id);
    }

    public MonitoramentoTO save(MonitoramentoTO monitoramento) {
        MonitoramentoDAO = new MonitoramentoDAO();
        return MonitoramentoDAO.save(monitoramento);
    }

    public MonitoramentoTO edit(MonitoramentoTO monitoramento) {
        MonitoramentoDAO = new MonitoramentoDAO();
        return MonitoramentoDAO.edit( monitoramento);
    }

    public boolean delete(Long codigo) {
        MonitoramentoDAO = new MonitoramentoDAO();
        return MonitoramentoDAO.delete(codigo);
    }
}

package br.com.fiap.dao;

import br.com.fiap.to.MonitoramentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonitoramentoDAO extends Repository {
    public ArrayList<MonitoramentoTO> findAll() {
        ArrayList<MonitoramentoTO> monitoramentos = new ArrayList<>();
        String sql = "select * from t_eco_monitoramento";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MonitoramentoTO monitoramento = new MonitoramentoTO();
                    monitoramento.setIdMonitoramento(rs.getLong("id_monitoramento"));
                    monitoramento.setIdProjeto(rs.getLong("id_projeto"));
                    monitoramento.setDataMonitoramento(rs.getDate("data_monitoramento").toLocalDate());
                    monitoramento.setTipoEnergia(rs.getString("tipo_energia"));
                    monitoramento.setGeracaoAtual(rs.getDouble("geracao_atual"));
                    monitoramento.setStatus(rs.getString("status"));
                    monitoramentos.add(monitoramento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return monitoramentos;
    }
}

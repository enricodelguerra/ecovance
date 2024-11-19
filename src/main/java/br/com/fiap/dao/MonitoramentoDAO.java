package br.com.fiap.dao;

import br.com.fiap.to.MonitoramentoTO;

import java.sql.Date;
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

    public MonitoramentoTO findById(Long id) {
        String sql = "select * from t_eco_monitoramento where id_monitoramento = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MonitoramentoTO monitoramento = new MonitoramentoTO();
                monitoramento.setIdMonitoramento(rs.getLong("id_monitoramento"));
                monitoramento.setIdProjeto(rs.getLong("id_projeto"));
                monitoramento.setDataMonitoramento(rs.getDate("data_monitoramento").toLocalDate());
                monitoramento.setTipoEnergia(rs.getString("tipo_energia"));
                monitoramento.setGeracaoAtual(rs.getDouble("geracao_atual"));
                monitoramento.setStatus(rs.getString("status"));
                return monitoramento;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public MonitoramentoTO save(MonitoramentoTO monitoramento) {
        String sql = "insert into t_eco_monitoramento (ID_PROJETO, DATA_MONITORAMENTO, TIPO_ENERGIA, GERACAO_ATUAL, STATUS) values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, monitoramento.getIdProjeto());
            ps.setDate(2, Date.valueOf(monitoramento.getDataMonitoramento()));
            ps.setString(3, monitoramento.getTipoEnergia());
            ps.setDouble(4, monitoramento.getGeracaoAtual());
            ps.setString(5, monitoramento.getStatus());
            if (ps.executeUpdate() > 0) {
                return monitoramento;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public MonitoramentoTO edit(MonitoramentoTO monitoramento) {
        String sql = "update t_eco_monitoramento set DATA_MONITORAMENTO = ?, TIPO_ENERGIA = ?, GERACAO_ATUAL = ?, STATUS =? where ID_MONITORAMENTO = ? ";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(5, monitoramento.getIdMonitoramento());
            ps.setDate(1, Date.valueOf(monitoramento.getDataMonitoramento()));
            ps.setString(2, monitoramento.getTipoEnergia());
            ps.setDouble(3, monitoramento.getGeracaoAtual());
            ps.setString(4, monitoramento.getStatus());
            if (ps.executeUpdate() > 0) {
                return monitoramento;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete t_eco_monitoramento where ID_MONITORAMENTO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

}

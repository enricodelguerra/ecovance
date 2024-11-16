package br.com.fiap.dao;

import br.com.fiap.to.AtividadeTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtividadeDAO extends Repository{
    public ArrayList<AtividadeTO> findAll() {
        ArrayList<AtividadeTO> atividades = new ArrayList<>();
        String sql = "Select * from t_eco_atividade";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        AtividadeTO atividade = new AtividadeTO();
                        atividade.setIdAtividade(rs.getLong("id_atividade"));
                        atividade.setId_projeto(rs.getLong("id_projeto"));
                        atividade.setNome(rs.getString("nome"));
                        atividade.setDescricao(rs.getString("descricao"));
                        atividade.setResponsavel(rs.getString("responsavel"));
                        atividade.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                        atividade.setDataFim(rs.getDate("data_fim").toLocalDate());
                        atividades.add(atividade);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Erro de SQL! " + e.getMessage());
            } finally {
                closeConnection();
            }
            return atividades;
    }

    public AtividadeTO findById(Long id) {
        String sql = "select * from t_eco_atividade where id_atividade = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AtividadeTO atividade = new AtividadeTO();
                atividade.setIdAtividade(rs.getLong("id_atividade"));
                atividade.setId_projeto(rs.getLong("id_projeto"));
                atividade.setNome(rs.getString("nome"));
                atividade.setDescricao(rs.getString("descricao"));
                atividade.setResponsavel(rs.getString("responsavel"));
                atividade.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                atividade.setDataFim(rs.getDate("data_fim").toLocalDate());
                return atividade;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public AtividadeTO save(AtividadeTO atividade) {
        String sql = "insert into t_eco_atividade (ID_PROJETO, NOME, DESCRICAO, RESPONSAVEL, DATA_INICIO, DATA_FIM) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, atividade.getId_projeto());
            ps.setString(2, atividade.getNome());
            ps.setString(3, atividade.getDescricao());
            ps.setString(4, atividade.getResponsavel());
            ps.setDate(5, Date.valueOf(atividade.getDataInicio()));
            ps.setDate(6, Date.valueOf(atividade.getDataFim()));
            if (ps.executeUpdate() > 0) {
                return atividade;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public AtividadeTO edit(AtividadeTO atividade, Long id) {
        String sql = "update t_eco_atividade set NOME = ?, DESCRICAO = ?, RESPONSAVEL = ?, DATA_INICIO = ?, DATA_FIM = ? where ID_ATIVIDADE = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(6, id);
            ps.setString(1, atividade.getNome());
            ps.setString(2, atividade.getDescricao());
            ps.setString(3, atividade.getResponsavel());
            ps.setDate(4, Date.valueOf(atividade.getDataInicio()));
            ps.setDate(5, Date.valueOf(atividade.getDataFim()));
            if (ps.executeUpdate() > 0) {
                return atividade;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete t_eco_atividade where ID_ATIVIDADE = ?";
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

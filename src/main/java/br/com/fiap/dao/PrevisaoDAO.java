package br.com.fiap.dao;

import br.com.fiap.to.PrevisaoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrevisaoDAO extends Repository{
    public ArrayList<PrevisaoTO> findAll() {
        ArrayList<PrevisaoTO> previsoes = new ArrayList<>();
        String sql = "select * from t_eco_previsao";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PrevisaoTO previsao = new PrevisaoTO();
                    previsao.setIdPrevisao(rs.getLong("id_previsao"));
                    previsao.setIdProjeto(rs.getLong("id_projeto"));
                    previsao.setDataPrevisao(rs.getDate("data_previsao").toLocalDate());
                    previsao.setTipoEnergia(rs.getString("tipo_energia"));
                    previsao.setGeracaoPrevisao(rs.getDouble("localizacao"));
                    previsao.setIntensidadePrevisao(rs.getString("intensidade_previsao"));
                   previsoes.add(previsao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return previsoes;
    }

    public PrevisaoTO findByid(Long id) {
        String sql = "select * from t_eco_previsao where id_previsao = ? ";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PrevisaoTO previsao = new PrevisaoTO();
                previsao.setIdPrevisao(rs.getLong("id_previsao"));
                previsao.setIdProjeto(rs.getLong("id_projeto"));
                previsao.setDataPrevisao(rs.getDate("data_previsao").toLocalDate());
                previsao.setTipoEnergia(rs.getString("tipo_energia"));
                previsao.setGeracaoPrevisao(rs.getDouble("localizacao"));
                previsao.setIntensidadePrevisao(rs.getString("intensidade_previsao"));
                return previsao;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL!" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public PrevisaoTO save(PrevisaoTO previsao) {
        String sql = "insert into t_eco_previsao (DATA_PREVISAO , TIPO_ENERGIA, GERACAO_PREVISAO, INTENSIDADE_PREVISAO, ID_PROJETO) values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(previsao.getDataPrevisao()));
            ps.setString(2, previsao.getTipoEnergia());
            ps.setDouble(3, previsao.getGeracaoPrevisao());
            ps.setString(4, previsao.getIntensidadePrevisao());
            ps.setLong(5, previsao.getIdProjeto());
            if (ps.executeUpdate() > 0) {
                return previsao;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public PrevisaoTO edit(Long id, PrevisaoTO previsao) {
        String sql = "update t_eco_previsao set DATA_PREVISAO = ?, TIPOENERGIA = ?, GERACAO_PREVISAO = ? where ID_PREVISAO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(5, id);
            ps.setDate(1, Date.valueOf(previsao.getDataPrevisao()));
            ps.setString(2, previsao.getTipoEnergia());
            ps.setDouble(3, previsao.getGeracaoPrevisao());
            ps.setString(4, previsao.getIntensidadePrevisao());
           previsao.setIdPrevisao(id);
            if (ps.executeUpdate() > 0) {
                return previsao;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete t_eco_previsao where ID_PREVISAO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }
}

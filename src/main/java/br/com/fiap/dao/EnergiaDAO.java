package br.com.fiap.dao;

import br.com.fiap.to.EnergiaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnergiaDAO extends Repository {
    public ArrayList<EnergiaTO> findAll() {
        ArrayList<EnergiaTO> energias = new ArrayList<>();
        String sql = "select * from t_eco_fonte_energia";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    EnergiaTO energia = new EnergiaTO();
                    energia.setIdFonteEnergia(rs.getLong("id_fonte_energia"));
                    energia.setNomeFonte(rs.getString("nome"));
                    energia.setDescricao(rs.getString("descricao"));
                    energias.add(energia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return energias;
    }

    public EnergiaTO findById(Long id) {
        String sql = "select * from t_eco_fonte_energia where id_fonte_energia";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            EnergiaTO energia = new EnergiaTO();
            energia.setIdFonteEnergia(rs.getLong("id_fonte_energia"));
            energia.setNomeFonte(rs.getString("nome"));
            energia.setDescricao(rs.getString("descricao"));
            return energia;
        }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public EnergiaTO save(EnergiaTO energia) {
        String sql = "insert into t_eco_fonte_energia (NOME, DESCRICAO) values (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, energia.getNomeFonte());
            ps.setString(2, energia.getDescricao());
            if (ps.executeUpdate() > 0) {
                return energia;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public EnergiaTO edit(Long id, EnergiaTO energia) {
        String sql= "update t_eco_fonte_energia set NOME = ?, DESCRICAO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(3, id);
            ps.setString(1, energia.getNomeFonte());
            ps.setString(2, energia.getDescricao());
            energia.setIdFonteEnergia(id);
            if (ps.executeUpdate() > 0) {
                return energia;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete t_eco_fonte_energia where ID_FONTE_ENERGIA = ?";
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

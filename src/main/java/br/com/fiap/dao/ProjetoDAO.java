package br.com.fiap.dao;

import br.com.fiap.to.ProjetoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoDAO extends Repository{
    public ArrayList<ProjetoTO> findAll() {
        ArrayList<ProjetoTO> projetos = new ArrayList<>();
        String sql = "select * from t_eco_projeto";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProjetoTO projeto = new ProjetoTO();
                    projeto.setIdProjeto(rs.getLong("id_projeto"));
                    projeto.setNome(rs.getString("nome"));
                    projeto.setDescricao(rs.getString("descricao"));
                    projeto.setLocalizacao(rs.getString("localizacao"));
                    projeto.setTipoEnergia(rs.getString("tipo_energia"));
                    projetos.add(projeto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return projetos;
    }

    public ProjetoTO findByid(Long id) {
        String sql = "select * from t_eco_projeto where id_projeto = ? ";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProjetoTO projeto = new ProjetoTO();
                projeto.setIdProjeto(rs.getLong("id_projeto"));
                projeto.setNome(rs.getString("nome"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setLocalizacao(rs.getString("localizacao"));
                projeto.setTipoEnergia(rs.getString("tipo_energia"));
                return projeto;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL!" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProjetoTO save(ProjetoTO projeto) {
        String sql = "insert into t_eco_projeto (NOME , DESCRICAO, LOCALIZACAO, TIPO_ENERGIA) values (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getLocalizacao());
            ps.setString(4, projeto.getTipoEnergia());
            if (ps.executeUpdate() > 0) {
                return projeto;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProjetoTO edit( ProjetoTO projeto) {
        String sql = "update t_eco_projeto set NOME = ?, DESCRICAO = ?, LOCALIZACAO = ?, TIPO_ENERGIA = ? where ID_PROJETO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(5, projeto.getIdProjeto());
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getLocalizacao());
            ps.setString(4, projeto.getTipoEnergia());
            if (ps.executeUpdate() > 0) {
                return projeto;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete t_eco_projeto where ID_PROJETO = ?";
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

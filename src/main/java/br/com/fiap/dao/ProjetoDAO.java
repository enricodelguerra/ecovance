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
                    projeto.setIdFonte(rs.getLong("id_fonte"));
                    projeto.setIdProjeto(rs.getLong("id_projeto"));
                    projeto.setNome(rs.getString("nome"));
                    projeto.setDescricao(rs.getString("descricao"));
                    projeto.setLocalizacao("localizacao");
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
                projeto.setIdFonte(rs.getLong("id_fonte"));
                projeto.setIdProjeto(rs.getLong("id_projeto"));
                projeto.setNome(rs.getString("nome"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setLocalizacao(rs.getString("localizacao"));
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
        String sql = "insert into t_eco_projeto (NOME , DESCRICAO, LOCALIZACAO, ID_FONTE) values (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getLocalizacao());
            ps.setLong(4, projeto.getIdFonte());
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

    public ProjetoTO edit(Long id, ProjetoTO projeto) {
        String sql = "update t_eco_projeto set NOME = ?, DESCRICAO = ?, LOCALIZACAO = ? where ID_PROJETO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(4, id);
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getLocalizacao());
            projeto.setIdProjeto(id);
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

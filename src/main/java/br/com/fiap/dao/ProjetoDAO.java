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
}

package br.edu.ifpa.laboratorio.dao;

import br.edu.ifpa.laboratorio.database.ConexaoMySQL;
import br.edu.ifpa.laboratorio.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlunoDAO {

    public boolean cadastrarAluno(Aluno aluno) {

        String sql =
                "INSERT INTO aluno(nome, matricula) VALUES (?, ?)";

        try (
                Connection conn = ConexaoMySQL.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public Aluno buscarAluno(int id) {

        String sql =
                "SELECT * FROM aluno WHERE id = ?";

        try (
                Connection conn = ConexaoMySQL.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setMatricula(rs.getString("matricula"));

                return aluno;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }
}

package br.edu.ifpa.laboratorio.dao;

import br.edu.ifpa.laboratorio.database.ConexaoMySQL;
import br.edu.ifpa.laboratorio.model.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    public boolean cadastrarEquipamento(Equipamento equipamento) {

        String sql =
                "INSERT INTO equipamento(nome, disponivel) VALUES (?, ?)";

        try (
                Connection conn = ConexaoMySQL.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, equipamento.getNome());
            stmt.setBoolean(2, equipamento.isDisponivel());

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public List<Equipamento> listarDisponiveis() {

        List<Equipamento> equipamentos =
                new ArrayList<>();

        String sql =
                "SELECT * FROM equipamento WHERE disponivel = true";

        try (
                Connection conn = ConexaoMySQL.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Equipamento equipamento =
                        new Equipamento();

                equipamento.setId(rs.getInt("id"));
                equipamento.setNome(rs.getString("nome"));
                equipamento.setDisponivel(
                        rs.getBoolean("disponivel")
                );

                equipamentos.add(equipamento);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return equipamentos;
    }

    public boolean atualizarDisponibilidade(
            int id,
            boolean disponivel
    ) {

        String sql =
                "UPDATE equipamento SET disponivel = ? WHERE id = ?";

        try (
                Connection conn = ConexaoMySQL.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setBoolean(1, disponivel);
            stmt.setInt(2, id);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}
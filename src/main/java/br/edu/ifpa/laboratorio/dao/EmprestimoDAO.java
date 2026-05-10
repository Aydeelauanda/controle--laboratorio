package br.edu.ifpa.laboratorio.dao;

import br.edu.ifpa.laboratorio.database.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmprestimoDAO {

    public boolean realizarEmprestimo(
            int idAluno,
            int idEquipamento
    ) {

        String verificar =
                "SELECT disponivel FROM equipamento WHERE id = ?";

        String sqlEmprestimo =
                "INSERT INTO emprestimo " +
                        "(data_emprestimo, status, id_aluno, id_equipamento) " +
                        "VALUES (?, ?, ?, ?)";

        String sqlAtualizar =
                "UPDATE equipamento " +
                        "SET disponivel = false WHERE id = ?";

        try (

                Connection conn =
                        ConexaoMySQL.conectar();

                PreparedStatement stmtVerificar =
                        conn.prepareStatement(verificar);

                PreparedStatement stmtEmprestimo =
                        conn.prepareStatement(sqlEmprestimo);

                PreparedStatement stmtAtualizar =
                        conn.prepareStatement(sqlAtualizar)

        ) {

            stmtVerificar.setInt(1, idEquipamento);

            var rs = stmtVerificar.executeQuery();

            if (rs.next()) {

                boolean disponivel =
                        rs.getBoolean("disponivel");

                if (!disponivel) {

                    System.out.println(
                            "Equipamento indisponível!"
                    );

                    return false;
                }
            }

            stmtEmprestimo.setDate(
                    1,
                    java.sql.Date.valueOf(
                            java.time.LocalDate.now()
                    )
            );

            stmtEmprestimo.setString(2, "ATIVO");

            stmtEmprestimo.setInt(3, idAluno);

            stmtEmprestimo.setInt(4, idEquipamento);

            stmtEmprestimo.executeUpdate();

            stmtAtualizar.setInt(1, idEquipamento);

            stmtAtualizar.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public boolean registrarDevolucao(
            int idEquipamento
    ) {

        String sqlDevolucao =
                "UPDATE emprestimo " +
                        "SET data_devolucao = ?, status = 'FINALIZADO' " +
                        "WHERE id_equipamento = ? AND status = 'ATIVO'";

        String sqlEquipamento =
                "UPDATE equipamento " +
                        "SET disponivel = true WHERE id = ?";

        try (

                Connection conn =
                        ConexaoMySQL.conectar();

                PreparedStatement stmtDevolucao =
                        conn.prepareStatement(sqlDevolucao);

                PreparedStatement stmtEquipamento =
                        conn.prepareStatement(sqlEquipamento)

        ) {

            stmtDevolucao.setDate(
                    1,
                    java.sql.Date.valueOf(
                            java.time.LocalDate.now()
                    )
            );

            stmtDevolucao.setInt(2, idEquipamento);

            stmtDevolucao.executeUpdate();

            stmtEquipamento.setInt(1, idEquipamento);

            stmtEquipamento.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public void listarHistorico() {

        String sql =
                "SELECT * FROM emprestimo";

        try (

                Connection conn =
                        ConexaoMySQL.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            var rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                );

                System.out.println(
                        "Aluno: " +
                                rs.getInt("id_aluno")
                );

                System.out.println(
                        "Equipamento: " +
                                rs.getInt("id_equipamento")
                );

                System.out.println(
                        "Status: " +
                                rs.getString("status")
                );

                System.out.println(
                        "Data empréstimo: " +
                                rs.getDate("data_emprestimo")
                );

                System.out.println(
                        "Data devolução: " +
                                rs.getDate("data_devolucao")
                );

                System.out.println("----------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
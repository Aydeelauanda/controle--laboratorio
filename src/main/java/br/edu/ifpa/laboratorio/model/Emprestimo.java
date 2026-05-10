package br.edu.ifpa.laboratorio.model;

import java.time.LocalDateTime;

public class Emprestimo {

    private int id;
    private int idAluno;
    private int idEquipamento;

    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    private String status;

    public Emprestimo() {
    }

    public Emprestimo(int id, int idAluno, int idEquipamento,
                      LocalDateTime dataEmprestimo,
                      LocalDateTime dataDevolucao,
                      String status) {

        this.id = id;
        this.idAluno = idAluno;
        this.idEquipamento = idEquipamento;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
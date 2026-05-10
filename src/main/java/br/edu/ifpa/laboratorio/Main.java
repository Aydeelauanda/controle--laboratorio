package br.edu.ifpa.laboratorio;

import br.edu.ifpa.laboratorio.dao.EmprestimoDAO;

public class Main {

    public static void main(String[] args) {

        EmprestimoDAO emprestimoDAO =
                new EmprestimoDAO();

        emprestimoDAO.listarHistorico();
    }
}
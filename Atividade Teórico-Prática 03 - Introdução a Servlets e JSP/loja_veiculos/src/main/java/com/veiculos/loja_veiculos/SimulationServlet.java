package com.veiculos.loja_veiculos;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastro_loja")
public class SimulationServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double valorVeiculo =Double.parseDouble(req.getParameter("valor"));
            Double entradaVeiculo = Double.parseDouble(req.getParameter("entrada"));
            Double taxaJuros = Double.parseDouble(req.getParameter("juros"));
            int prazo = Integer.parseInt(req.getParameter("prazo"));


            double financiamento = valorVeiculo - entradaVeiculo;
            taxaJuros = taxaJuros / 100.0;

            double pmt = financiamento * taxaJuros / (1 - (Math.pow(1 + taxaJuros, - prazo)));

            req.setAttribute("valor", valorVeiculo);
            req.setAttribute("entrada", entradaVeiculo);
            req.setAttribute("juros",taxaJuros);
            req.setAttribute("financiamento", financiamento);
            req.setAttribute("prazo", prazo);
            req.setAttribute("pgto_mensal", pmt);
            req.getRequestDispatcher("/results.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.getWriter().print("só funciona com numeros");
        };
        
    }
}

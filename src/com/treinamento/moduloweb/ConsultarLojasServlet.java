package com.treinamento.moduloweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.treinamento.moduloweb.service.LojaService;

@WebServlet("/v1/lojas")
public class ConsultarLojasServlet extends HttpServlet{
	
	public ConsultarLojasServlet() {
		System.out.println("Iniciando a nosssa servlet...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LojaService service = new LojaService();
		List<Loja> listaLojas = service.listarLojas();
		
		Gson json = new Gson();
		
		String resultado = json.toJson(listaLojas);
		
		resp.getWriter().append(resultado);
		resp.setContentType("application/json");
		
//		req.setAttribute("lojas", listaLojas);
//		
//		RequestDispatcher rd = req.getRequestDispatcher("/consulta_loja.jsp");
//		rd.forward(req, resp);
	}
}

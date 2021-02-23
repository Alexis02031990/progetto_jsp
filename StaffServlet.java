package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.StaffDTO;
import it.contrader.service.Service;
import it.contrader.service.StaffService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StaffServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<StaffDTO> service = new StaffService();
		List<StaffDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<StaffDTO> service = new StaffService();
		String mode = request.getParameter("mode");
		StaffDTO dto;
		int id = 0;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "STAFFLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/staff/staffmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/staff/readstaff.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/staff/updatestaff.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nome = request.getParameter("nome");
		    String cognome = request.getParameter("cognome");
		    String email = request.getParameter("email");
		    String posizione = request.getParameter("posizione");
		    String data_assunzione = request.getParameter("data_assunzione");
			int numero_telefono = Integer.parseInt(request.getParameter("numero_telefono"));
			String sede = request.getParameter("sede");
			int ore_settimanali = Integer.parseInt(request.getParameter("ore_settimanali"));
			String codice_fiscale = request.getParameter("codice_fiscale");
			dto = new StaffDTO (id, nome ,cognome,email, posizione, data_assunzione , numero_telefono, sede,ore_settimanali, codice_fiscale);
			
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/staff/staffmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			
			id = Integer.parseInt(request.getParameter("id"));
			nome = request.getParameter("nome");
		    cognome = request.getParameter("cognome");
		    email = request.getParameter("email");
		    posizione = request.getParameter("posizione");
		    data_assunzione = request.getParameter("data_assunzione");
			numero_telefono = Integer.parseInt(request.getParameter("numero_telefono"));
		    sede = request.getParameter("sede");
		    ore_settimanali = Integer.parseInt(request.getParameter("ore_settimanali"));
		    codice_fiscale = request.getParameter("codice_fiscale");
			dto = new StaffDTO (id, nome ,cognome,email, posizione, data_assunzione , numero_telefono, sede,ore_settimanali, codice_fiscale);
			
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/staff/staffmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/staff/staffmanager.jsp").forward(request, response);
			break;
		}
	}
}
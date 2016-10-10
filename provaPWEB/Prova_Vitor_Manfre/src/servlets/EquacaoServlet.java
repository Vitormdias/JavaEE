package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EquacaoServlet
 */
@WebServlet("/EquacaoServlet")
public class EquacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		
		double a,b,c,delta,x1,x2,raizDelta;
		a = Double.parseDouble(request.getParameter("a"));
		b = Double.parseDouble(request.getParameter("b"));
		c = Double.parseDouble(request.getParameter("c"));
		
		if(a == 0) {
			out.println("a não pode ser 0");
		}
		else {
			delta = b*b - (4*a*c);
			if(delta >= 0) {
				raizDelta = Math.sqrt(delta);
				x1 = ((-b) + raizDelta) / (2*a);
				x2 = ((-b) - raizDelta) / (2*a);
				
				out.println("x1 = " + x1);
				out.println("x2 = " + x2);		
				out.println("</body>");
				out.println("</html>");
			}
			else {
				out.println("delta negativo");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

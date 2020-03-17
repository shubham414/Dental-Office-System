package dmddproject.dentalclinic.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import dmddproject.dentalclinic.dao.*;
import dmddproject.detalclinic.model.*;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet", urlPatterns = "/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
 
    //private static final long serialVersionUID = 1L;
   // private LoginDao loginDao;
    
    public void init() {
    	userDAO = new UserDAO();
    	//loginDao = new LoginDao();
    }
    

     
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//loginuser(request, response);
		doGet(request, response);
//		String username = request.getParameter("username");
//	    String password = request.getParameter("password");
//	    LoginBean loginBean = new LoginBean();
//	    loginBean.setUsername(username);
//	    loginBean.setPassword(password);
//
//	    try {
//	        if (userDAO.validate(loginBean)) {
//	            //HttpSession session = request.getSession();
//	            // session.setAttribute("username",username);
//	            response.sendRedirect("user-list.jsp");
//	        } else {
//	            HttpSession session = request.getSession();
//	            session.setAttribute("user", username);
//	            response.sendRedirect("login.jsp");
//	        }
//	    } catch (ClassNotFoundException e) {
//	        e.printStackTrace();
//	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action = request.getServletPath(); 
	
	//loginuser(request, response);
	switch (action) {
	
	case "/newark" :
		showNewDentistForm(request, response);
		break;
		
	case "/newspec" :
		showNewSpecsForm(request, response);
		break;
		
	case "/insert" :
		insertDentist(request, response);		
		break;
		
	case "/insertspec" :
		insertSpecialization(request, response);
		break;
		
	case "/delete" :
		deleteDentist(request, response);
		break;
		
	case "/deletespecs" :
		deleteSpecs(request, response);
		break;
		
	case "/edit" :
		showEditDentistForm(request, response);
		break; 
		
	case "/editspecs" :
		showEditSpecsForm(request, response);
		break;
		
	case "/update" :
		updateDentist(request, response);
		break; 
		
	case "/updatespecs" :
		updateSpecs(request, response);
		break;
		
	case "/home" :
		showhome(request, response);
		break;
		
	case "/list" :
		listDentist(request, response);
		break;
		
	case "/listspecs" :
		listSpecs(request, response);
		break;
		
	case "/validatekar" :
		dovalidation(request, response);
	break;
	
	case "/listinvoice" :
		listInvoice(request, response);
	break;
	
	case "/showinvoiceform" :
		showinvoiceform(request, response);
	break;
	
	case "/updateinvoice" :
		updateInvoice(request, response);
	break;
	
	default:
		loginuser(request, response);
		break;
	}
		
	}
	
	private void dovalidation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    LoginBean loginBean = new LoginBean();
	    loginBean.setUsername(username);
	    loginBean.setPassword(password);

	    try {
	        if (userDAO.validate(loginBean)) {
	            //HttpSession session = request.getSession();
	            // session.setAttribute("username",username);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
	        	dispatcher.forward(request, response);
	        } else {
	            //HttpSession session = request.getSession();
	            //session.setAttribute("user", username);
	            //response.sendRedirect("login.jsp");
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
	        	dispatcher.forward(request, response);
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	private void showhome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showinvoiceform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/invoice-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void loginuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);
		
	}
	

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateInvoice(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String id = request.getParameter("Appointment_ID");
		//String specializationName = request.getParameter("specializationName");
         
		Invoice book = new Invoice(id);
		userDAO.createInvoice(book);
		response.sendRedirect("listinvoice");
	}
	
	
	
	private void listDentist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Dentist> listDentist = userDAO.selectAllDentists();
		request.setAttribute("listDentist", listDentist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/dentist-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listSpecs(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Dentist> listDentist = userDAO.selectAllSpecs();
		request.setAttribute("listDentist", listDentist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/specs-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listInvoice(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Invoice> listUser = userDAO.selectInvoice();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/invoicelist.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewDentistForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/dentist-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewSpecsForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/specs.jsp");
		dispatcher.forward(request, response);
	}
	
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void showEditDentistForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Dentist existingUser = userDAO.selectDentist(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/dentist-form.jsp");
		request.setAttribute("dentist", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void showEditSpecsForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("specializationno"));
		Dentist existingUser = userDAO.selectSpecs(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/specs.jsp");
		request.setAttribute("dentist", existingUser);
		dispatcher.forward(request, response);
	}
	
//	private void showInvoiceForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String id = request.getParameter("Appointment_ID");
//		Invoice existingUser = userDAO.selectInvoice(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/invoice-form.jsp");
//		request.setAttribute("invoice", existingUser);
//		dispatcher.forward(request, response);
//	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		userDAO.insertUser(new User(name, email, country));
		response.sendRedirect("list");
	}
	
	private void insertDentist(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		userDAO.insertDentist(new Dentist(firstName, lastName, email, contact));
		response.sendRedirect("list");
	}
	
	private void insertSpecialization(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int specializationno = Integer.parseInt(request.getParameter("specializationno"));
		String specializationName = request.getParameter("specializationName");
		userDAO.insertSpecialization(new Dentist(specializationno, specializationName));
		response.sendRedirect("listspecs");
	}
	
	private void createInvoice(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String Appointment_ID = request.getParameter("Appointment_ID");
		//String specializationName = request.getParameter("specializationName");
		userDAO.createInvoice(new Invoice(Appointment_ID));
		//userDAO.insertSpecialization(new Dentist(specializationno, specializationName));
		response.sendRedirect("listspecs");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User book = new User(id, name, email, country);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}
	
	private void updateDentist(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");

		Dentist book = new Dentist(id, firstName,lastName, email, contact);
		userDAO.updateDentist(book);
		response.sendRedirect("list");
	}
	
	private void updateSpecs(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int id = Integer.parseInt(request.getParameter("specializationno"));
		String specializationName = request.getParameter("specializationName");

		Dentist book = new Dentist(id, specializationName);
		userDAO.updateSpecs(book);
		response.sendRedirect("listspecs");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void deleteDentist(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteDentist(id);
		response.sendRedirect("list");
	}
	
	private void deleteSpecs(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		int id = Integer.parseInt(request.getParameter("specializationno"));
		userDAO.deleteSpecs(id);
		response.sendRedirect("listspecs");
	}
    
	
}

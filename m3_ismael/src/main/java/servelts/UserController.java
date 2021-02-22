package servelts;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.UserDAOImpl;
import entities.User;
import interfaces.UserDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDAOImpl UserDAO = new UserDAOImpl();
       
   EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("practica_ismael");
   	EntityManager manager = managerFactory.createEntityManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String idString =request.getParameter("id");
		if(idString !=null) {
			Long id =Long.valueOf(idString);
		
			User user1 = manager.find(User.class, id);
			
			if (user1 !=null) {
				response.getWriter().append(user1.toString());
				return;
			}else {
				response.getWriter().append("no existe usuario" +idString +"en base de datos");
			}
		}
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
		
		case "LIST":
			listUser(request, response);
			break;
		case "VIEW":
			getSingleUserView(request, response);
			break;
		case "EDIT":
			getSingleUser(request, response);
			break;
			
		case "DELETE":
			deleteUser(request, response);
			break;
			
		default:
			listUser(request, response);
			break;
			
	}
		//extraer el valor del parametro id
		   //buscar el usuario con el id en base de datos
		  //cargar el usuario en la request
		//pasar el request
		private void getSingleUserView(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
				// 1 extraer el valor del parametro id
				String idString = request.getParameter("id");
				//comprobar que el id no sea null
				if (idString ==null || idString.isEmpty()) {
				request.setAttribute("NOTIFICATION", "Please introduce a valid id");
				
				listUser(request,response);
				return;
			}
				//2. buscar el usuario con el id en base de datos
				Long idUser = Long.valueOf(idString); //convertir de string a long
				 User user1 =UserDAO.get(idUser);
				 if (user1 ==null) {

	 request.setAttribute("NOTIFICATION", "El empleado solicitado no es el correcto");
					 listUser(request,response);
					 return;
				 }
				 //3.Cargar el usuario en la request
				 request.setAttribute("user", user1);
				 //4.Pasar la request a JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user-view.jsp");
				dispatcher.forward(request, response);
		}
	
		//response.getWriter().append("Served at").append(request.getContextPath());
			//userCRUD.findOne(1l);
			//userCRUD.findAll();
			
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("id");
		
			if(UserDAO.delete(Long.parseLong(id))) {
				request.setAttribute("NOTIFICATION", "User Deleted Successfully!");
			}
			
			listUser(request, response);
	}

	private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		User theUser = UserDAO.get(Long.parseLong(id));
		
		request.setAttribute("User", theUser);
		
		dispatcher = request.getRequestDispatcher("/views/user-form.jsp");
		
		dispatcher.forward(request, response);
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> theList = UserDAO.get();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/list-list.jsp");
		
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user1 =new User();
		user1.setFirstName(request.getParameter("FirstName"));
		user1.setLastName(request.getParameter("LastName"));
		user1.setAge(Integer.valueOf(request.getParameter("Age")));
		user1.setNif(request.getParameter("nif"));
	

user1.setEmail(request.getParameter("Email"));
		user1.setPassword(request.getParameter("Password"));
		user1.setMarried(Boolean.valueOf(request.getParameter("Married")));
}
	if(id.isEmpty() || id == null) {
		//save o create
		if(UserDAO.create(user1)) {
			request.setAttribute("NOTIFICATION", "User Saved Successfully!");
		}
	
	}else {
		
		User.setId(Long.parseLong(id));
		if(UserDAO.update(user1)) {
			request.setAttribute("NOTIFICATION", "User Updated Successfully!");
		}
	}

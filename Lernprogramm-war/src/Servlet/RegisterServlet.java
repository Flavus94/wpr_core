package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

import Model.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String vorname = request.getParameter("vorname");
		System.out.println("Parameter :" + name + vorname);
		String geschlecht = request.getParameter("geschlecht");
		String email = request.getParameter("email");
		String passwort = request.getParameter("passwort");
		User newUser;
		String baseFilePath = new JFileChooser().getFileSystemView().getDefaultDirectory().getPath();
		
		if(name != null && !name.equals("") && vorname != null && !vorname.equals("") && geschlecht != null && !geschlecht.equals("") 
				&& email != null && passwort != null && !passwort.equals("")) {
			newUser = new User(name, vorname, geschlecht, email, passwort);
			String fileName = Paths.get(baseFilePath, "Git_E-Learning/user/", email + ".txt").toString();
			File f = new File(fileName);
			if (!f.exists()) {
				f.createNewFile();
				ObjectOutputStream oStream =  new ObjectOutputStream(new FileOutputStream(fileName));
				oStream.writeObject(newUser);
				oStream.close();
				response.sendRedirect("registriert.html");
			} else {
				response.sendRedirect("registrieren.html?exists=true");
			}	
		} else {
			response.sendRedirect("registrieren.html?incomplete=true");
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

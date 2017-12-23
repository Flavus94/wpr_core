package Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFileChooser;

import Model.User;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String passwort = request.getParameter("passwort");
		User user;
		HttpSession session = request.getSession(true);
		if (email != null && !email.equals("") && passwort != null && !passwort.equals("")) {

			String baseFilePath = new JFileChooser().getFileSystemView().getDefaultDirectory().getPath();
			String fileName = Paths.get(baseFilePath, "Git_E-Learning/user/", email + ".txt").toString();
			File f = new File(fileName);
			try {
				if (f.exists()) {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
					user = (User) input.readObject();
					if(user.getPasswort().equals(passwort)) {
						session.setAttribute("login", true);
						session.setAttribute("user", user);
						response.sendRedirect("userProfile.html");
					} else {
						response.sendRedirect("login.html?login=false");
					}
				} else {
					response.sendRedirect("login.html?login=false");
				}
			} catch (ClassNotFoundException e) {
			}
		} else {
			response.sendRedirect("login.html?login=incomplete");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package webapp.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import first.webapp.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/mavendb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String LOGIN_USER_SQL = "select * from User where user_name =?";
	private static final String RESET_PASSWORD_SQL = "update User set password = ? where user_name =?";
	private static final String HOME_PAGE = "http://localhost:8088//agile/LoginServlet/home";
	private static final String SECRET_PAGE = "http://localhost:8088//agile/LoginServlet/forgot";
	private static final String RESET_PAGE = "http://localhost:8088//agile/LoginServlet/reset";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

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
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" - ");

		String action = request.getServletPath();
		System.out.println("Accessing: " + action);

		switch (action) {
		case "/LoginServlet/home":
			showLoginForm(request, response);
			break;
		case "/LoginServlet/forgot":
			showSecretForm(request, response);
			break;
		case "/LoginServlet/reset":
			showResetForm(request, response);
			break;
		case "/LoginServlet/login":
			verifyLoginUser(request, response);
			break;
		case "/LoginServlet/secret":
			verifyUserSecret(request, response);
			break;
		case "/LoginServlet/password":
			resetUserPassword(request, response);
			break;
		default:
			showLoginForm(request, response);
			break;
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

	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("comes to loginForm");
		RequestDispatcher dispatcher = request.getRequestDispatcher("../login.jsp");
		dispatcher.forward(request, response);
	}

	private void showSecretForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("comes to secretForm");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("forgotName");
		User forgotUser = getUser(username);

		if (forgotUser == null) {
			out.print(String.format("Hello [%s], please provide a valid user to reset password", username));
			return;
		}

		request.setAttribute("user", forgotUser);
//		response.sendRedirect(SECRET_PAGE);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../secretQuestion.jsp");
		dispatcher.forward(request, response);
	}

	private void showResetForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("comes to resetForm");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("forgotName");
		User forgotUser = getUser(username);

		if (forgotUser == null) {
			out.print(String.format("Hello [%s], please provide a valid user to reset password", username));
			return;
		}

		request.setAttribute("user", forgotUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../resetPassword.jsp");
		dispatcher.forward(request, response);
	}

	private void verifyLoginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("comes to verifyUser");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User loginUser = getUser(username);

		if (loginUser == null || loginUser.getPassword().length() == 0
				|| !password.equalsIgnoreCase(loginUser.getPassword()))
			out.print(String.format("Oh No [%s], your login information is incorrect", username));
		else
			out.print(String.format("Hello [%s], you are successfully login", username));
	}

	private void verifyUserSecret(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("comes to verifySecret");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("forgotName");
		System.out.println("Username: " + username);

		User forgotUser = getUser(username);
		String actualAnswer = request.getParameter("secretAnswer");
		System.out.println("Secret: " + username + " - " + actualAnswer);

		if (forgotUser == null || actualAnswer.length() == 0
				|| !forgotUser.getSecretAnswer().equalsIgnoreCase(actualAnswer))
			out.print(String.format("Oh No [%s], your secret answer is incorrect", username));
		else {
			request.setAttribute("user", forgotUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../resetPassword.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void resetUserPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("comes to resetPassword");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get values from the request
		String username = request.getParameter("forgotName");
		System.out.println("Username: " + username);

		User forgotUser = getUser(username);
		if (forgotUser == null) {
			out.print(String.format("Oh No [%s], your account is not found", username));
			return;
		}

		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		System.out.println("Pass: " + username + " - " + password);

		if (!password.equals(repassword)) {
			out.print(String.format("Hello [%s], your passwords are not the same", username));
			return;
		}

		int updated = updatePassword(username, password);
		if (updated > 0) {
			out.print(String.format("Hello [%s], your password have been updated successfully", username));
		} else {
			out.print(String.format("Hello [%s], your password is NOT updated successfully", username));
		}
		// redirect us back to UserServlet !note: do change the url to your project name
//		response.sendRedirect(HOME_PAGE);
	}

	private User getUser(String username) {
		User loginUser = null;
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(LOGIN_USER_SQL);) {

			ps.setString(1, username);
			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String secretQuestion = rs.getString("secret_question");
				String secretAnswer = rs.getString("secret_answer");
				loginUser = new User(id, fullName, userName, password, secretQuestion, secretAnswer, "");
			}

		} catch (SQLException e2) {
			printSQLException(e2);
		}
		return loginUser;
	}

	private int updatePassword(String username, String password) {
		// database operation
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(RESET_PASSWORD_SQL);) {
			statement.setString(1, password);
			statement.setString(2, username);

			return statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return 0;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}

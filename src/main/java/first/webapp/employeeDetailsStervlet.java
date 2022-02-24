package first.webapp;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class employeeDetailsStervlet
 */
@WebServlet("/employeeDetailsStervlet")
public class employeeDetailsStervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public void employeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  String action = request.getServletPath(); 
		   try {  
		switch (action) {
		case "/insert":
		break;
		case "/delete":
		break;
		case "/edit":
		break;
		case "/update":
		break;
		default:
		listemployeeDetails (request, response);
		break;
		}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//}


//Step 1: Prepare list of variables used for database connections

private String jdbcURL = "jdbc:mysql://localhost:3306/employeedetails";
private String jdbcUsername = "root";
private String jdbcPassword = "password";
//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
private static final String INSERT_USERS_SQL = "INSERT INTO employeeDetails" + " (employee_name, employee_phone, employee_pay, salary_status) VALUES " +
" (?, ?, ?);";
private static final String SELECT_USER_BY_ID = "employee_name,\r\n"
		+ "employee_phone, employee_pay, salary_status from UserDetails where name =?";
private static final String SELECT_ALL_employeeDetails = "select * from employeeDetails ";
private static final String DELETE_employeeDetails_SQL = "delete from employeeDetails where name = ?;";
private static final String UPDATE_employeeDetails_SQL = "update employeeDetails set employee_name = ?,employee_phone= ?, employee_pay =?,salary_status =? where employee_name = ?;";
//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC 

protected Connection getConnection() {
Connection connection = null;
try {
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
return connection;
}

//Step 3.3. Add the following route controller codes in the doGet method of UserServlet:

//Step 4: Depending on the request servlet path, determine the function to invoke using the
//follow switch statement.

	   


//Step 5: listUsers function to connect to the database and retrieve all users records
private void listemployeeDetails(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException
{
	List <employeeDetailsStervlet> employeedetails = new ArrayList <>();
try (Connection connection = getConnection();
// Step 5.1: Create a statement using connection object
PreparedStatement preparedStatement =
connection.prepareStatement(SELECT_ALL_employeeDetails);) {
// Step 5.2: Execute the query or update query
ResultSet rs = preparedStatement.executeQuery();
// Step 5.3: Process the ResultSet object.
while (rs.next()) {
String employee_name = rs.getString("employee_name");
String employee_phone = rs.getString("employee_phone");
String employee_pay = rs.getString("employee_pay");
String salary_status = rs.getString("salary_status");

employeedetails.add(new employeeDetails (employee_name, employee_phone, employee_pay, salary_status));
}
} catch (SQLException e) {
System.out.println(e.getMessage());
}
//Step 5.4: Set the users list into the listUsers attribute to be pass to the
//employeeDetailsManagement.jsp
request.setAttribute("listemployeedetails", employeedetails);
request.getRequestDispatcher("/employeeDetailsManagement.jsp").forward(request, response);
}
}


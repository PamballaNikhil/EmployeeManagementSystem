import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String hireDate = request.getParameter("hire_date");

        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO employees (first_name, last_name, email, phone, department, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, email);
                stmt.setString(4, phone);
                stmt.setString(5, department);
                stmt.setString(6, hireDate);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewEmployees.html");
    }
}











@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String hireDate = request.getParameter("hire_date");

        Employee employee = new Employee(0, firstName, lastName, email, phone, department, Date.valueOf(hireDate));

        boolean result = EmployeeDAO.addEmployee(employee);
        response.setContentType("application/json");
        response.getWriter().write("{\"status\": " + (result ? "\"success\"" : "\"failure\"") + "}");
    }
}

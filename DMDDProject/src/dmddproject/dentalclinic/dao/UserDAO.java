package dmddproject.dentalclinic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dmddproject.dentalclinic.utils.JDBCUtils;
import dmddproject.detalclinic.model.*;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class UserDAO {
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";
	private static final String INSERT_DENTISTS_SQL = "INSERT INTO dentist" + "  (dentist_FirstName, dentist_LastName, dentist_email, dentist_contact) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SPEC_PROC = "{call AddSpecialization(?,?)}";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_DENTIST_BY_ID = "select dentist_id,dentist_FirstName,dentist_LastName,dentist_email,dentist_contact from dentist where dentist_id =?";
	private static final String SELECT_SPEC_BY_NO = "select specialization_id, specialization_name from specialization where specialization_id = ?";
	private static final String SELECT_ALL_DENTISTS = "select * from dentist ";
	private static final String SELECT_ALL_SPECS = "select * from specialization";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String DELETE_DENTISTS_SQL = "delete from dentist where dentist_id = ?;";
	private static final String DELETE_SPECS_SQL = "delete from specialization where specialization_id = ?";
	private static final String UPDATE_DENTISTS_SQL = "update dentist set dentist_FirstName = ?,dentist_LastName = ?,dentist_email= ?, dentist_contact =? where dentist_id = ?;";
	private static final String UPDATE_SPECS_SQL = "update specialization set specialization_id = ?, specialization_name = ? where specialization_id = ?;";
	private static final String LOGIN_USER = "select * from login where username = ? and password = ?";
	private static final String CREATE_INVOICE = "call `invoice generation`(?);";
	private static final String SHOW_INVOICE = "select * from invoice;";
	
	

	
	public UserDAO() {
	}

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        try (Connection connection = JDBCUtils.getConnection();
        		

            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER)) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }
    
    public void createInvoice(Invoice invoice) {
		System.out.println(CREATE_INVOICE);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE_INVOICE)) {
			preparedStatement.setString(1, invoice.getAppointment_ID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public void insertUser(User user) {
		System.out.println(INSERT_DENTISTS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void insertDentist (Dentist dentist) {
		System.out.println(INSERT_DENTISTS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DENTISTS_SQL)) {
			preparedStatement.setString(1, dentist.getFirstName());
			preparedStatement.setString(2, dentist.getLastName());
			preparedStatement.setString(3, dentist.getEmail());
			preparedStatement.setString(4, dentist.getContact());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public void insertSpecialization (Dentist dentist) {
		System.out.println(SPEC_PROC);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SPEC_PROC)) {
			preparedStatement.setInt(1, dentist.getSpecializationno());
			preparedStatement.setString(2, dentist.getSpecializationName());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	
	
	public Dentist selectDentist(int id) {
		Dentist dentist = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DENTIST_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstName = rs.getString("dentist_FirstName");
				String lastName = rs.getString("dentist_LastName");
				String email = rs.getString("dentist_email");
				String contact = rs.getString("dentist_contact");
				dentist = new Dentist(id, firstName, lastName, email, contact);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return dentist;
	}
	
	public Dentist selectSpecs(int specializationno) {
		Dentist dentist = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPEC_BY_NO);) {
			preparedStatement.setInt(1, specializationno);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				//String firstName = rs.getString("specialization_id");
				String specializationName = rs.getString("specialization_name");
				dentist = new Dentist(specializationno, specializationName);
				//dentist = new Dentist(specializationno, specializationName);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return dentist;
	}
	

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DENTISTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public List<Dentist> selectAllDentists() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Dentist> dentist = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DENTISTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("dentist_id");
				String firstName = rs.getString("dentist_FirstName");
				String lastName = rs.getString("dentist_LastName");
				String email = rs.getString("dentist_email");
				String contact = rs.getString("dentist_contact");
				dentist.add(new Dentist(id, firstName, lastName, email, contact));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return dentist;
	}
	
	public List<Dentist> selectAllSpecs() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Dentist> dentist = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SPECS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				int specializationno = rs.getInt("specialization_id");
				String specializationName = rs.getString("specialization_name");
				dentist.add(new Dentist(specializationno, specializationName));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return dentist;
	}
	
	public List<Invoice> selectInvoice() {
		List<Invoice> invoice = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_INVOICE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("Invoice_ID");
				int name = rs.getInt("Amount");
				String email = rs.getString("Date");
				String country = rs.getString("Appointment_ID");
				invoice.add(new Invoice(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return invoice;
	}
		

	public boolean deleteUser(int id) {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowDeleted;
	}
	
	public boolean deleteDentist(int id) {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DENTISTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowDeleted;
	}
	
	public boolean deleteSpecs(int specializationno) {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SPECS_SQL);) {
			statement.setInt(1, specializationno);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) {
		boolean rowUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DENTISTS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

	public boolean updateDentist(Dentist dentist) {
		boolean rowUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DENTISTS_SQL);) {
			statement.setString(1, dentist.getFirstName());
			statement.setString(2, dentist.getLastName());
			statement.setString(3, dentist.getEmail());
			statement.setString(4, dentist.getContact());
			statement.setInt(5, dentist.getId());
			

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}
	
	public boolean updateSpecs(Dentist dentist) {
		boolean rowUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SPECS_SQL);) {
			statement.setInt(1, dentist.getSpecializationno());
			statement.setString(2, dentist.getSpecializationName());	
			statement.setInt(3, dentist.getSpecializationno());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
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

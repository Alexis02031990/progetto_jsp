package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Staff;
import it.contrader.model.User;
/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class StaffDAO implements DAO<Staff> {
	
	private final String QUERY_ALL = "SELECT * FROM staff";
	private final String QUERY_CREATE = "INSERT INTO staff (idStaff, nome,cognome,email,posizione,numeroTelefono,dataAssunzione,sede,oreSettimanali, codiceFiscale) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM staff WHERE idStaff=?";
	private final String QUERY_UPDATE = "UPDATE staff SET idStaff=?,nome=?,cognome=?, email=?, posizione=?,numeroTelefono=?,dataAssunzione=?,sede=?,oreSettimanali=?,codiceFiscale=? WHERE idStaff=?";
	private final String QUERY_DELETE = "DELETE FROM staff WHERE idStaff=?";

	public StaffDAO() {

	}

	public List<Staff> getAll() {
		List<Staff> staffList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Staff staff;
			while (resultSet.next()) {
				
				int idStaff= resultSet.getInt("idStaff");
				String  nome= resultSet.getString("nome");
				String  cognome= resultSet.getString("cognome");
				String  email = resultSet.getString("email");
				String posizione = resultSet.getString("posizione");
				int numeroTelefono= resultSet.getInt("numeroTelefono");
				String dataAssunzione= resultSet.getString("dataAssunzione");
				String sede= resultSet.getString("sede");
				int oreSettimanali= resultSet.getInt("oreSettimanali");
				String codiceFiscale = resultSet.getString("codiceFiscale");

				
				staff = new Staff(idStaff, nome,cognome,email,posizione,numeroTelefono,dataAssunzione,sede,oreSettimanali,codiceFiscale);
				staff.setIdStaff(idStaff);
				staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}

	public boolean insert(Staff staffToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, staffToInsert.getIdStaff());
			preparedStatement.setString(2, staffToInsert.getNome());
			preparedStatement.setString(3, staffToInsert.getCognome());
			preparedStatement.setString(4, staffToInsert.getEmail());
			preparedStatement.setString(5, staffToInsert.getPosizione());
			preparedStatement.setInt(6, staffToInsert.getNumeroTelefono());
			preparedStatement.setString(7, staffToInsert.getDataAssunzione());
			preparedStatement.setString(8, staffToInsert.getSede());
			preparedStatement.setInt(9,staffToInsert.getOreSettimanali());
			preparedStatement.setString(10,staffToInsert.getCodiceFiscale());

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Staff read(int idstaff) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idstaff);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			/*int idStaff, idIterSelettivo,numeroTelefono,oreSettimanali;
			String nome,cognome,email,posizione,sede;
			Date dataAssunzione;*/

			int idStaff= resultSet.getInt("idStaff");
			String  nome= resultSet.getString("nome");
			String  cognome= resultSet.getString("cognome");
			String  email = resultSet.getString("email");
			String posizione = resultSet.getString("posizione");
			int numeroTelefono= resultSet.getInt("numeroTelefono");
			String dataAssunzione= resultSet.getString("dataAssunzione");
			String sede= resultSet.getString("sede");
			int oreSettimanali= resultSet.getInt("oreSettimanali");
			String codiceFiscale = resultSet.getString("codiceFiscale");
			
			Staff staff= new Staff(idStaff, nome,cognome,email,posizione,numeroTelefono,dataAssunzione,sede,oreSettimanali, codiceFiscale);
			staff.setIdStaff(idStaff);

			return staff;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean update(Staff staffToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (staffToUpdate.getIdStaff() == 0)
			return false;

		Staff staffRead = read(staffToUpdate.getIdStaff());
		if (!staffRead.equals(staffToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (staffToUpdate.getIdStaff()== 0) {
					staffToUpdate.setIdStaff(staffRead.getIdStaff());
				}

				if (staffToUpdate.getCognome() == null || staffToUpdate.getCognome().equals("")) {
					staffToUpdate.setCognome(staffRead.getCognome());
				}
				
				if (staffToUpdate.getEmail() == null || staffToUpdate.getEmail().equals("")) {
					staffToUpdate.setEmail(staffRead.getEmail());
				}

				
				if (staffToUpdate.getPosizione() == null || staffToUpdate.getPosizione().equals("")) {
					 staffToUpdate.setPosizione(staffRead.getPosizione());
				}

				if (staffToUpdate.getNumeroTelefono() == 0) {
					staffToUpdate.setNumeroTelefono(staffRead.getNumeroTelefono());
				}

				if (staffToUpdate.getDataAssunzione() == null || staffToUpdate.getDataAssunzione().equals("")) {
					staffToUpdate.setDataAssunzione(staffRead.getDataAssunzione());
				}

				if (staffToUpdate.getSede() == null ||staffToUpdate.getSede().equals("")) {
					staffToUpdate.setSede(staffRead.getSede());
				}

				if (staffToUpdate.getOreSettimanali() == 0) {
					staffToUpdate.setOreSettimanali(staffRead.getOreSettimanali());
				}


				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, staffToUpdate.getIdStaff());
				preparedStatement.setString(2, staffToUpdate.getNome());
				preparedStatement.setString(3, staffToUpdate.getCognome());
				preparedStatement.setString(4, staffToUpdate.getEmail());
				preparedStatement.setString(5, staffToUpdate.getPosizione());
				preparedStatement.setInt(6, staffToUpdate.getNumeroTelefono());
				preparedStatement.setString(7, staffToUpdate.getDataAssunzione());
				preparedStatement.setString(8, staffToUpdate.getSede());
				preparedStatement.setInt(9,staffToUpdate.getOreSettimanali());
				preparedStatement.setString(10,staffToUpdate.getCodiceFiscale());
				preparedStatement.setInt(11,staffToUpdate.getIdStaff());

				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		return false;

	}

	public boolean delete(int idstaff) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idstaff);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}

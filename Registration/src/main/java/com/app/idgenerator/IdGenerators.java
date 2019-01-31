package com.app.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class IdGenerators implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// UserRegistration userRegistration = new UserRegistration();
		Connection connection = session.connection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(userid) from user_details");
			if(rs.next()) {
				
				return /*userRegistration.getName()*/"user"+rs.getInt(1);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

public class NetworkRowMapper implements RowMapper<NetworkSystem> {

	@Override
	public NetworkSystem mapRow(ResultSet arg0, int rowNum) throws SQLException {
		
		NetworkSystem network = new NetworkSystem();
		network.setSystemId(arg0.getString(1));
		network.setSystemName(arg0.getString(2));
		return network;
	}

	
}

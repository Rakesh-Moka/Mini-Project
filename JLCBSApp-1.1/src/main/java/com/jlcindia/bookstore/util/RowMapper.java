package com.jlcindia.bookstore.util;

import java.sql.SQLException;

import java.sql.ResultSet;

public interface RowMapper {
	public Object mapRow(ResultSet rs) throws SQLException;
}

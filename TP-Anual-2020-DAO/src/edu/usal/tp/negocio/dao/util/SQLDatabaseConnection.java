package edu.usal.tp.negocio.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {

	private static Connection con = null;

	public static Connection conectar() {

		try {
			Class.forName(PropertiesUtil.obtenerSqlDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(PropertiesUtil.obtenerSqlUrl());

			con = DriverManager.getConnection(PropertiesUtil.obtenerSqlUrl(), PropertiesUtil.obtenerSqlUser(),
					PropertiesUtil.obtenerSqlPassword());

			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (con != null) {
				System.out.println("----- Conexion establecida -----");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la DB");
			e.printStackTrace();
		}
		return con;
	}

	public static void cerrar() throws SQLException {
		if (con != null) {
			con.close();
			System.out.println("----- Conexion cerrada -----");
		}
	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
		}
	}

}

package edu.usal.tp.negocio.dao.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties properties;

	static {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream("co.properties");
			properties.load(fis);
			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String obtenerPathVentasStream() {
		return properties.getProperty("pathVentasStream");

	}

	public static String obtenerSqlUrl() {
		return properties.getProperty("sqlUrl");
	}

	public static String obtenerSqlUser() {
		return properties.getProperty("sqlUser");
	}

	public static String obtenerSqlPassword() {
		return properties.getProperty("sqlPassword");
	}

	public static String obtenerSqlDriver() {
		return properties.getProperty("sqlDriver");
	}

}

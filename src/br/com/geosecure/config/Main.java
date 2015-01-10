package br.com.geosecure.config;


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Main {
	public static void main(String[] args) {
		
		Configuration cfg = new AnnotationConfiguration().configure("mysql_hibernate.cfg.xml");
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true); 

	}
	
}

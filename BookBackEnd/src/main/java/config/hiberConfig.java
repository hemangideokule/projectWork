package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import model.User;

public class hiberConfig {
	@Autowired
	@Bean(name="datasource")
		public DataSource getH2Data()
		{
		DriverManagerDataSource dsource= new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/Book");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 connected");
		return dsource;
		}
		private Properties getHiber()
		{
			Properties p= new Properties();
			p.put("hibernate.dialect","org.hibernate.dialect.H2dialect");
			p.put("hibernate.hbm2ddl.auto","update");
			p.put("hibernate.show_sql","true");
			System.out.println("Tables craeted");
			return p;
		}
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getHiberSession(DataSource datasource)
		{
			LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(datasource);
			lsfb.addProperties(getHiber());
			lsfb.addAnnotatedClass(User.class);
			return lsfb.buildSessionFactory();
		}
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTrans(SessionFactory sf)
		{
			HibernateTransactionManager tm= new HibernateTransactionManager();
			return tm;
			}
}

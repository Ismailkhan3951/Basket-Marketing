package com.niit.config;

import java.util.Properties;

	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
	import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.AuthenticationDao;
import com.niit.dao.BillingAddressDao;
import com.niit.dao.CardDao;
import com.niit.dao.CartDao;
import com.niit.dao.CartItemsDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.OrderDao;
import com.niit.dao.OrderItemsDao;
import com.niit.dao.PaymentDao;
import com.niit.dao.ProductDao;
import com.niit.dao.ShipingAddressDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.daoimpl.AuthenticationDaoImpl;
import com.niit.daoimpl.BillingAddressDaoImpl;
import com.niit.daoimpl.CardDaoImpl;
import com.niit.daoimpl.CartDaoImpl;
import com.niit.daoimpl.CartItemsDaoImpl;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.daoimpl.OrderDaoImpl;
import com.niit.daoimpl.OrderItemsDaoImpl;
import com.niit.daoimpl.PaymentDaoImpl;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.daoimpl.ShipingAddressDaoImpl;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.model.Authentication;
import com.niit.model.BillingAddress;
import com.niit.model.Card;
import com.niit.model.Cart;
import com.niit.model.CartItems;
import com.niit.model.Category;
import com.niit.model.Order;
import com.niit.model.OrderItems;
import com.niit.model.Payment;
import com.niit.model.Product;
import com.niit.model.ShipingAddress;
import com.niit.model.Supplier;
import com.niit.model.User;



	@Configuration
	@ComponentScan("com.niit.*")
	@EnableTransactionManagement
	public class ApplicationContext {

		@Bean("dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/project");
			dataSource.setUsername("sa");
			dataSource.setPassword("sa");

			// Properties connectionProperties=new Properties();
			// connectionProperties.setProperty("hibernate.show_sql", "true");
			// connectionProperties.setProperty("hibernate.dialect",
			// "org.hibernate.dialect");
			return dataSource;
		}

		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.connection.pool_size", "10");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			return properties;
		}

		@Autowired
		@Bean("sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.addAnnotatedClass(Product.class);
			sessionBuilder.addAnnotatedClass(User.class);
			
			
			sessionBuilder.addAnnotatedClass(Cart.class);
			sessionBuilder.addAnnotatedClass(CartItems.class);
			sessionBuilder.addAnnotatedClass(Authentication.class);
			sessionBuilder.addAnnotatedClass(BillingAddress.class);
			sessionBuilder.addAnnotatedClass(ShipingAddress.class);
			sessionBuilder.addAnnotatedClass(Payment.class);
			sessionBuilder.addAnnotatedClass(Card.class);
			sessionBuilder.addAnnotatedClass(Order.class);
	        sessionBuilder.addAnnotatedClass(OrderItems.class);
			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean("transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

		@Autowired
		@Bean("billingAddressDao")
		public BillingAddressDao getBillingAddressDao(SessionFactory sessionFactory) {
			return new BillingAddressDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("orderItemsDao")
		public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
			return new OrderItemsDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("orderDao")
		public OrderDao getOrderDao(SessionFactory sessionFactory) {
			return new OrderDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("cardDao")
		public CardDao getCardDao(SessionFactory sessionFactory) {
			return new CardDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("paymentDao")
		public PaymentDao getPaymentDao(SessionFactory sessionFactory) {
			return new PaymentDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("shipingAddressDao")
		public ShipingAddressDao getShipingAddressDao(SessionFactory sessionFactory) {
			return new ShipingAddressDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("categoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
			return new CategoryDaoImpl(sessionFactory);
		}
	
		@Autowired
		@Bean("supplierDao")
		public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDaoImpl(sessionFactory);
		}
	
		@Autowired
		@Bean("productDao")
		public ProductDao getProductDao(SessionFactory sessionFactory) {
			return new ProductDaoImpl(sessionFactory);
	
		}
	
		@Autowired
		@Bean("userDao")
		public UserDao getUserDao(SessionFactory sessionFactory) {
			return new UserDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean("cartDao")
		public CartDao getcartDao(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("cartItemDao")
		public CartItemsDao getCartItemDao(SessionFactory sessionFactory) {
			return new CartItemsDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name="authenticationDao")
		public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
			return new AuthenticationDaoImpl(sessionFactory);
		}

	}

	




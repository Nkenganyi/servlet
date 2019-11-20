package za.co.bankingSystem.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
	
		private final static String jpaPersistenceName = "jpaPersistenceUnit";
		private final static EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(jpaPersistenceName);
		private final static EntityManager entityManager = entityManagerFactory.createEntityManager();

		private DatabaseManager() {

		}

		public static String getJpaPersistencename() {
			return jpaPersistenceName;
		}

		public static EntityManagerFactory getEntitymanagerfactory() {
			return entityManagerFactory;
		}

		public static EntityManager getEntitymanager() {
			return entityManager;
		}

	}



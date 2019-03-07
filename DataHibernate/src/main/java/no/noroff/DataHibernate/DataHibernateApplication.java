package no.noroff.DataHibernate;

import no.noroff.DataHibernate.jpa.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class DataHibernateApplication {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

	public static void main(String[] args) {

		//addUser("DeathBLASTER", "sumsumsumhaha");
		//addCharacter("Barkiller", 98,1);
		//addClass("Kitten");


		//PRINT ALL
		/*for (user p: getUser()) {
			System.out.println(p.toString());
		}

		for (chars p: getCharacter()) {
			System.out.println(p.toString());
		}

		for (classset p: getClasses()) {
			System.out.println(p.toString());
		}

		for (abilities p: getAbilities()) {
			System.out.println(p.toString());
		}*/

		SpringApplication.run(DataHibernateApplication.class, args);
	}

	static List<chars> getCharacter(){
		List<chars> charList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			charList = manager.createQuery("SELECT s FROM chars s", chars.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return charList;
	}

	public static List<user> getUser(){
		List<user> userList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			userList = manager.createQuery("SELECT s FROM user s", user.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return userList;
	}


	public static List<classset> getClasses(){
		List<classset> classesList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			classesList = manager.createQuery("SELECT s FROM classset s", classset.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return classesList;
	}

	public static List<chars> getCharacters(){
		List<chars> charsList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			charsList = manager.createQuery("SELECT s FROM chars s", chars.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return charsList;
	}


	public static List<classabilities> getClassAbilities(){
		List<classabilities> classAbilitiesList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			classAbilitiesList = manager.createQuery("SELECT s FROM classabilities s", classabilities.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return classAbilitiesList;
	}

	public static List<abilities> getAbilities(){
		List<abilities> abilityList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			abilityList = manager.createQuery("SELECT s FROM abilities s", abilities.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}
		return abilityList;
	}

	static void addUser(String username, String password){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			user newUser = new user();

			newUser.setUsername(username);
			newUser.setPassword(password);

			manager.persist(newUser);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}

	static void addCharacter(String name, int level, int userID, String classID){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			chars newChar = new chars();

			newChar.setName(name);
			newChar.setLevel(level);
			newChar.setUserID(userID);
			newChar.setClassID(classID);

			manager.persist(newChar);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}

	private static void addClass(String name){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			classset newClass = new classset();

			newClass.setName(name);
			manager.persist(newClass);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}

}

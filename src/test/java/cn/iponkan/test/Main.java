package cn.iponkan.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cn.ipokan.entity.Customer;

/**
 * @author 作者 :董唐强
 * @version 创建时间：2018年8月25日 下午8:19:26 说明：
 */
public class Main {

	public static void main(String[] args) {
		// 1. 创建 EntitymanagerFactory
		String persistenceUnitName = "jpa-1";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

		// 2. 创建 EntityManager. 类似于 Hibernate 的 SessionFactory
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// 3. 开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 进行持久化操作
		Customer customer = new Customer();
		customer.setAge(23);
		customer.setEmail("clare@iponkan.cn");
		customer.setLastName("Tung");

		entityManager.persist(customer);

		// 5. 提交事务
		transaction.commit();

		// 6. 关闭 EntityManager
		entityManager.close();

		// 7. 关闭 EntityManagerFactory
		entityManagerFactory.close();

	}

}

package com.smq.jpademo3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.smq.jpademo.model3.Department;
import com.smq.jpademo.model3.Manager;

public class JpaTest {
	
	@Test
	public void test() {
		//1.创建EntitymanageFactory
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpademo");
		//2.创建Entitymanage
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction  transaction=entityManager.getTransaction();
		
		transaction.begin();
		//双向一对一，默认的是立即加载策略
		Department department=entityManager.find(Department.class, 1);
		System.out.println(department.getDepartmentName());
		System.out.println(department.getManager().getManagerName());
		
		Manager manager=entityManager.find(Manager.class, 1);
		System.out.println(manager.getManagerName());
		System.out.println(manager.getDepartment().getDepartmentName());
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}

package com.smq.jpademo5;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.smq.jpademo.model5.Stu;
import com.smq.jpademo.model5.StuCour;

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
		Stu stus=entityManager.find(Stu.class, 1);
		System.out.println(stus.getStuName());
		List<StuCour> list=stus.getStucours();
		for(StuCour sc:list)
		{
			System.out.println(sc.getScore()+"******"+sc.getCour().getCourName());
		}
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}

package com.smq.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.smq.jpademo.model.User;

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
		
		//4.执行数据的曾删改查
		//EntityManager操作数据库的方法：主要作用就是操作数据库，执行增删改查，对应的方法persist(增)，
		//find和getReferenc（查一条记录），remove (删)，merge(改)
		
		/*2
		 * find(get) 和 getReference(load) 和 hibernate里面的get 和 load 一样		 
		 */
		
		/*3delete方法，既可以删除游离状态的，也可以删除持久化状态的对象
		 * User user=new User();
		 * user.setId(1);//游离状态
		 * entityManage.delete(user);
		 * 
		 * remove 方法，只能删除持久化状态的对象
		 * User user=entityManage.find(User.class,1);
		 * entity.remove(user);
		 */
		
		/*4
		 * merge 相当于hibernate里的save or update
		 * 1.临时状态变量，也就是说user对象，没有id，当然也就没有数据表中对应的数据，发起insert语句
		 * 2.游离状态变量，也就是说user对象，有id（数据表中有对应的记录，发起update，数据表里没有对应的记录，发起insert，id无效
		 * 3.持久化状态，jpa一级缓存中有这个user对象，有id，id的值有对应数据表的记录，发起update
		 */
		User user=new User();
		user.setUsername("zs");
		user.setPasword("123");
		entityManager.persist(user);
		
		
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}

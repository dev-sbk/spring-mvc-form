package dev.sbk.learn;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.sbk.learn.domain.Produit;
import dev.sbk.learn.service.IGenericService;

public class TestJPA {
	private ClassPathXmlApplicationContext app;

	@Before
	public void setUp() throws Exception {
		app = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
	}

	@Test
	public void test() {
		IGenericService<Produit> service = (IGenericService<Produit>) app.getBean("service");
		System.out.println("************************");
		Produit p = service.findOneById(Produit.class, 1L);
		System.out.println(p.toString());
		System.out.println("************************");
		service.remove(Produit.class, 1L);
		System.out.println("************************");
		List<Produit> data = service.findAll(Produit.class);
		for (Produit produit : data) {
			System.out.println(produit.toString());
		}

	}

}

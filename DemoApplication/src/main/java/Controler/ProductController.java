package Controler;

import java.io.IOException;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Product;

@WebServlet("/AddProduct")
	
public class ProductController extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String pname=req.getParameter("pname");
		    double price=Double.parseDouble(req.getParameter("pprice"));
		    String category=req.getParameter("pcategory");
		    int qty=Integer.parseInt(req.getParameter("pqty"));
		    
		    Product p1=new Product();
		    p1.setProductName(pname);
		    p1.setProductPrice(price);
		    p1.setProductCategory(category);
		    p1.setProductQty(qty);
		    
		   
		    
		 Session session=new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory().openSession();
		 
		   Transaction tx=session.beginTransaction();
		   session.save(p1);
		   tx.commit();
		   session.close();
		   
		  
		 
		 
		}

	}



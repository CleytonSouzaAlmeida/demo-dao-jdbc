
package application;

import java.util.Date;
import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;


public class Program {
    public static void main(String[] args) {
        
        Department novo = new Department(1, "books");
        
        System.out.println("====== Test 1 seller findById =======");
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(2);
                
                
        Seller vendedor = new Seller(21, "Joao", "joao@gmail.com", new Date(), 10000.00, novo);
        System.out.println(vendedor);
    }
}

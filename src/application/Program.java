
package application;

import java.util.Date;
import java.util.List;
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
        System.out.println(seller);
        
        System.out.println("\n====== Test 2 seller findByDepartment =======");
        Department dep = new Department(1, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller e : list){
            System.out.println(e);
        }
        
        System.out.println("\n====== Test 3 seller findAll =======");
        list = sellerDao.findAll();
        for (Seller e : list){
            System.out.println(e);
        }        
        
        System.out.println("\n====== Test 3 seller findAll =======");
        Seller newseller = new Seller(null, "Karl", "karl@springfield.com", new Date(), 20000.00, dep);
        sellerDao.insert(newseller);
        System.out.println("Inserido! novo Id = " + newseller.getId());
        
        System.out.println("\n====== Test 3 seller findAll =======");
        seller = sellerDao.findById(1);
        seller.setName("Bruce Wayne");
        sellerDao.update(seller);
        System.out.println("Update concluido!");
        
        
    }
}

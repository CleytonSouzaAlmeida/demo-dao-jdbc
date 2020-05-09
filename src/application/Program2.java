
package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.DAO.DaoFactory;
import model.DAO.DepartmentDao;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;


public class Program2 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Department novo = new Department(1, "books");
        
        System.out.println("===========================");
        System.out.println("====== Test 1 department insert =======");
        System.out.println();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department novoDep = new Department(null, "Tecnotech");
        departmentDao.insert(novoDep);
        
        System.out.println("\n====== Test 2 department update =======");
        Department dep = new Department(1, "teste");
        departmentDao.update(dep);
        System.out.println("Update concluido!");
        
        
        System.out.println("\n====== Test 3 department delete =======");
        System.out.println("Entre com id para o teste delete:");
        int id = input.nextInt();
        departmentDao.deleteById(id);

        System.out.println("\n====== Test 4 department findByID =======");
        System.out.println("Insira um id para procurar um departamento:");
        int idDep = input.nextInt();
        Department dep2 = departmentDao.findById(idDep);
        System.out.println(dep2);
        
        System.out.println("\n====== Test 5 department findAll =======");
        List<Department> lista = departmentDao.findAll();
        for (Department e : lista){
            System.out.println(e);
        }
    }
}

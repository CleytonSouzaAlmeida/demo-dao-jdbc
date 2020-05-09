
package model.DAO;

import model.DAO.impl.DepartmentDaoJDBC;
import model.DAO.impl.SellerDaoJDBC;


public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(db.DB.getConnection());
    }
    
    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(db.DB.getConnection());
    }
}

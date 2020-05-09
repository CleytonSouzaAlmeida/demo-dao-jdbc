
package model.DAO;

import model.DAO.impl.SellerDaoJDBC;


public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(db.DB.getConnection());
    }
    
}


package model.DAO.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DAO.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn = null;
    
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO department "
                    +"(Name) "
                    +"VALUES "
                    +"(?)");
            
            st.setString(1, obj.getName());
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Inserido com sucesso!");
            } else{
                System.out.println("Linha não inserida!");
            }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            db.DB.closeStatement(st);
        }
    }
    

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                 "UPDATE department "
                +"SET Name = ? "
                +"WHERE Id = ?");
            
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            db.DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer Id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                "DELETE FROM department "
                +"WHERE Id = ?");
            
            st.setInt(1, Id);
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer Id) {
        Department dep = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT department.* "
                    +"FROM department "
                    +"WHERE department.Id = ?");
            
            st.setInt(1, Id);
            rs = st.executeQuery();
            while (rs.next()){
                dep = new Department(rs.getInt(1), rs.getString(2));
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            db.DB.closeStatement(st);
            db.DB.closeResultSet(rs);
        }
        return dep;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT department.* "
                    +"FROM department "
                    +"ORDER BY Name ");
            
            rs = st.executeQuery();
            
            List<Department> list = new ArrayList();
            
            while (rs.next()){
                Department dep = new Department(rs.getInt(1), rs.getString(2));
                list.add(dep);
            } 
            return list;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            db.DB.closeStatement(st);
            db.DB.closeResultSet(rs);
        }
    }
    
}

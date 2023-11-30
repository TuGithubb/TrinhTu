/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;

/**
 *
 * @author Diep.Tran
 */
public class KhachHangService {
    public static List<KhachHang> getCustomerList(String s) {
        List<KhachHang> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DBConnect.getConnection();
            
            String sql = "select * from customer";
            if(s != null && !s.isEmpty()) {
                sql += " where fullname like ?";
            }
            statement = conn.prepareStatement(sql);
            if(s != null && !s.isEmpty()) {
                statement.setString(1, s);
            }
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                KhachHang customer = new KhachHang(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("birthday"),
                        resultSet.getString("address"),
                        resultSet.getString("password")
                );
                dataList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return dataList;
    }
    
    public static void insert(KhachHang customer) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DBConnect.getConnection();
            
            String sql = "insert into customer(fullname, email, phone_number, birthday, address, password) "
                    + "values (?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getFullname());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhoneNumber());
            statement.setString(4, customer.getBirthday());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPassword());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(KhachHang customer) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DBConnect.getConnection();
            
            String sql = "update customer set fullname = ?, email = ?, phone_number = ?, birthday = ?, address = ?, password = ? where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getFullname());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhoneNumber());
            statement.setString(4, customer.getBirthday());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPassword());
            statement.setInt(7, customer.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DBConnect.getConnection();
            
            String sql = "delete from customer where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

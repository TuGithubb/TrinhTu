/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DongXe;

/**
 *
 * @author tu204
 */
public class DongXeService {

    public ArrayList<DongXe> getAllDongXe() {
        ArrayList<DongXe> lst = new ArrayList<>();
        String sql = "select * from Dong_Xe";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                DongXe dx = new DongXe();
                dx.setID(rs.getInt("ID"));
                dx.setTen(rs.getString("Ten"));
                dx.setMoTa(rs.getString("Mo_Ta"));
                dx.setTrangThai(rs.getString("Trang_Thai"));
                lst.add(dx);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addDongXe(DongXe dx) {
        Integer row = null;
        String sql = "INSERT INTO Dong_Xe (ID, Ten, Mo_Ta, Trang_Thai)\n"
                + "VALUES (?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, dx.getID());
            pstm.setString(2, dx.getTen());
            pstm.setString(4, dx.getMoTa());
            pstm.setString(3, dx.getTrangThai());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateDongXe(DongXe dx) {
        Integer row = null;
        String sql = "update Dong_Xe\n"
                + "set Ten=?, Mo_Ta =?, Trang_Thai=? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, dx.getTen());
            pstm.setString(4, dx.getMoTa());
            pstm.setString(3, dx.getTrangThai());
            pstm.setInt(1, dx.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deleteDongXe(String dx) {
        Integer row = null;
        String sql = "delete from Dong_Xe\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, dx);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}

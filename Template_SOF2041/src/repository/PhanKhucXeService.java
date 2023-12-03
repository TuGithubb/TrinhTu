/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.PhanKhucXe;

/**
 *
 * @author tu204
 */
public class PhanKhucXeService {

    public ArrayList<PhanKhucXe> getAllPhanKhucXe() {
        ArrayList<PhanKhucXe> lst = new ArrayList<>();
        String sql = "select * from Phan_Khuc_Xe";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                PhanKhucXe phx = new PhanKhucXe();
                phx.setID(rs.getInt("ID"));
                phx.setTen(rs.getString("Ten"));
                phx.setMoTa(rs.getString("Mo_Ta"));
                phx.setTrangThai(rs.getString("Trang_Thai"));
                lst.add(phx);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addPhanKhucXe(PhanKhucXe phx) {
        Integer row = null;
        String sql = "INSERT INTO Phan_Khuc_Xe (ID, Ten, Mo_Ta, Trang_Thai)\n"
                + "VALUES (?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, phx.getID());
            pstm.setString(2, phx.getTen());
            pstm.setString(4, phx.getMoTa());
            pstm.setString(3, phx.getTrangThai());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updatePhanKhucXe(PhanKhucXe phx) {
        Integer row = null;
        String sql = "update Phan_Khuc_Xe\n"
                + "set Ten=?, Mo_Ta =?, Trang_Thai=? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, phx.getTen());
            pstm.setString(4, phx.getMoTa());
            pstm.setString(3, phx.getTrangThai());
            pstm.setInt(1, phx.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deletePhanKhucXe(String phx) {
        Integer row = null;
        String sql = "delete from Phan_Khuc_Xe\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, phx);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}

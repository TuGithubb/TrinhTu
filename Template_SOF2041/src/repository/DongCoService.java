/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DongCo;

/**
 *
 * @author tu204
 */
public class DongCoService {

    public ArrayList<DongCo> getAllDongCo() {
        ArrayList<DongCo> lst = new ArrayList<>();
        String sql = "select * from Dong_Co";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                DongCo dc = new DongCo();
                dc.setID(rs.getInt("ID"));
                dc.setTen(rs.getString("Ten"));
                dc.setMoTa(rs.getString("Mo_Ta"));
                dc.setTrangThai(rs.getString("Trang_Thai"));
                lst.add(dc);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addDongCo(DongCo dc) {
        Integer row = null;
        String sql = "INSERT INTO Dong_Co (ID, Ten, Mo_Ta, Trang_Thai)\n"
                + "VALUES (?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, dc.getID());
            pstm.setString(2, dc.getTen());
            pstm.setString(4, dc.getMoTa());
            pstm.setString(3, dc.getTrangThai());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateDongCo(DongCo dc) {
        Integer row = null;
        String sql = "update Dong_Co\n"
                + "set Ten=?, Mo_Ta =?, Trang_Thai=? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, dc.getTen());
            pstm.setString(4, dc.getMoTa());
            pstm.setString(3, dc.getTrangThai());
            pstm.setInt(1, dc.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deleteDongCo(String dc) {
        Integer row = null;
        String sql = "delete from Dong_Co\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, dc);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}

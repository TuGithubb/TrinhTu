/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HopSo;

/**
 *
 * @author tu204
 */
public class HopSoService {

    public ArrayList<HopSo> getAllHopSo() {
        ArrayList<HopSo> lst = new ArrayList<>();
        String sql = "select * from Hop_So";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                HopSo hs = new HopSo();
                hs.setID(rs.getInt("ID"));
                hs.setTen(rs.getString("Ten"));
                hs.setMoTa(rs.getString("Mo_Ta"));
                hs.setTrangThai(rs.getString("Trang_Thai"));
                lst.add(hs);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addHopSo(HopSo hs) {
        Integer row = null;
        String sql = "INSERT INTO Hop_So (ID, Ten, Mo_Ta, Trang_Thai)\n"
                + "VALUES (?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, hs.getID());
            pstm.setString(2, hs.getTen());
            pstm.setString(4, hs.getMoTa());
            pstm.setString(3, hs.getTrangThai());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateHopSo(HopSo hs) {
        Integer row = null;
        String sql = "update Hop_So\n"
                + "set Ten=?, Mo_Ta =?, Trang_Thai=? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, hs.getTen());
            pstm.setString(4, hs.getMoTa());
            pstm.setString(3, hs.getTrangThai());
            pstm.setInt(1, hs.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deleteHopSo(String hs) {
        Integer row = null;
        String sql = "delete from Hop_So\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, hs);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}

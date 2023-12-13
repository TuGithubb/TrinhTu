package repository;

import java.util.ArrayList;
import java.sql.*;
import model.DoanhThu;

public class DoanhThuService {

    public DoanhThuResult getAllDoanhThu() {
        ArrayList<DoanhThu> lst = new ArrayList<>();
        String sql = "SELECT cthd.Ma_HD, hd.Ngay_Tao, cthd.Tong_Tien\n"
                + "FROM Chi_Tiet_Hoa_Don cthd\n"
                + "INNER JOIN Hoa_Don hd ON cthd.ID_Hoa_Don = hd.ID";

        // Tạo kết nối
        Connection cn = DBConnect.getConnection();

        int totalRevenue = 0;

        try {
            // Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // Thi hành Statement => dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();

            // Xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                DoanhThu dt = new DoanhThu();
                dt.setMaHD(rs.getString("Ma_HD"));
                dt.setNgayTao(rs.getString("Ngay_Tao"));
                dt.setThanhTien(rs.getInt("Tong_Tien"));

                lst.add(dt);

                // Accumulate total revenue
                totalRevenue += rs.getInt("Tong_Tien");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return new DoanhThuResult(lst, totalRevenue);
    }

    public class DoanhThuResult {
        private ArrayList<DoanhThu> doanhThuList;
        private int totalRevenue;

        public DoanhThuResult(ArrayList<DoanhThu> doanhThuList, int totalRevenue) {
            this.doanhThuList = doanhThuList;
            this.totalRevenue = totalRevenue;
        }

        public ArrayList<DoanhThu> getDoanhThuList() {
            return doanhThuList;
        }

        public int getTotalRevenue() {
            return totalRevenue;
        }
    }
    
    public ArrayList<DoanhThu> searchDoanhThuByDate(String searchDate) {
        ArrayList<DoanhThu> searchResult = new ArrayList<>();
        String sql = "SELECT cthd.Ma_HD, hd.Ngay_Tao, cthd.Tong_Tien\n"
                + "FROM Chi_Tiet_Hoa_Don cthd\n"
                + "INNER JOIN Hoa_Don hd ON cthd.ID_Hoa_Don = hd.ID\n"
                + "WHERE hd.Ngay_Tao = ?";

        Connection cn = DBConnect.getConnection();

        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, searchDate);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                DoanhThu dt = new DoanhThu();
                dt.setMaHD(rs.getString("Ma_HD"));
                dt.setNgayTao(rs.getString("Ngay_Tao"));
                dt.setThanhTien(rs.getInt("Tong_Tien"));

                searchResult.add(dt);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return searchResult;
    }

}

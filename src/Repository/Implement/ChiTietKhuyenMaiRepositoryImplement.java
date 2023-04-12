/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.ChiTietKhuyenMai;
import DomainModel.KhuyenMai;
import DomainModel.SanPham;
import Repository.Interface.ChiTietKhuyenMaiRepositoryInterface;
import Utility.DBContext;
import ViewModel.ChiTietKhuyenMaiViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author mr.quyen
 */
public class ChiTietKhuyenMaiRepositoryImplement implements ChiTietKhuyenMaiRepositoryInterface {

    @Override
    public ArrayList<ChiTietKhuyenMaiViewModel> getAllCTKM() {
        List<ChiTietKhuyenMaiViewModel> listKM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT dbo.KHUYENMAI.MAKHUYENMAI, dbo.KHUYENMAI.TENKHUYENMAI, dbo.SANPHAM.TENSANPHAM, dbo.KHUYENMAI.TIENGIAM, dbo.KHUYENMAI.THOIGIANBATDAU, dbo.KHUYENMAI.THOIGIANKETTHUC, dbo.SANPHAM.GIABAN\n"
                    + "FROM     dbo.CHITIETKHUYENMAI INNER JOIN\n"
                    + "                  dbo.KHUYENMAI ON dbo.CHITIETKHUYENMAI.MAKHUYENMAI = dbo.KHUYENMAI.MAKHUYENMAI INNER JOIN\n"
                    + "                  dbo.SANPHAM ON dbo.CHITIETKHUYENMAI.MASANPHAM = dbo.SANPHAM.MASANPHAM";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

//                khuyenMai.getMaKhuyenMai();
                ChiTietKhuyenMaiViewModel km = new ChiTietKhuyenMaiViewModel();
                km.setMaKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setTenSanPham(rs.getString(3));
                km.setTienGiam(rs.getDouble(4));
                km.setNgayTao(rs.getDate(5));
                km.setNgayKetThuc(rs.getDate(6));
                km.setGiaBan(rs.getDouble(7));

                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<ChiTietKhuyenMaiViewModel>) listKM;
    }

    @Override
    public void insert(ChiTietKhuyenMai chiTietKhuyenMai) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "insert into CHITIETKHUYENMAI(MASANPHAM,MAKHUYENMAI) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chiTietKhuyenMai.getSanPham());
            ps.setInt(2, chiTietKhuyenMai.getKhuyenMai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

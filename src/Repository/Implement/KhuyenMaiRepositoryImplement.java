/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.KhuyenMai;
import Repository.Interface.KhuyenMaiRepositoryInterface;
import java.util.ArrayList;
import java.util.List;
import Utility.DBContext;
import ViewModel.KhuyenMaiViewModel;
import ViewModel.SanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Statement;

/**
 *
 * @author mr.quyen
 */
public class KhuyenMaiRepositoryImplement implements KhuyenMaiRepositoryInterface {

    @Override
    public List<KhuyenMaiViewModel> getAll() {
        List<KhuyenMaiViewModel> listKM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM KHUYENMAI where TRANGTHAI=1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhuyenMaiViewModel km = new KhuyenMaiViewModel();
                km.setMaKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setTienGiam(rs.getDouble(3));
                km.setTrangThai(rs.getInt(4));
                km.setThoiGianBatDau(rs.getDate(5));
                km.setThoiGianKetThuc(rs.getDate(6));
                km.setMoTa(rs.getString(7));
                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }

    @Override
    public boolean insert(KhuyenMai khuyenMai) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "insert into KHUYENMAI(TENKHUYENMAI,TIENGIAM,TRANGTHAI,THOIGIANBATDAU,THOIGIANKETTHUC,MOTA) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, khuyenMai.getTenKhuyenMai());
            ps.setObject(2, khuyenMai.getTienGiam());
            ps.setObject(3, 1);
            ps.setObject(4, khuyenMai.getThoiGianKetThuc());
            ps.setObject(5, khuyenMai.getThoiGianKetThuc());
            ps.setObject(6, khuyenMai.getMoTa());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int ma) {

        try {
            Connection con = DBContext.getConnection();
            String sql = "delete from KHUYENMAI where MAKHUYENMAI = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(KhuyenMai khuyenMai, int ma) {

        try {
            Connection con = DBContext.getConnection();
            String query = "UPDATE KHUYENMAI SET TENKHUYENMAI=?,TIENGIAM=?, TRANGTHAI=?,THOIGIANBATDAU=?,THOIGIANKETTHUC=?,MOTA=? where MAKHUYENMAI=? ";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setObject(1, khuyenMai.getTenKhuyenMai());
            ps.setObject(2, khuyenMai.getTienGiam());
            ps.setObject(3, 1);
            ps.setObject(4, khuyenMai.getThoiGianBatDau());
            ps.setObject(5, khuyenMai.getThoiGianKetThuc());
            ps.setObject(6, khuyenMai.getMoTa());
            ps.setObject(7, ma);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        List<SanPhamViewModel> listKM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM SANPHAM";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                SanPhamViewModel km = new SanPhamViewModel();
                km.setMaSanPham(rs.getInt(1));
                km.setTenSanPham(rs.getString(12));
                km.setGiaNhap(rs.getDouble(7));
                km.setGiaBan(rs.getDouble(8));
                km.setTinhTrang(rs.getString(9));
                km.setSoLuong(rs.getInt(10));

                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }
//tìm kiếm theo tên sản phâm
    @Override
    public List<SanPhamViewModel> findById(String tenSanPham) {
        List<SanPhamViewModel> listKM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = " Select * from SANPHAM where TENSANPHAM like N'%" + tenSanPham + "%' ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                SanPhamViewModel km = new SanPhamViewModel();
                km.setMaSanPham(rs.getInt(1));
                km.setTenSanPham(rs.getString(12));
                km.setGiaNhap(rs.getDouble(7));
                km.setGiaBan(rs.getDouble(8));
                km.setTinhTrang(rs.getString(9));
                km.setSoLuong(rs.getInt(10));

                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }

    @Override
    public List<KhuyenMai> combobox(int trangThai) {
        List<KhuyenMai> listKM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM KHUYENMAI where TRANGTHAI=1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setTenKhuyenMai(rs.getString(2));
                //km.setTrangThai(rs.getInt(4));
                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }
//xóa tất cả ở ctkm
    @Override
    public boolean deleteAll() {
        try {
            Connection con = DBContext.getConnection();
            String sql = "DELETE FROM CHITIETKHUYENMAI \n"
                    + "WHERE MASANPHAM = MASANPHAM\n"
                    + "AND MAKHUYENMAI = MAKHUYENMAI";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//trạng thái =0 view lịch sử 
    @Override
    public List<KhuyenMaiViewModel> getAllHetHan() {

        List<KhuyenMaiViewModel> listKM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM KHUYENMAI where TRANGTHAI=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhuyenMaiViewModel km = new KhuyenMaiViewModel();
                km.setMaKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setTienGiam(rs.getDouble(3));
                km.setTrangThai(rs.getInt(4));
                km.setThoiGianBatDau(rs.getDate(5));
                km.setThoiGianKetThuc(rs.getDate(6));
                km.setMoTa(rs.getString(7));
                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }
//click vào nút ngừng áp dụng update trạng thái còn khuyến mại = hết khuyến mại và xóa trong ctkm
    @Override
    public boolean updateTrangThai(KhuyenMai khuyenMai, int ma) {
        try {
            Connection con = DBContext.getConnection();
            String query = "UPDATE KHUYENMAI SET  TRANGTHAI=? where MAKHUYENMAI=? ";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setObject(1, 0);
            ps.setObject(2, ma);
            ps.executeUpdate();
            String deleteQuery = "DELETE FROM CHITIETKHUYENMAI WHERE MAKHUYENMAI=?";
            PreparedStatement psDelete = con.prepareStatement(deleteQuery);
            psDelete.setObject(1, ma);
            psDelete.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}

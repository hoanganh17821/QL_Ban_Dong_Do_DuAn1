/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.KhachHang;
import Repository.Interface.KhachHangRepositoryInterface;
import Utility.DBContext;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class KhachhangRepositoryImplement implements KhachHangRepositoryInterface{
    public List<KhachHang> getAll(){
        ArrayList<KhachHang> listKH=new ArrayList<>();
        try {
            Connection conn=DBContext.getConnection();
            String sql="SELECT * FROM KHACHHANG";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                Integer ma=Integer.parseInt(rs.getString(1));
                String hoTen=rs.getString(2);
                int gioiTinh=Integer.parseInt(rs.getString(3));
                String sdt=rs.getString(4);
                String diaChi=rs.getString(5);
                KhachHang kh=new KhachHang(ma, hoTen, gioiTinh, sdt, diaChi);
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
    public Boolean insert(KhachHang kh){
        try {
            Connection conn=DBContext.getConnection();
            String sql="insert into KHACHHANG(HOTEN,GIOITINH,SDT,DIACHI) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,kh.getHoTen());
            ps.setInt(2,kh.getGioiTinh());
            ps.setString(3,kh.getSoDienThoai());
            ps.setString(4,kh.getDiaChi());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public Boolean update(KhachHang kh,String maKhachHang){
        try {
             Connection conn=DBContext.getConnection();
             String sql="UPDATE KHACHHANG SET HOTEN=? ,GIOITINH=?,SDT=?,DIACHI=?\n"+"WHERE MAKHACHHANG=?";
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setString(1,kh.getHoTen());
             ps.setInt(2,kh.getGioiTinh());
             ps.setString(3,kh.getSoDienThoai());
             ps.setString(4,kh.getDiaChi());
             ps.setObject(5,maKhachHang);
             ps.executeUpdate();
             return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(String MAKHACHHANG){
        String sql="delete from KHACHHANG where MAKHACHHANG=?";
        try {
            Connection conn=DBContext.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setObject(1,MAKHACHHANG);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
                  
        }
        return false;
    }

    @Override
    public List<KhachHang> search(String HOTEN) {
        ArrayList<KhachHang> listKH=new ArrayList<>();
        try {
            Connection conn=DBContext.getConnection();
            String sql="SELECT * FROM KHACHHANG WHERE HOTEN like '%"+HOTEN+"%'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                Integer ma=Integer.parseInt(rs.getString(1));
                String hoTen=rs.getString(2);
                int gioiTinh=Integer.parseInt(rs.getString(3));
                String sdt=rs.getString(4);
                String diaChi=rs.getString(5);
                KhachHang kh=new KhachHang(ma, hoTen, gioiTinh, sdt, diaChi);
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
}

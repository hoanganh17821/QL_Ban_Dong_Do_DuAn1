/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;


import java.util.Date;

public class HoaDonViewModel {

    private Integer maHoaDon;
    private NhanVienViewModel nhanVien;
    private KhachHangViewModel khachHang;
    private Date ngayTao;
    private Double tongTien;
    private boolean trangThai;
    private Date ngayThanhToan;
    private String ghiChu;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(Integer maHoaDon, NhanVienViewModel nhanVien, KhachHangViewModel khachHang, Date ngayTao, Double tongTien, boolean trangThai, Date ngayThanhToan, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public NhanVienViewModel getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVienViewModel nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHangViewModel getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangViewModel khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayTao=" + ngayTao + ", tongTien=" + tongTien + ", trangThai=" + trangThai + ", ngayThanhToan=" + ngayThanhToan + ", ghiChu=" + ghiChu + '}';
    }

}

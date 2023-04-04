/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author mr.quyen
 */
public class HoaDonChiTiet {
    private String maHoaDonChiTiet;
    private HoaDonViewModel hoaDon;
    private SanPhamViewModel sanPham;
    private Integer soLuong;
    private Double thanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDonChiTiet, HoaDonViewModel hoaDon, SanPhamViewModel sanPham, Integer soLuong, Double thanhTien) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public HoaDonViewModel getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDonViewModel hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPhamViewModel getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamViewModel sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "maHoaDonChiTiet=" + maHoaDonChiTiet + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }
    
    
    
}

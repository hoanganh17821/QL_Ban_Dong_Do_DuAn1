/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.GioHang;
import java.util.Date;



/**
 *
 * @author mr.quyen
 */
public class ChiTietKhuyenMaiViewModel {

    private Integer maKhuyenMai;
    private String tenKhuyenMai;
    private double tienGiam;
    private String tenSanPham;
    private Date ngayTao;
    private Date ngayKetThuc;
    private double giaBan;
   

    public ChiTietKhuyenMaiViewModel() {
    }

    public ChiTietKhuyenMaiViewModel(Integer maKhuyenMai, String tenKhuyenMai, double tienGiam, String tenSanPham, Date ngayTao, Date ngayKetThuc,double giaBan) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.tienGiam = tienGiam;
        this.tenSanPham = tenSanPham;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.giaBan = giaBan;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(Integer maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public double getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(double tienGiam) {
        this.tienGiam = tienGiam;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
   
    
   public Object[] toDataRow() {
        return new Object[]{maKhuyenMai, tenKhuyenMai, tenSanPham,giaBan,(giaBan*(100-tienGiam))/100,ngayTao,ngayKetThuc,giaBan};
    }

}

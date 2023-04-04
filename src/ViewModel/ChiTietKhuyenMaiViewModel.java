/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author mr.quyen
 */
public class ChiTietKhuyenMaiViewModel {

    private Integer maChiTietKhuyenMai;
    private SanPhamViewModel sanPham;
    private KhuyenMaiViewModel khuyenMai;

    public ChiTietKhuyenMaiViewModel() {
    }

    public ChiTietKhuyenMaiViewModel(Integer maChiTietKhuyenMai, SanPhamViewModel sanPham, KhuyenMaiViewModel khuyenMai) {
        this.maChiTietKhuyenMai = maChiTietKhuyenMai;
        this.sanPham = sanPham;
        this.khuyenMai = khuyenMai;
    }

    public Integer getMaChiTietKhuyenMai() {
        return maChiTietKhuyenMai;
    }

    public void setMaChiTietKhuyenMai(Integer maChiTietKhuyenMai) {
        this.maChiTietKhuyenMai = maChiTietKhuyenMai;
    }

    public SanPhamViewModel getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamViewModel sanPham) {
        this.sanPham = sanPham;
    }

    public KhuyenMaiViewModel getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMaiViewModel khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMai{" + "maChiTietKhuyenMai=" + maChiTietKhuyenMai + ", sanPham=" + sanPham + ", khuyenMai=" + khuyenMai + '}';
    }

}

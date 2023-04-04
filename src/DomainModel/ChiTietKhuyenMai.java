/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author mr.quyen
 */
public class ChiTietKhuyenMai {

    private Integer maChiTietKhuyenMai;
    private SanPham sanPham;
    private KhuyenMai khuyenMai;

    public ChiTietKhuyenMai() {
    }

    public ChiTietKhuyenMai(Integer maChiTietKhuyenMai, SanPham sanPham, KhuyenMai khuyenMai) {
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMai{" + "maChiTietKhuyenMai=" + maChiTietKhuyenMai + ", sanPham=" + sanPham + ", khuyenMai=" + khuyenMai + '}';
    }

}

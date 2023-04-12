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
    private Integer sanPham;
    private Integer khuyenMai;

    public ChiTietKhuyenMai() {
    }

    public ChiTietKhuyenMai(Integer maChiTietKhuyenMai, Integer sanPham, Integer khuyenMai) {
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

    public Integer getSanPham() {
        return sanPham;
    }

    public void setSanPham(Integer sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(Integer khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

   
    
}

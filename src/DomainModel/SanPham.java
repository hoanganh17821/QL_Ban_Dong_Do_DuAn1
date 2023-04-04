/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author mr.quyen
 */
public class SanPham {

    private Integer maSanPham;
    private Size size;
    private ChatLieu chatLieu;
    private MauSac mauSac;
    private LoaiSanPham loaiSanPham;
    private String tenSanPham;
    private String maMay;
    private Double giaNhap;
    private Double GiaBan;
    private boolean tinhTrang;
    private Integer soLuong;
    private String moTa;

    public SanPham() {
    }

    public SanPham(Integer maSanPham, Size size, ChatLieu chatLieu, MauSac mauSac, LoaiSanPham loaiSanPham, String tenSanPham, String maMay, Double giaNhap, Double GiaBan, boolean tinhTrang, Integer soLuong, String moTa) {
        this.maSanPham = maSanPham;
        this.size = size;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
        this.loaiSanPham = loaiSanPham;
        this.tenSanPham = tenSanPham;
        this.maMay = maMay;
        this.giaNhap = giaNhap;
        this.GiaBan = GiaBan;
        this.tinhTrang = tinhTrang;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", size=" + size + ", chatLieu=" + chatLieu + ", mauSac=" + mauSac + ", loaiSanPham=" + loaiSanPham + ", tenSanPham=" + tenSanPham + ", maMay=" + maMay + ", giaNhap=" + giaNhap + ", GiaBan=" + GiaBan + ", tinhTrang=" + tinhTrang + ", soLuong=" + soLuong + ", moTa=" + moTa + '}';
    }

}

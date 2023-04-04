/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author mr.quyen
 */
public class MauSacViewModel {

    private Integer maMauSac;
    private String tenMauSac;

    public MauSacViewModel() {
    }

    public MauSacViewModel(Integer maMauSac, String tenMauSac) {
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
    }

    public Integer getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(Integer maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    @Override
    public String toString() {
        return "MauSac{" + "maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + '}';
    }

}

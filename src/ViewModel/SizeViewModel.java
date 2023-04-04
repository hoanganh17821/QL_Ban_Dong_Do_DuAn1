/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author mr.quyen
 */
public class SizeViewModel {

    private Integer masize;
    private String tenSize;

    public SizeViewModel() {
    }

    public SizeViewModel(Integer masize, String tenSize) {
        this.masize = masize;
        this.tenSize = tenSize;
    }

    public Integer getMasize() {
        return masize;
    }

    public void setMasize(Integer masize) {
        this.masize = masize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return "Size{" + "masize=" + masize + ", tenSize=" + tenSize + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.KhachHang;
import Repository.Interface.*;
import ViewModel.KhachHangViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhachHangServiceInterface {
    public List<KhachHangViewModel>getAll(); 
    public List<KhachHang> search(String HOTEN);
    public boolean insert(KhachHang khachHang);
    public boolean update(KhachHang khachHang, String MAKHACHHANG);
    public boolean delete(String MAKHACHHANG);
}

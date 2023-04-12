/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.ChiTietKhuyenMai;
import ViewModel.ChiTietKhuyenMaiViewModel;
import java.util.ArrayList;

/**
 *
 * @author mr.quyen
 */
public interface ChitietKhuyenMaiServiceInterface {
    ArrayList<ChiTietKhuyenMaiViewModel> getAllCTKM();
    void insert(ChiTietKhuyenMai hdct);
}

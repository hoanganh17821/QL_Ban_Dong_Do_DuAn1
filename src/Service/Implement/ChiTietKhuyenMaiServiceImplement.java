/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.ChiTietKhuyenMai;
import Repository.Implement.ChiTietKhuyenMaiRepositoryImplement;
import Repository.Interface.ChiTietKhuyenMaiRepositoryInterface;
import Service.Interface.ChitietKhuyenMaiServiceInterface;
import ViewModel.ChiTietKhuyenMaiViewModel;
import java.util.ArrayList;



/**
 *
 * @author mr.quyen
 */
public class ChiTietKhuyenMaiServiceImplement  implements ChitietKhuyenMaiServiceInterface{
  private ChiTietKhuyenMaiRepositoryInterface repo = new ChiTietKhuyenMaiRepositoryImplement();
    @Override
    public ArrayList<ChiTietKhuyenMaiViewModel> getAllCTKM() {
       return  repo.getAllCTKM();
    }

    @Override
    public void insert(ChiTietKhuyenMai hdct) {
         repo.insert(hdct);
    }
    
}

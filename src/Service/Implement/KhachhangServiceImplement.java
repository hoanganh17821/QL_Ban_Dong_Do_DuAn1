/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.KhachHang;
import Repository.Implement.KhachhangRepositoryImplement;
import Repository.Interface.KhachHangRepositoryInterface;
import Service.Interface.KhachHangServiceInterface;
import ViewModel.KhachHangViewModel;
import java.util.ArrayList;
import java.util.List;
import Service.Interface.KhachHangServiceInterface;

/**
 *
 * @author mr.quyen
 */
public class KhachhangServiceImplement implements KhachHangServiceInterface{
    private KhachHangRepositoryInterface repo=new KhachhangRepositoryImplement();
    private List<KhachHangViewModel> listkhViewModel;
    private List<KhachHangViewModel> listTK;

    @Override
        public List<KhachHangViewModel> getAll() {
        listkhViewModel =new ArrayList<>();
        List<KhachHang> list= repo.getAll();
        for(KhachHang khachHang : list){
            KhachHangViewModel khachHangViewModel=new KhachHangViewModel();
            khachHangViewModel.setMaKhachHang(khachHang.getMaKhachHang());
            khachHangViewModel.setHoTen(khachHang.getHoTen());
            khachHangViewModel.setGioiTinh(khachHang.getGioiTinh());
            khachHangViewModel.setSoDienThoai(khachHang.getSoDienThoai());
            khachHangViewModel.setDiaChi(khachHang.getDiaChi());
            listkhViewModel.add(khachHangViewModel);
            
        }
        return listkhViewModel;
        }
    @Override
    public boolean insert(KhachHang khachHang) {
        return repo.insert(khachHang);
    }

    @Override
    public boolean update(KhachHang khachHang, String MAKHACHHANG) {
                return repo.update(khachHang, MAKHACHHANG);

    }

    @Override
    public boolean delete(String MAKHACHHANG) {
                return repo.delete(MAKHACHHANG);
    }

    @Override
    public List<KhachHang> search(String HOTEN) {
        return repo.search(HOTEN);
    }
    
    
}

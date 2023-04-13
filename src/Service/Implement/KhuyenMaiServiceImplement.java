/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.KhuyenMai;
import Repository.Implement.KhuyenMaiRepositoryImplement;
import Repository.Interface.KhuyenMaiRepositoryInterface;
import Service.Interface.KhuyenMaiServiceInterface;
import ViewModel.KhuyenMaiViewModel;
import ViewModel.SanPhamViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class KhuyenMaiServiceImplement implements KhuyenMaiServiceInterface {

    private KhuyenMaiRepositoryInterface repo = new KhuyenMaiRepositoryImplement();

    @Override
    public boolean insert(KhuyenMai khuyenMai) {
        return repo.insert(khuyenMai);
    }

    @Override
    public boolean delete(int ma) {
        return repo.delete(ma);
    }

    @Override
    public boolean update(KhuyenMai khuyenMai, int MAKHUYENMAI) {
        return repo.update(khuyenMai, MAKHUYENMAI);
    }

    @Override
    public List<KhuyenMaiViewModel> getAll() {
        return repo.getAll();
    }

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        return repo.getAllSanPham();
    }

    @Override
    public List<SanPhamViewModel> findById(String tenSanPham) {
       return repo.findById(tenSanPham);
    }

    @Override
    public List<KhuyenMai> combobox(int trangThai) {
        return repo.combobox(trangThai);
    }

    @Override
    public boolean deleteAll() {
       return repo.deleteAll();
    }

    @Override
    public boolean updateTrangThai(KhuyenMai khuyenMai, int tt) {
        return repo.updateTrangThai(khuyenMai, tt);
    }

    @Override
    public List<KhuyenMaiViewModel> getAllHetHan() {
        return repo.getAllHetHan();
    }



}

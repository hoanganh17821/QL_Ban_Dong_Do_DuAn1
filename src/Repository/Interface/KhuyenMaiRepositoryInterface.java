/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.KhuyenMai;
import DomainModel.SanPham;
import ViewModel.KhuyenMaiViewModel;
import ViewModel.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhuyenMaiRepositoryInterface {

    public List<KhuyenMaiViewModel> getAll();


    public List<KhuyenMai> combobox(int trangThai);

    public List<SanPhamViewModel> getAllSanPham();

    public boolean insert(KhuyenMai khuyenMai);

    public boolean delete(int ma);

    public boolean update(KhuyenMai khuyenMai, int ma);

    public boolean updateTrangThai(KhuyenMai khuyenMai, int tt);
    
    public List<KhuyenMaiViewModel> getAllHetHan();

    public List<SanPhamViewModel> findById(String tenSanPham);

    public boolean deleteAll();
}

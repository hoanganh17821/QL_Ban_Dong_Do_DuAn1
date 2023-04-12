/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.KhachHang;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhachHangRepositoryInterface {
    public List<KhachHang> getAll();
    
    public Boolean insert(KhachHang kh);
    
    public Boolean update(KhachHang kh, String MAKHACHHANG);
    
    public Boolean delete(String MAKHACHHANG);
    public List<KhachHang> search(String HOTEN);
}

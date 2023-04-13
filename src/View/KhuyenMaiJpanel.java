/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.ChiTietKhuyenMai;
import DomainModel.KhuyenMai;
import Service.Implement.ChiTietKhuyenMaiServiceImplement;
import Service.Implement.KhuyenMaiServiceImplement;
import Service.Interface.ChitietKhuyenMaiServiceInterface;
import Service.Interface.KhuyenMaiServiceInterface;
import ViewModel.ChiTietKhuyenMaiViewModel;
import ViewModel.KhuyenMaiViewModel;
import ViewModel.SanPhamViewModel;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mr.quyen
 */
public class KhuyenMaiJpanel extends javax.swing.JPanel {
    
    private KhuyenMaiServiceInterface khuyenMaiServiceInterface = new KhuyenMaiServiceImplement();
    private ChitietKhuyenMaiServiceInterface chitietKhuyenMaiServiceInterface = new ChiTietKhuyenMaiServiceImplement();

    /**
     * Creates new form KhuyenMaiJpanel
     */
    int tt = 1;
    
    public KhuyenMaiJpanel() {
        initComponents();
        loadTable();
        showDataComboBoxKhuyenMai(tt);
        loadTableChiTietKhuyenMai();
        
    }
    
    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblKM.getModel();
        dtm.setRowCount(0);
        List<KhuyenMaiViewModel> listKM = khuyenMaiServiceInterface.getAll();
        for (KhuyenMaiViewModel dv : listKM) {
            dtm.addRow(dv.toDataRow());
        }
    }
    
    public void loadTableSanPham() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblSanPham.getModel();
        dtm.setRowCount(0);
        List<SanPhamViewModel> listSP = khuyenMaiServiceInterface.getAllSanPham();
        for (SanPhamViewModel sp : listSP) {
            dtm.addRow(sp.toDataRow());
        }
    }
    
    public void loadTableChiTietKhuyenMai() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblChiTietKhuyenMai.getModel();
        dtm.setRowCount(0);
        List<ChiTietKhuyenMaiViewModel> listSP = chitietKhuyenMaiServiceInterface.getAllCTKM();
        for (ChiTietKhuyenMaiViewModel sp : listSP) {
            dtm.addRow(sp.toDataRow());
        }
    }
    
    public void showDataComboBoxKhuyenMai(int tt) {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) this.cbbTenKhuyenMai.getModel();
        dcm.removeAllElements();
        ArrayList<KhuyenMai> list = (ArrayList<KhuyenMai>) this.khuyenMaiServiceInterface.combobox(tt);
        for (KhuyenMai x : list) {
            
            dcm.addElement(x);
        }
    }
    
    public void loadTableTimKiemSanPham(String ten) {
        
        DefaultTableModel dtm = (DefaultTableModel) this.tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPhamViewModel dv : this.khuyenMaiServiceInterface.findById(ten)) {
            dtm.addRow(dv.toDataRow());
        }
    }
    
    public void clearForm() {
        this.jlbmkm.setText("");
        this.txtTenKhuyenMai.setText("");
        this.txtTienGiam.setText("");
        this.txtMoTa.setText("");
        this.txtTHoiGianKetThuc.setText("");
        this.txtThoiGianBatDau.setText("");
        
    }
    
    public KhuyenMai getFormData() {
        SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
        String tenKhuyenMai = txtTenKhuyenMai.getText();
        String tienGiam = txtTienGiam.getText();
        String ngayBatDau = txtThoiGianBatDau.getText();
        String ngayHetHan = txtTHoiGianKetThuc.getText();
        String moTa = txtMoTa.getText();
        Date ngayBD = null;
        Date ngayKT = null;
//        String trangThaiStr = cbbTrangThai.getSelectedItem().toString();
//        int trangThai = trangThaiStr.equalsIgnoreCase("Hết khuyến mãi") ? 0 : 1;
        if (tenKhuyenMai == null || tenKhuyenMai.trim().isEmpty()
                || ngayBatDau == null || ngayBatDau.trim().isEmpty()
                || ngayHetHan == null || ngayHetHan.trim().isEmpty()
                || moTa == null || moTa.trim().isEmpty()
                || tienGiam == null || tienGiam.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return null;
        }
        double tienGiamm;
        try {
            tienGiamm = Double.parseDouble(txtTienGiam.getText());
            if (tienGiamm < 0) {
                JOptionPane.showMessageDialog(this, "Số phần trăm  giảm không được nhỏ hơn 0.");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập phần trăm  giảm hợp lệ.");
            return null;
        }
        try {
            ngayKT = dateForm.parse(ngayHetHan);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày");
            e.printStackTrace();
            return null;
        }
        try {
            ngayBD = dateForm.parse(ngayBatDau);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày");
            e.printStackTrace();
            return null;
        }
        int result = ngayKT.compareTo(ngayBD);
        if(result<0){
             JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
       
            return null;
        }
        KhuyenMai km = new KhuyenMai();
        km.setTenKhuyenMai(tenKhuyenMai);
        km.setTienGiam(tienGiamm);
        km.setThoiGianBatDau(ngayBD);
        km.setThoiGianKetThuc(ngayKT);
        km.setMoTa(moTa);
//        km.setTrangThai(trangThai);
        return km;
    }
    
    private ChiTietKhuyenMai addKm() {
        int indexKhuyenMai = cbbTenKhuyenMai.getSelectedIndex();
        List<KhuyenMaiViewModel> listKhuyenMai = this.khuyenMaiServiceInterface.getAll();
        KhuyenMaiViewModel ten = listKhuyenMai.get(indexKhuyenMai);
        int row = tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm !", "ERORR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        List<SanPhamViewModel> list = this.khuyenMaiServiceInterface.getAllSanPham();
        SanPhamViewModel sanPhamViewModel = list.get(row);
        ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
        chiTietKhuyenMai.setKhuyenMai(ten.getMaKhuyenMai());
        chiTietKhuyenMai.setSanPham(sanPhamViewModel.getMaSanPham());
        return chiTietKhuyenMai;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbnkhuyenmai = new javax.swing.JLabel();
        lbltienGiam = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTenKhuyenMai = new javax.swing.JTextField();
        txtTienGiam = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbbTenKhuyenMai = new javax.swing.JComboBox<>();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChiTietKhuyenMai = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnHienSanPham = new javax.swing.JButton();
        jlbmkm = new javax.swing.JLabel();
        lblmota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtThoiGianBatDau = new javax.swing.JTextField();
        txtTHoiGianKetThuc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnNgungApdung = new javax.swing.JButton();

        jLabel16.setText("Tạo mã khuyến mãi");

        lbnkhuyenmai.setText("Tạo chương trình khuyến mãi");

        lbltienGiam.setText("Phần trăm giảm");

        jLabel19.setText("Thời gian bắt đầu");

        jLabel20.setText("Thời gian kết thúc");

        txtTienGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienGiamActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButton12.setText("Mới");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khuyến mại", "Tên khuyến mại", "Phần trăm giảm", "Trạng Thái", "Thời gian bắt đầu", "Thời gian kết thúc", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKM);
        if (tblKM.getColumnModel().getColumnCount() > 0) {
            tblKM.getColumnModel().getColumn(0).setResizable(false);
            tblKM.getColumnModel().getColumn(1).setResizable(false);
            tblKM.getColumnModel().getColumn(2).setResizable(false);
            tblKM.getColumnModel().getColumn(3).setResizable(false);
            tblKM.getColumnModel().getColumn(4).setResizable(false);
            tblKM.getColumnModel().getColumn(5).setResizable(false);
            tblKM.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel24.setText("Chi tiết khuyến mãi");

        jLabel25.setText("Bạn có thể chọn một trong số khuyến mãi sau");

        btnThemKhuyenMai.setText("Áp khuyến mãi");
        btnThemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhuyenMaiActionPerformed(evt);
            }
        });

        btnXoaTatCa.setText("Xóa tất cả");
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        tblChiTietKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mại", "Tên khuyến mại", "Tên sản phẩm", "Giá bán", "Giá bán khuyến mại", "Thời gian bắt đầu", "Thời gian kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblChiTietKhuyenMai);

        jLabel22.setText("Sản phẩm");

        jLabel23.setText("Tìm kiếm sản phẩm");

        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyReleased(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá nhập", "Giá bán", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblSanPham);

        btnHienSanPham.setText("Add sản phẩm");
        btnHienSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnHienSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHienSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel25)
                        .addGap(33, 33, 33)
                        .addComponent(cbbTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnThemKhuyenMai)
                        .addGap(105, 105, 105)
                        .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(530, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbbTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhuyenMai)
                    .addComponent(btnXoaTatCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jlbmkm.setText("-");

        lblmota.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jButton1.setText("Lịch sử khuyến mại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnNgungApdung.setText("Ngừng áp dụng");
        btnNgungApdung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgungApdungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnkhuyenmai)
                            .addComponent(lbltienGiam)
                            .addComponent(jLabel16))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(txtTienGiam)
                            .addComponent(jlbmkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(txtTHoiGianKetThuc))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txtThoiGianBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(609, 609, 609))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblmota)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(69, 69, 69)
                                .addComponent(btnSua)
                                .addGap(61, 61, 61)
                                .addComponent(btnXoa)
                                .addGap(41, 41, 41)
                                .addComponent(btnNgungApdung)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton12)
                                .addGap(43, 43, 43)
                                .addComponent(jButton1))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbmkm)
                                    .addComponent(jLabel19)
                                    .addComponent(txtThoiGianBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblmota))))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbnkhuyenmai)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txtTHoiGianKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltienGiam)
                            .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(jButton12)
                            .addComponent(jButton1)
                            .addComponent(btnNgungApdung)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhuyenMaiActionPerformed
        ChiTietKhuyenMai chiTietKhuyenMai = this.addKm();
        if (chiTietKhuyenMai == null) {
            return;
        }
        this.chitietKhuyenMaiServiceInterface.insert(chiTietKhuyenMai);
        //this.khuyenMaiServiceInterface.updateGiaBan(tt, Double.NaN);
        this.loadTable();
        this.loadTableChiTietKhuyenMai();
        this.showDataComboBoxKhuyenMai(tt);
        this.loadTableSanPham();
        this.clearForm();
    }//GEN-LAST:event_btnThemKhuyenMaiActionPerformed

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed
        this.khuyenMaiServiceInterface.deleteAll();
        this.loadTable();
        this.loadTableChiTietKhuyenMai();
        this.showDataComboBoxKhuyenMai(tt);
        this.loadTableSanPham();
        this.clearForm();
    }//GEN-LAST:event_btnXoaTatCaActionPerformed

    private void btnHienSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienSanPhamActionPerformed
        loadTableSanPham();
    }//GEN-LAST:event_btnHienSanPhamActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhuyenMai khuyenMai = this.getFormData();
        
        if (khuyenMai == null) {
            return;
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thêm");
            if (confirm == JOptionPane.YES_NO_OPTION) {
                this.khuyenMaiServiceInterface.insert(khuyenMai);
                this.loadTable();
                this.showDataComboBoxKhuyenMai(tt);
                this.clearForm();
            }
            
        }
        

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = this.tblKM.getSelectedRow();
        KhuyenMai khuyenMai = this.getFormData();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng để sửa");
            return;
        }
        Integer ma = Integer.parseInt(this.tblKM.getValueAt(row, 0).toString());
        this.khuyenMaiServiceInterface.update(khuyenMai, ma);
        this.loadTable();
        this.showDataComboBoxKhuyenMai(tt);
        this.clearForm();
        

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tblKM.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 dòng để xóa");
            return;
        }
        Integer ma = Integer.parseInt(this.tblKM.getValueAt(row, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa");
        if (confirm == JOptionPane.YES_NO_OPTION) {
            khuyenMaiServiceInterface.delete(ma);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTable();
            this.showDataComboBoxKhuyenMai(tt);
            clearForm();
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        clearForm();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMMouseClicked
        int row = this.tblKM.getSelectedRow();
        if (row == -1) {
            return;
        }
        String ma = this.tblKM.getValueAt(row, 0).toString();
        String ten = this.tblKM.getValueAt(row, 1).toString();
        String tien = this.tblKM.getValueAt(row, 2).toString();
        
        String tt = this.tblKM.getValueAt(row, 3).toString();
        String tgdb = this.tblKM.getValueAt(row, 4).toString();
        String tgkt = this.tblKM.getValueAt(row, 5).toString();
        String mota = this.tblKM.getValueAt(row, 6).toString();
        this.jlbmkm.setText(ma);
        this.txtTenKhuyenMai.setText(ten);
        this.txtTienGiam.setText(tien);
        // this.cbbTrangThai.setSelectedItem(tt);
        this.txtThoiGianBatDau.setText(tgdb);
        this.txtTHoiGianKetThuc.setText(tgkt);
        this.txtMoTa.setText(mota);
        

    }//GEN-LAST:event_tblKMMouseClicked

    private void txtTienGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienGiamActionPerformed

    private void txtTimKiemSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyReleased
        String tenSanPham = txtTimKiemSanPham.getText();
        loadTableTimKiemSanPham(tenSanPham);

    }//GEN-LAST:event_txtTimKiemSanPhamKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //         SendMailHD sen = new SendMailHD();
//        sen.setVisible(true);
        LichSuKhuyenMai khuyenMai = new LichSuKhuyenMai();
        khuyenMai.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNgungApdungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgungApdungActionPerformed
        int row = this.tblKM.getSelectedRow();
        KhuyenMai khuyenMai = this.getFormData();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }
        Integer ma = Integer.parseInt(this.tblKM.getValueAt(row, 0).toString());
        this.khuyenMaiServiceInterface.updateTrangThai(khuyenMai, ma);
        this.loadTable();
        loadTableChiTietKhuyenMai();
        this.showDataComboBoxKhuyenMai(tt);
        this.clearForm();
    }//GEN-LAST:event_btnNgungApdungActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienSanPham;
    private javax.swing.JButton btnNgungApdung;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.JComboBox<String> cbbTenKhuyenMai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlbmkm;
    private javax.swing.JLabel lblmota;
    private javax.swing.JLabel lbltienGiam;
    private javax.swing.JLabel lbnkhuyenmai;
    private javax.swing.JTable tblChiTietKhuyenMai;
    private javax.swing.JTable tblKM;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTHoiGianKetThuc;
    private javax.swing.JTextField txtTenKhuyenMai;
    private javax.swing.JTextField txtThoiGianBatDau;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTimKiemSanPham;
    // End of variables declaration//GEN-END:variables

}

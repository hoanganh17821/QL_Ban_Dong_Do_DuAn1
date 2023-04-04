/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import DomainModel.Chuyenman;
import View.BanHangJpanel;
import View.HoaDonJpanell;
import View.KhachHangJpanel;
import View.KhuyenMaiJpanel;
import View.NhanVienJpanel;
import View.SanPhamJpanel;

import View.ThongKeJpanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mr.quyen
 */
public class Chuyenmanmain {

    private JPanel root;
    private String kinSelected = "";
    private List<Chuyenman> listitem = null;

    public Chuyenmanmain(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setview(JPanel jpnitem, JLabel jlbitem) {
        kinSelected = "BanHang";
        jpnitem.setBackground(new Color(96, 100, 191));
        jlbitem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new BanHangJpanel());
        root.validate();
        root.repaint();

    }

    public void setEvent(List<Chuyenman> listitem) {
        this.listitem = listitem;
        for (Chuyenman chuyen : listitem) {
            chuyen.getJlb().addMouseListener(new LabelEvent(chuyen.getKind(), chuyen.getJpn(), chuyen.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnitem;
        private JLabel jlbitem;

        public LabelEvent(String kind, JPanel jpnitem, JLabel jlbitem) {
            this.kind = kind;
            this.jpnitem = jpnitem;
            this.jlbitem = jlbitem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "ThongKe":
                    node = new ThongKeJpanel();
                    break;
                case "BanHang":
                    node = new BanHangJpanel();
                    break;
                case "NhanVien":
                    node = new NhanVienJpanel();
                    break;
                case "SanPham":
                    node = new SanPhamJpanel();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiJpanel();
                    break;
                case "KhachHang":
                    node = new KhachHangJpanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJpanell();
                    break;
                
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kinSelected = kind;
            jlbitem.setBackground(new Color(255, 204, 204));
            jpnitem.setBackground(new Color(255, 204, 204));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
   
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jlbitem.setBackground(new Color(255, 204, 204));
            jpnitem.setBackground(new Color(255, 204, 204));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kinSelected.equalsIgnoreCase(kind)) {
                jlbitem.setBackground(new Color(255, 102, 102));
                jpnitem.setBackground(new Color(255, 102, 102));
            }
        }

    }

    private void setChangeBackgroud(String kind) {
        for (Chuyenman item : listitem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJlb().setBackground(new Color(255, 204, 204));
                item.getJpn().setBackground(new Color(255, 204, 204));
            } else {
                item.getJpn().setBackground(new Color(255, 102, 102));
                item.getJlb().setBackground(new Color(255, 102, 102));
            }
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Bar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.DonHangView;
import view.GioHangView;
import view.KhachHangView;
import view.SanPhamView;

/**
 *
 * @author A715-42G
 */
public class BarController {

    private JPanel root;
    private String typeS = "";

    private ArrayList<Bar> listItem = null;

    public BarController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnI, JLabel jlbI) {
        typeS = "SanPham";
//        jpnI.setBackground(new Color(96, 100, 191));
//        jlbI.setBackground(new Color(96, 100, 191));
        root.removeAll(); // ???
        root.setLayout(new BorderLayout()); // ????
        root.add(new SanPhamView()); // ???
        root.validate(); // ???
        root.repaint(); // ???
    }

    public void setEvent(ArrayList<Bar> listItem) {
        this.listItem = listItem;
        for (Bar item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getType(), item.getJpn(), item.getJlb()));
//            item.getJpn().addMouseListener(new LabelEvent(item.getType(),item.getJpn(),item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String type;
        private JPanel jpnI;
        private JLabel jlbI;

        public LabelEvent(String type, JPanel jpnI, JLabel jlbI) {
            this.type = type;
            this.jpnI = jpnI;
            this.jlbI = jlbI;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (type) {
                case "SanPham":
                    node = new SanPhamView();
                    break;
                case "GioHang":
                    node = new GioHangView();
                    break;
                case "DonHang":
                    node = new DonHangView();
                    break;
                case "KhachHang":
                    node = new KhachHangView();
                    break;
                default:
                    node = new SanPhamView();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackGround(type);
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            typeS = type;
//            jpnI.setBackground(new Color(96, 100, 191));
//            jlbI.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnI.setBackground(new Color(96, 100, 191));
            jlbI.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!typeS.equalsIgnoreCase(type)) {
                jpnI.setBackground(new Color(242, 242, 242));
                jlbI.setBackground(new Color(242, 242, 242));
            }
        }

        private void setChangeBackGround(String type) {
            for (Bar item : listItem) {
                if (item.getType().equalsIgnoreCase(type)) {
                    jpnI.setBackground(new Color(96, 100, 191));
                    jlbI.setBackground(new Color(96, 100, 191));
                } else {
                    jpnI.setBackground(new Color(242, 242, 242));
                    jlbI.setBackground(new Color(242, 242, 242));
                }
            }
        }
    }
}

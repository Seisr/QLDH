/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import dao.KhachHangDAO;
import dao.SanPhamDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author A715-42G
 */
public class ThongKeController {

    public void addPieChart(JPanel jpnPieChart) throws SQLException {

        int DXL = Integer.parseInt(DonHangDAO.countDXL());
        int DGH = Integer.parseInt(DonHangDAO.countDGH());
        int DHT = Integer.parseInt(DonHangDAO.countDHT());
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Đang xử lý", DXL);
        pieDataset.setValue("Đang giao hàng", DGH);
        pieDataset.setValue("Đã hoàn thành", DHT);
        JFreeChart chart = ChartFactory.createPieChart("Thống kê tình trạng đơn hàng", pieDataset, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        ChartPanel cp = new ChartPanel(chart);
        cp.setPreferredSize(new Dimension(415, 220));
        jpnPieChart.setLayout(new CardLayout());
        jpnPieChart.add(cp);
    }

    public void addBarChart(JPanel jpnBarChart) throws SQLException {
        DefaultCategoryDataset barDS = new DefaultCategoryDataset();
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(1)), "SL tồn kho", "Bánh mì kẹp");
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(2)), "SL tồn kho", "Dừa xiêm xanh");
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(3)), "SL tồn kho", "Dừa xiêm tắc");
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(4)), "SL tồn kho", "Dừa xiêm sen");
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(6)), "SL tồn kho", "Bánh mì que");
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(7)), "SL tồn kho", "Chà bông");
        barDS.setValue(Integer.parseInt(SanPhamDAO.selectSLTonKho(8)), "SL tồn kho", "Bánh mì xíu mại");
        JFreeChart barChart = ChartFactory.createBarChart("Thống kê số lượng tồn kho theo mặt hàng", "Sản phẩm", "SL tồn kho", barDS, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p1 = barChart.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.black);
        ChartPanel cp1 = new ChartPanel(barChart);
        cp1.setPreferredSize(new Dimension(830, 200));
        jpnBarChart.setLayout(new CardLayout());
        jpnBarChart.add(cp1);
    }

    public void addStat(JLabel totalKH, JLabel totalDH, JLabel maxKH, JLabel avgDH, JLabel totalSP) throws SQLException {
        totalKH.setText(KhachHangDAO.countKH());
        totalDH.setText(DonHangDAO.countDH());
        maxKH.setText(DonHangDAO.getHoTenMaxTongTien());
        avgDH.setText(DonHangDAO.avgDH());
        totalSP.setText(SanPhamDAO.tongSP());
    }
}

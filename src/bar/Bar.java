/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bar;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A715-42G
 */
public class Bar {
    private String type;
    private JPanel jpn;
    private JLabel jlb;
    
    public Bar(){
    
    }

    public Bar(String type, JPanel jpn, JLabel jlb) {
        this.type = type;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
}

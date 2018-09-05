/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
/**
 *
 * @author Madhawa
 */
public class Reportview extends JFrame {
     public Reportview(String fileName)
    {
        this(fileName, null);
    }
    public Reportview(String fileName, HashMap para)
    {
        super("Wings Airlines (Report Viewer)");

        ireportDatabaseAccess dba = new ireportDatabaseAccess();
        Connection con = dba.getConnection();

        try
        {
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (JRException jRException)
        {
            JOptionPane.showMessageDialog(null, jRException);
        }
        setBounds(10, 10, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

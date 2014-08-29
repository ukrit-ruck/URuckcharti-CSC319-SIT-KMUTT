/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpair;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author uruckcharti
 */
public class DrawClosestPair extends javax.swing.JPanel {
    int n = 10;
    int[][] point;
    int[] closestPoint1, closestPoint2;

    public DrawClosestPair (int[][] point, int[] closestPoint1, int[] closestPoint2) {
        this.point = point;
        this.closestPoint1 = closestPoint1;
        this.closestPoint2 = closestPoint2;
        initComponents();
    }
    
    public void paintComponent (Graphics page) {
        for (int i = 0; i < n; i++) {
            page.drawOval(point[i][0]-5, point[i][1]-5, 10, 10);
        }
        
        page.setColor(Color.black);
        page.drawLine(closestPoint1[0], closestPoint1[1], closestPoint2[0] , closestPoint2[1]);
    }
    
    public void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 320, Short.MAX_VALUE));
    }
}

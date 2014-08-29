/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package closestpair;
import javax.swing.JFrame;
import java.io.IOException;
/**
 *
 * @author U. Ruckcharti 56130500275
 * @version 28-aug-2014
 */
public class ClosestPair {
    static int n = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int point[][] = new int[n][2];
        point[0][0] = 50;   point[0][1] = 100; // point at (50, 100)
        point[1][0] = 130;  point[1][1] = 160;
        point[2][0] = 40;   point[2][1] = 130;
        point[3][0] = 130;  point[3][1] = 60;
        point[4][0] = 200;  point[4][1] = 160;
        point[5][0] = 100;  point[5][1] = 210;
        point[6][0] = 70;   point[6][1] = 200;
        point[7][0] = 170;  point[7][1] = 140;
        point[8][0] = 230;  point[8][1] = 154;
        point[9][0] = 180;  point[9][1] = 72;
        
        int closest[] = new int[2];
        closest = findClosestPair(point);
        System.out.println("Closest pair is point " + closest[0]
                + " (" + point[closest[0]][0] + ", " + point[closest[0]][1] + ")"
                + " to point " + closest[1] + " (" + point[closest[1]][0] + ", " + point[closest[1]][1] + ")");
        
        JFrame frame = new JFrame("Closest Pair");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawClosestPair panel = new DrawClosestPair(point, point[closest[0]], point[closest[1]]);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static int[] findClosestPair(int p[][]) {
        // c^2 = a^2 + b^2
        //   c = sqrt(a^2 + b^2)
        //     = sqrt((x2 - x1)^2 + (y2 - y1)^2)
        // c is the distance between point1 and point2
        int closest1 = 0, closest2 = 0;
        double distanceSqr, shortestDistance = 1000000;
        for (int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                distanceSqr = Math.pow(p[i][0] - p[j][0], 2) + Math.pow(p[i][1] - p[j][1], 2);
                if (distanceSqr < shortestDistance) {
                    closest1 = i; closest2 = j;
                    shortestDistance = distanceSqr;
                }
            }
        }
        int x[] = {closest1, closest2};
        return x;
    }
}
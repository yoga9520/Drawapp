package class_design;

import java.awt.Graphics;

//∂‡±ﬂ–Œ¿‡
class Polygon implements Shape {
 private int x, y, sides, size;
 private boolean fill;

 public Polygon(int x, int y, int sides, int size) {
     this.x = x;
     this.y = y;
     this.sides = sides;
     this.size = size;
 }

 @Override
 public void draw(Graphics g) {
     int[] xPoints = new int[sides];
     int[] yPoints = new int[sides];

     for (int i = 0; i < sides; i++) {
         xPoints[i] = x + (int) (size * Math.cos(2 * Math.PI * i / sides));
         yPoints[i] = y + (int) (size * Math.sin(2 * Math.PI * i / sides));
     }

     if (fill) {
         g.fillPolygon(xPoints, yPoints, sides);
     } else {
         g.drawPolygon(xPoints, yPoints, sides);
     }
 }

 @Override
 public void setFill(boolean fill) {
     this.fill = fill;
 }
}

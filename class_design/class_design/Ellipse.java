package class_design;

import java.awt.Graphics;

//椭圆类
class Ellipse implements Shape {
	//椭圆的横纵坐标，宽和高
 private int x, y, width, height;
 private boolean fill;

 public Ellipse(int x, int y, int width, int height) {
     this.x = x;
     this.y = y;
     this.width = width;
     this.height = height;
 }

 @Override
 public void draw(Graphics g) {
     if (fill) {
         g.fillOval(x, y, width, height);
     } else {
         g.drawOval(x, y, width, height);
     }
 }

 @Override
 public void setFill(boolean fill) {
     this.fill = fill;
 }
}

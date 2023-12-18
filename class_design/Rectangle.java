package class_design;

import java.awt.Graphics;

//矩形类
class Rectangle implements Shape {
//矩形起始点的横纵坐标，宽和高
 private int x, y, width, height;
 private boolean fill;

 public Rectangle(int x, int y, int width, int height) {
     this.x = x;
     this.y = y;
     this.width = width;
     this.height = height;
 }
//生成构造器
 @Override
 public void draw(Graphics g) {
     if (fill) {
         g.fillRect(x, y, width, height);
     } else {
         g.drawRect(x, y, width, height);
     }
 }

 @Override
 public void setFill(boolean fill) {
     this.fill = fill;
 }


}

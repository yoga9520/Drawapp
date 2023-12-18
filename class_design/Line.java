package class_design;

import java.awt.Graphics;

//直线类
class Line implements Shape {
 private int x1, y1, x2, y2;


 public Line(int x1, int y1, int x2, int y2) {
     this.x1 = x1;
     this.y1 = y1;
     this.x2 = x2;
     this.y2 = y2;
 }

 @Override
 public void draw(Graphics g) {
     g.drawLine(x1, y1, x2, y2);
 }

//直线没有实心
@Override
public void setFill(boolean fill) {
	// TODO 自动生成的方法存根
	
}
 
}
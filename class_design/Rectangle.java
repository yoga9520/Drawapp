package class_design;

import java.awt.Graphics;

//������
class Rectangle implements Shape {
//������ʼ��ĺ������꣬��͸�
 private int x, y, width, height;
 private boolean fill;

 public Rectangle(int x, int y, int width, int height) {
     this.x = x;
     this.y = y;
     this.width = width;
     this.height = height;
 }
//���ɹ�����
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

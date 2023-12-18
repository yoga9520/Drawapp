package class_design;

import java.awt.Graphics;

//图形接口，定义绘制和填充方法
interface Shape {
 void draw(Graphics g);
 void setFill(boolean fill);
}

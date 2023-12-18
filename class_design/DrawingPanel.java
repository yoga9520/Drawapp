package class_design;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import class_design.DrawingPanel.CustomMouseListener;

//绘图面板，用于绘制图形
class DrawingPanel extends JPanel {
	//容器
 private ArrayList<Shape> shapes = new ArrayList<>();
 private int shapeType = 0; // 0: 直线, 1: 椭圆, 2: 矩形, 3: 多边形
 private boolean fillShape = false;

 //构造
 public DrawingPanel() {
 	
     setBackground(Color.white);
     addMouseListener(new CustomMouseListener());
 }

 // 设置当前要绘制的图形类型
 public void setShapeType(int shapeType) {
     this.shapeType = shapeType;
 }

 // 设置是否填充图形
 public void setFillShape(boolean fillShape) {
     this.fillShape = fillShape;
 }

 // 撤销上一步绘制操作
 public void undo() {
     if (!shapes.isEmpty()) {
         shapes.remove(shapes.size() - 1);
         repaint();
     }
 }

 // 绘制几何图形
 @Override
 protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     //遍历对象的容器
     for (Shape shape : shapes) {
         shape.draw(g);
     }
 }

 // 鼠标事件监听器
 class CustomMouseListener extends MouseAdapter {
     private int startX, startY, endX, endY;

     //起始坐标
     @Override
     public void mousePressed(MouseEvent e) {
         startX = e.getX();
         startY = e.getY();
     }

     
     @Override
     public void mouseReleased(MouseEvent e) {
    	//终止坐标
         endX = e.getX();
         endY = e.getY();
         Shape shape = createShape(startX, startY, endX, endY);
         if (shape != null) {
             shape.setFill(fillShape);
             shapes.add(shape);
             repaint();
         }
     }
 }

 public void clearShapes() {
     shapes.clear();
     repaint();
 }
 // 根据当前图形类型创建相应的图形对象
 private Shape createShape(int x1, int y1, int x2, int y2) {
     switch (shapeType) {
         case 0:
             return new Line(x1, y1, x2, y2);
         case 1:
             return new Ellipse(x1, y1, x2 - x1, y2 - y1);
         case 2:
             return new Rectangle(x1, y1, x2 - x1, y2 - y1);
         case 3:
             return new Polygon(x1, y1, 6, 50);
         default:
             return null;
     }
 }
}



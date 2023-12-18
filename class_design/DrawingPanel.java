package class_design;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import class_design.DrawingPanel.CustomMouseListener;

//��ͼ��壬���ڻ���ͼ��
class DrawingPanel extends JPanel {
	//����
 private ArrayList<Shape> shapes = new ArrayList<>();
 private int shapeType = 0; // 0: ֱ��, 1: ��Բ, 2: ����, 3: �����
 private boolean fillShape = false;

 //����
 public DrawingPanel() {
 	
     setBackground(Color.white);
     addMouseListener(new CustomMouseListener());
 }

 // ���õ�ǰҪ���Ƶ�ͼ������
 public void setShapeType(int shapeType) {
     this.shapeType = shapeType;
 }

 // �����Ƿ����ͼ��
 public void setFillShape(boolean fillShape) {
     this.fillShape = fillShape;
 }

 // ������һ�����Ʋ���
 public void undo() {
     if (!shapes.isEmpty()) {
         shapes.remove(shapes.size() - 1);
         repaint();
     }
 }

 // ���Ƽ���ͼ��
 @Override
 protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     //�������������
     for (Shape shape : shapes) {
         shape.draw(g);
     }
 }

 // ����¼�������
 class CustomMouseListener extends MouseAdapter {
     private int startX, startY, endX, endY;

     //��ʼ����
     @Override
     public void mousePressed(MouseEvent e) {
         startX = e.getX();
         startY = e.getY();
     }

     
     @Override
     public void mouseReleased(MouseEvent e) {
    	//��ֹ����
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
 // ���ݵ�ǰͼ�����ʹ�����Ӧ��ͼ�ζ���
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



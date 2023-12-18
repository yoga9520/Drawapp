package class_design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;


// ��������
public class DrawingApp extends JFrame {
    private DrawingPanel drawingPanel;

    public DrawingApp() {
        setTitle("����ͼ��");
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�

        drawingPanel = new DrawingPanel();
        
     // �����˵���
        JMenuBar menuBar = new JMenuBar();

        // �����ļ��˵�
        JMenu fileMenu = new JMenu("ֱ��");
        JMenu fileMenu2 = new JMenu("��Բ");
        JMenu fileMenu3 = new JMenu("����");
        JMenu fileMenu4 = new JMenu("�����");
        
        // ����ͼ�εĿ��ģ�ʵ�ķ�֧�˵���
        JMenuItem line = new JMenuItem("ֱ��");
        JMenuItem hollowEllipse = new JMenuItem("������Բ");
        JMenuItem solidEllipse = new JMenuItem("ʵ����Բ");
        JMenuItem hollowRectangle = new JMenuItem("���ľ���");
        JMenuItem solidRectangle = new JMenuItem("ʵ�ľ���");
        JMenuItem hollowPolygon = new JMenuItem("���Ķ����");
        JMenuItem solidPolygon = new JMenuItem("ʵ�Ķ����");
        
        line.addActionListener(e -> drawingPanel.setShapeType(0));
        //������Բ�����
        hollowEllipse.addActionListener(e -> {
        	drawingPanel.setShapeType(1);
        	drawingPanel.setFillShape(false);
        });
        //ʵ����Բ��䣬��Fill��Ϊtrue
        solidEllipse.addActionListener(e -> {
        	drawingPanel.setShapeType(1);
        	drawingPanel.setFillShape(true);
        });
        // ���˵�����ӵ��ļ��˵�
        fileMenu.add(line);
        fileMenu2.add(hollowEllipse);
        //�ָ���
        fileMenu2.addSeparator();
        fileMenu2.add(solidEllipse);
        
        fileMenu3.add(hollowRectangle);
        fileMenu3.addSeparator();
        fileMenu3.add(solidRectangle);
        
        fileMenu4.add(hollowPolygon);
        fileMenu4.addSeparator();
        fileMenu4.add(solidPolygon);
       
        

        // ���ļ��˵���ӵ��˵���
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);
        menuBar.add(fileMenu3);
        menuBar.add(fileMenu4);

        // ���ò˵���
        setJMenuBar(menuBar);


        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e -> drawingPanel.setShapeType(0));

        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.addActionListener(e -> drawingPanel.setShapeType(1));

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(e -> drawingPanel.setShapeType(2));

        JButton polygonButton = new JButton("Polygon");
        polygonButton.addActionListener(e -> drawingPanel.setShapeType(3));

        JCheckBox fillCheckBox = new JCheckBox("Fill");
        fillCheckBox.addActionListener(e -> drawingPanel.setFillShape(fillCheckBox.isSelected()));

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> drawingPanel.undo());

        JPanel controlPanel = new JPanel();
        controlPanel.add(lineButton);
        controlPanel.add(ellipseButton);
        controlPanel.add(rectangleButton);
        controlPanel.add(polygonButton);
        controlPanel.add(fillCheckBox);
        controlPanel.add(undoButton);

        add(controlPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }

  

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingApp combinedApp = new DrawingApp();
            combinedApp.setVisible(true);
        });
    }
}

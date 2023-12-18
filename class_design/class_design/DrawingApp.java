package class_design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;


// 主程序类
public class DrawingApp extends JFrame {
    private DrawingPanel drawingPanel;

    public DrawingApp() {
        setTitle("绘制图形");
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭

        drawingPanel = new DrawingPanel();
        
     // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 创建文件菜单
        JMenu fileMenu = new JMenu("直线");
        JMenu fileMenu2 = new JMenu("椭圆");
        JMenu fileMenu3 = new JMenu("矩形");
        JMenu fileMenu4 = new JMenu("多边形");
        
        // 创建图形的空心，实心分支菜单项
        JMenuItem line = new JMenuItem("直线");
        JMenuItem hollowEllipse = new JMenuItem("空心椭圆");
        JMenuItem solidEllipse = new JMenuItem("实心椭圆");
        JMenuItem hollowRectangle = new JMenuItem("空心矩形");
        JMenuItem solidRectangle = new JMenuItem("实心矩形");
        JMenuItem hollowPolygon = new JMenuItem("空心多边形");
        JMenuItem solidPolygon = new JMenuItem("实心多边形");
        
        line.addActionListener(e -> drawingPanel.setShapeType(0));
        //空心椭圆不填充
        hollowEllipse.addActionListener(e -> {
        	drawingPanel.setShapeType(1);
        	drawingPanel.setFillShape(false);
        });
        //实心椭圆填充，将Fill设为true
        solidEllipse.addActionListener(e -> {
        	drawingPanel.setShapeType(1);
        	drawingPanel.setFillShape(true);
        });
        // 将菜单项添加到文件菜单
        fileMenu.add(line);
        fileMenu2.add(hollowEllipse);
        //分割线
        fileMenu2.addSeparator();
        fileMenu2.add(solidEllipse);
        
        fileMenu3.add(hollowRectangle);
        fileMenu3.addSeparator();
        fileMenu3.add(solidRectangle);
        
        fileMenu4.add(hollowPolygon);
        fileMenu4.addSeparator();
        fileMenu4.add(solidPolygon);
       
        

        // 将文件菜单添加到菜单栏
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);
        menuBar.add(fileMenu3);
        menuBar.add(fileMenu4);

        // 设置菜单栏
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

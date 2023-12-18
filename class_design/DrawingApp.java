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
        setTitle("Combined Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭

        drawingPanel = new DrawingPanel();
        
     // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 创建文件菜单
        JMenu fileMenu = new JMenu("File");

        // 创建清除图形的菜单项
        JMenuItem clearMenuItem = new JMenuItem("Clear Shapes");
        clearMenuItem.addActionListener(e -> drawingPanel.clearShapes());

        // 创建退出的菜单项
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));

        // 将菜单项添加到文件菜单
        fileMenu.add(clearMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // 将文件菜单添加到菜单栏
        menuBar.add(fileMenu);

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

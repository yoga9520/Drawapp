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
        setTitle("Combined Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�

        drawingPanel = new DrawingPanel();
        
     // �����˵���
        JMenuBar menuBar = new JMenuBar();

        // �����ļ��˵�
        JMenu fileMenu = new JMenu("File");

        // �������ͼ�εĲ˵���
        JMenuItem clearMenuItem = new JMenuItem("Clear Shapes");
        clearMenuItem.addActionListener(e -> drawingPanel.clearShapes());

        // �����˳��Ĳ˵���
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));

        // ���˵�����ӵ��ļ��˵�
        fileMenu.add(clearMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // ���ļ��˵���ӵ��˵���
        menuBar.add(fileMenu);

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

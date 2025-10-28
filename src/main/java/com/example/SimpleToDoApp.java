package com.example;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimpleToDoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple To-Do List");
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JTextField field = new JTextField(20);
        JButton addBtn = new JButton("Add");
        JButton delBtn = new JButton("Delete");

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(field);
        bottom.add(addBtn);
        bottom.add(delBtn); // This adds the "Delete" button to the panel
        frame.add(bottom, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            String item = field.getText().trim();
            if (!item.isEmpty()) {
                model.addElement(item);
                field.setText("");
            }
        });

        delBtn.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                model.remove(idx);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

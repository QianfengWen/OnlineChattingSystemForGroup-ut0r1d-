package main.java.chattingSystem.frameworks_drivers.ui.views;

import javax.swing.*;

public class LabelTextPanel extends JPanel{
    LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}

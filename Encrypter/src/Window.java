import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class Window extends JFrame {
    JPanel mainPanel, buttonsPanel;
//    JTextField input, output;
    JTextArea input, output;
    JButton encryptButton, decryptButton;

    public Window() {
        super("adaCode");

        setLayout(new BorderLayout());

        mainPanel = new JPanel(new BorderLayout());

        // <Input/Output>
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(new Color(45, 45, 45));
        input = new JTextArea(6, 25);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        input.setAutoscrolls(true);
        input.setFont(new Font("Monospace", Font.PLAIN, 22));
        input.setBackground(new Color(65, 65, 65));
        input.setForeground(new Color(240, 240, 240));
        input.setBorder(BorderFactory.createLineBorder(new Color(20, 20, 20)));
        input.setCaretColor(Color.WHITE);
        input.setSelectionColor(new Color(230, 230, 230));
        input.setSelectedTextColor(new Color(30, 30, 30));

        JLabel inputLabel = new JLabel("Input:    ");
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setFont(new Font("Monospace", Font.PLAIN, 22));
        inputPanel.add(inputLabel);

        inputPanel.add(input);
        JScrollPane inputScroll = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inputScroll.getVerticalScrollBar().setBackground(new Color(45, 45, 45));
        inputScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(90, 90, 90);
            }
        });
        inputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputScroll.setBorder(null);
        inputPanel.add(inputScroll);

        JPanel outputPanel = new JPanel(new FlowLayout());
        outputPanel.setBackground(new Color(45, 45, 45));
        output = new JTextArea(6, 25);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setAutoscrolls(true);
        output.setEditable(false);
        output.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        output.setFont(new Font("Monospace", Font.PLAIN, 22));
        output.setBackground(new Color(65, 65, 65));
        output.setForeground(new Color(240, 240, 240));
        output.setBorder(BorderFactory.createLineBorder(new Color(20, 20, 20)));
        output.setSelectionColor(new Color(230, 230, 230));
        output.setSelectedTextColor(new Color(30, 30, 30));

        JLabel outputLabel = new JLabel("Output: ");
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setFont(new Font("Monospace", Font.PLAIN, 22));
        outputPanel.add(outputLabel);
        outputPanel.add(output);
        JScrollPane outputScroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outputScroll.getVerticalScrollBar().setBackground(new Color(45, 45, 45));
        outputScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(90, 90, 90);
            }

        });
        outputScroll.setBorder(null);
        outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        UIManager.put("ScrollBar.track", new ColorUIResource(Color.black));
        outputPanel.add(outputScroll);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        // <Buttons>
        buttonsPanel = new JPanel(new FlowLayout());
        encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(event ->  encrypt());
        encryptButton.setBackground(new Color(93, 93, 93));
        encryptButton.setForeground(Color.WHITE);
        encryptButton.setFocusPainted(false);
        encryptButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        decryptButton = new JButton("Decrpyt");
        decryptButton.addActionListener(event -> decrypt());
        decryptButton.setBackground(new Color(93, 93, 93));
        decryptButton.setForeground(Color.WHITE);
        decryptButton.setFocusPainted(false);
        decryptButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        JButton switchButton = new JButton("Switch");
        switchButton.addActionListener(event -> switchText());
        switchButton.setBackground(new Color(93, 93, 93));
        switchButton.setForeground(Color.WHITE);
        switchButton.setFocusPainted(false);
        switchButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        buttonsPanel.add(decryptButton);
        buttonsPanel.add(switchButton);
        buttonsPanel.add(encryptButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setBackground(new Color(45, 45, 45));

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void encrypt() {
        output.setText(new Encrypter().encrypt(input.getText()));
    }

    public void switchText() {
        input.setText(output.getText());
        output.setText("");
    }

//    private int characterIndex = 0;
//    private Timer timer;
//    public void prueba() {
//        String s = new Encrypter().encrypt(input.getText());
//
//        output.setText("");
//
//        characterIndex = 0;
//        timer = new Timer(60, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (characterIndex < s.length()) {
//                    output.append(Character.toString(s.charAt(characterIndex)));
//                    output.setCaretPosition(output.getDocument().getLength());
//                    characterIndex++;
//                } else {
//                    timer.stop();
//                }
//            }
//        });
//        timer.start();
//    }

    public void decrypt() {
        output.setText(new Encrypter().decrypt(input.getText()));
    }
}

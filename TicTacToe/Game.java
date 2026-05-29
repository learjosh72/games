import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JComponent implements Runnable {
    public int turn = 1;
    public JButton s1 = new JButton();
    public JButton s2 = new JButton();
    public JButton s3 = new JButton();
    public JButton s4 = new JButton();
    public JButton s5 = new JButton();
    public JButton s6 = new JButton();
    public JButton s7 = new JButton();
    public JButton s8 = new JButton();
    public JButton s9 = new JButton();
    public JButton[] s = new JButton[9];
    public JButton play = new JButton("Play");
    public JButton account = new JButton("Account");
    public JButton online = new JButton("Online");
    public JButton stats =new JButton("Stats");
    public JButton ranks = new JButton("Rankings");
    public JLabel label = new JLabel();
    public JPanel main = new JPanel(new BorderLayout());

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Tik Tak Toe");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        Panel one = new Panel();
        Panel two = new Panel();
        GridLayout gridLayout = new GridLayout(3,3);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        two.setBackground(Color.BLACK);
        two.setLayout(gridLayout);
        Color color = Color.decode("#a103fc");
        s1.setBackground(color);
        s2.setBackground(color);
        s3.setBackground(color);
        s4.setBackground(color);
        s5.setBackground(color);
        s6.setBackground(color);
        s7.setBackground(color);
        s8.setBackground(color);
        s9.setBackground(color);

        Font font = new Font("name", Font.BOLD, 100);

        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        s1.setFont(font);
        s1.setForeground(Color.WHITE);
        s2.setFont(font);
        s2.setForeground(Color.WHITE);
        s3.setFont(font);
        s3.setForeground(Color.WHITE);
        s4.setFont(font);
        s4.setForeground(Color.WHITE);
        s5.setFont(font);
        s5.setForeground(Color.WHITE);
        s6.setFont(font);
        s6.setForeground(Color.WHITE);
        s7.setFont(font);
        s7.setForeground(Color.WHITE);
        s8.setFont(font);
        s8.setForeground(Color.WHITE);
        s9.setFont(font);
        s9.setForeground(Color.WHITE);
        s1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s1.getText().equals("")) {

                    if (turn == 1) {
                        s1.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s1.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });
        s2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s2.getText().equals("")) {

                    if (turn == 1) {
                        s2.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s2.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s3.getText().equals("")) {

                    if (turn == 1) {
                        s3.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s3.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s4.getText().equals("")) {

                    if (turn == 1) {
                        s4.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s4.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s5.getText().equals("")) {

                    if (turn == 1) {
                        s5.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s5.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s6.getText().equals("")) {

                    if (turn == 1) {
                        s6.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s6.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s7.getText().equals("")) {
                    if (turn == 1) {
                        s7.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s7.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s8.getText().equals("")) {
                    if (turn == 1) {
                        s8.setText("X");
                        turn = 2;
                    } else if (turn == 2) {
                        s8.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {

                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });s9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s9.getText().equals("")) {
                    if (turn == 1) {
                        s9.setText("X");
                        turn = 2;
                    }
                    else if (turn == 2) {
                        s9.setText("O");
                        turn = 1;
                    }
                }
                if (s1.getText().equals("X")&s2.getText().equals("X")&s3.getText().equals("X") ||
                        s4.getText().equals("X")&s5.getText().equals("X")&s6.getText().equals("X") ||
                        s7.getText().equals("X")&s8.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s4.getText().equals("X")&s7.getText().equals("X") ||
                        s2.getText().equals("X")&s5.getText().equals("X")&s8.getText().equals("X") ||
                        s3.getText().equals("X")&s6.getText().equals("X")&s9.getText().equals("X") ||
                        s1.getText().equals("X")&s5.getText().equals("X")&s9.getText().equals("X") ||
                        s3.getText().equals("X")&s5.getText().equals("X")&s7.getText().equals("X")) {

                    JLabel win = new JLabel("Player 1 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (s1.getText().equals("O")&s2.getText().equals("O")&s3.getText().equals("O") ||
                        s4.getText().equals("O")&s5.getText().equals("O")&s6.getText().equals("O") ||
                        s7.getText().equals("O")&s8.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s4.getText().equals("O")&s7.getText().equals("O") ||
                        s2.getText().equals("O")&s5.getText().equals("O")&s8.getText().equals("O") ||
                        s3.getText().equals("O")&s6.getText().equals("O")&s9.getText().equals("O") ||
                        s1.getText().equals("O")&s5.getText().equals("O")&s9.getText().equals("O") ||
                        s3.getText().equals("O")&s5.getText().equals("O")&s7.getText().equals("O")) {


                    JLabel win = new JLabel("Player 2 Wins!");
                    Font font1 = new Font("name2", Font.BOLD, 50);
                    win.setFont(font1);
                    win.setForeground(Color.WHITE);
                    JPanel two1 = new JPanel();
                    two1.setLayout(new GridBagLayout());
                    two1.setBackground(Color.BLACK);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    two1.add(win, gbc);
                    content.remove(main);
                    content.add(two1, BorderLayout.CENTER);
                    content.repaint();
                    content.validate();
                }
                if (turn == 1) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 1's Turn!");
                    content.repaint();
                    content.validate();
                }
                if (turn == 2) {
                    label.setFont(new Font("bro", Font.BOLD, 50));
                    label.setText("Player 2's Turn!");
                    content.repaint();
                    content.validate();
                }
            }
        });
        two.add(s1);
        two.add(s2);
        two.add(s3);
        two.add(s4);
        two.add(s5);
        two.add(s6);
        two.add(s7);
        two.add(s8);
        two.add(s9);
        JPanel side = new JPanel(new BorderLayout());
        Color color1 = Color.decode("#b5a276");
        side.setBackground(color1);
        JPanel side1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Dimension d = new Dimension(100, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;
        play.setPreferredSize(d);
        play.setBackground(side.getBackground());
        side1.add(play, gbc);
        gbc.gridy++;
        online.setPreferredSize(d);
        online.setBackground(side.getBackground());
        side1.add(online, gbc);
        gbc.gridy++;
        stats.setPreferredSize(d);
        stats.setBackground(side.getBackground());
        side1.add(stats, gbc);
        gbc.gridy++;
        ranks.setPreferredSize(d);
        ranks.setBackground(side.getBackground());
        side1.add(ranks, gbc);
        side.add(side1, BorderLayout.NORTH);
        account.setPreferredSize(d);
        account.setBackground(side.getBackground());
        side.add(account, BorderLayout.SOUTH);


        main.add(label, BorderLayout.NORTH);
        main.add(two, BorderLayout.CENTER);

        if (turn == 1) {
            label.setFont(new Font("bro", Font.BOLD, 50));
            label.setText("Player 1's Turn!");
            content.repaint();
            content.validate();
        }
        if (turn == 2) {
            label.setFont(new Font("bro", Font.BOLD, 50));
            label.setText("Player 2's Turn!");
            content.repaint();
            content.validate();
        }

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.removeAll();
                s1.setText("");
                s2.setText("");
                s3.setText("");
                s4.setText("");
                s5.setText("");
                s6.setText("");
                s7.setText("");
                s8.setText("");
                s9.setText("");
                turn = 1;
                label.setText("Player 1's Turn!");
                content.add(main, BorderLayout.CENTER);
                content.add(side, BorderLayout.WEST);
                content.repaint();
                content.validate();
            }
        });


        content.add(main, BorderLayout.CENTER);
        content.add(side, BorderLayout.WEST);

    }

}

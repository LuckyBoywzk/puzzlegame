package com.itheima.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.Random;

public class LoginJFrame extends JFrame implements ActionListener, MouseListener {
    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("tom", "123"));
    }

    // 输入用户名的文本框
    JTextField user = new JTextField();
    // 输入密码的文本框
    JPasswordField passwd = new JPasswordField();
    // 输入校验码的文本框
    JTextField check = new JTextField();
    // 随机生成的验证码
    JLabel code = new JLabel(code());
    // 登录按钮
    JButton login = new JButton("登录");
    // 注册按钮
    JButton register = new JButton("注册");
    String s = "";
    int temp = 0;
    // 有关登录相关的代码可以写在这个里面
    public LoginJFrame() {
        // 加载登录界面
        initLoginJFrame();

        //加载页面内容
        initView();

        // 设置界面显示
        this.setVisible(true);

    }

    private void initView() {
        temp = 0;
        JLabel username = new JLabel("用户名");
        username.setBounds(120, 80, 100, 20);
        this.getContentPane().add(username);

        JLabel password = new JLabel("密码");
        password.setBounds(120, 135, 100, 20);
        this.getContentPane().add(password);

        JLabel checkCode = new JLabel("验证码");
        checkCode.setBounds(120, 190, 100, 20);
        this.getContentPane().add(checkCode);


        initCode();


        user.setBounds(170, 80, 200, 25);
        this.getContentPane().add(user);

        passwd.setBounds(170, 135, 200, 25);
        this.getContentPane().add(passwd);

        check.setBounds(170, 190, 100, 25);
        this.getContentPane().add(check);

        login.setBounds(120, 250, 100, 30);
        this.getContentPane().add(login);

        // 添加监听事件
        login.addActionListener(this);


        register.setBounds(280, 250, 100, 30);
        this.getContentPane().add(register);
        // 添加监听事件
        register.addActionListener(this);
        this.getContentPane().repaint();
    }

    private void initCode() {
        s = "";
        this.remove(code);
        this.getContentPane().repaint();
        code.setText(code());
        code.setBounds(280, 190, 100, 20);
        this.getContentPane().add(code);
        code.addMouseListener(this);
    }

    private void initLoginJFrame() {
        // 设置界面大小
        this.setSize(488, 350);
        // 设置界面标题
        this.setTitle("拼图 登录");
        // 设置位置居中
        this.setLocationRelativeTo(null);
        // 设置界面顶置
        this.setAlwaysOnTop(true);
        // 设置默认关闭方式
        this.setDefaultCloseOperation(3);
        // 设置默认居中方式
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            // 进行用户名和密码和校验码的校验
            String userText = user.getText();
            System.out.println(userText);
            String passwdTest =  passwd.getText();
            System.out.println(passwdTest);
            String checkText = check.getText();
            System.out.println(checkText);
            for (User user1 : list) {
                if (user1.getUser().equals(userText) && user1.getPassword().equals(passwdTest) && s.equals(checkText)) {
                    temp = 1;
                    break;
                }
            }
            if (temp == 1) {
                System.out.println("登录成功");
                new GameJFrame();
                this.setVisible(false);
            }
            else if (temp == 0){
                System.out.println("登录失败");
                JDialog error = new JDialog();
                error.setSize(200, 150);

                JLabel jLabel = new JLabel("你的输入有误！！！");
                jLabel.setForeground(Color.red);
                jLabel.setBounds(40, 20, 150, 60);
                error.getContentPane().add(jLabel);

                error.setAlwaysOnTop(true);
                error.setLocationRelativeTo(null);
                error.setModal(true);
                error.setLayout(null);
                error.setVisible(true);
            }
        }else if (obj == register){
            System.out.println("注册");
            JDialog reg = new JDialog();
            reg.setSize(200, 150);

            JLabel jLabel = new JLabel("此功能尚未开放");
            jLabel.setSize(50, 50);
            jLabel.setBounds(50, 20, 150, 60);
            reg.getContentPane().add(jLabel);

            reg.setAlwaysOnTop(true);
            reg.setLocationRelativeTo(null);
            reg.setModal(true);
            reg.setLayout(null);
            reg.setVisible(true);
        }
    }

    // 生成校验码
    public String code() {
        String rs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] c = rs.toCharArray();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(c.length);
            s += c[a];
        }
        return s;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
        initCode();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

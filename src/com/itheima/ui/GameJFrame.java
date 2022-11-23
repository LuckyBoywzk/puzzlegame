package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    Random r = new Random();
    int a = 0;
    // 创建JMenuItem对象
    JMenuItem replayGame = new JMenuItem("重新游戏");
    JMenuItem loginGame = new JMenuItem("重新登录");
    JMenuItem close = new JMenuItem("关闭游戏");
    JMenuItem people = new JMenuItem("开发人员");
    JMenuItem dongman = new JMenuItem("动漫");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem view = new JMenuItem("风景");
    int[][] data = new int[4][4];

    int x;
    int y;
    String path = "puzzlegame\\image\\dongman\\dongman";
    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    int step;
    // 有关游戏的代码都可以写在这个里面
    public GameJFrame() {
        // 初始化界面
        initJFrame();

        // 初始化菜单
        initMenu();

        // 初始化数据
        initData();

        // 初始化图像
        initImage();


        // 设置界面显示
        this.setVisible(true);
    }

    // 初始化数据
    private void initData() {
        int[] tempArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 打乱数组
        Random r = new Random();
        int temp;
        for (int i = 0; i < tempArr.length; i++) {
            int a = r.nextInt(16);
            temp = tempArr[a];
            tempArr[a] = tempArr[i];
            tempArr[i] = temp;
        }

        System.out.println();
        // 把打乱的一维数组放到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }

        // 获取索引0的位置
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] == 0){
                    x = i;
                    y = j;
                }
            }
        }
    }

    // 初始化图片
    private void initImage() {
        // 删除原理的所有照片
        this.getContentPane().removeAll();

        // 显示步数
        JLabel accountStep = new JLabel("步数:" + step);
        accountStep.setBounds(50, 3, 100, 50);
        this.getContentPane().add(accountStep);

        // 加载胜利图片
        if (victory()) {
            JLabel win = new JLabel(new ImageIcon("puzzlegame\\image\\win.jpg"));
            win.setBounds(193, 245, 200, 200);
            this.getContentPane().add(win);
        }
        // 注意：先加载的图片显示在上面，后加载的显示在下面
        // 外循环
        for (int j = 0; j < 4; j++) {
            // 内循环
            for (int i = 0; i < 4; i++) {
                int num = data[j][i];
                // 获取ImageIcon对象
                ImageIcon icon = new ImageIcon(path + a + "\\" + num + ".jpg");
                // 将图片添加到JLabel管理容器
                JLabel jLabel = new JLabel(icon);
                // 设置容器的位置
                jLabel.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                // 把容器添加到界面中去
                // 添加边框
                jLabel.setBorder(new BevelBorder(1));
                this.getContentPane().add(jLabel);
            }
        }

        //加载背景图
        // 获取JLabel对象容器
        JLabel background = new JLabel(new ImageIcon("puzzlegame\\image\\background.jpg"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        // 刷新
        this.getContentPane().repaint();
    }

    // 初始化菜单
    private void initMenu() {
        // 设置菜单功能
        // 创建JMenubar对象
        JMenuBar menuBar = new JMenuBar();
        // 创建JMenu对象
        JMenu function = new JMenu("功能");
        JMenu about = new JMenu("关于");
        JMenu change = new JMenu("切换图片");

        // 将条目添加到菜单中
        function.add(change);
        change.add(dongman);
        change.add(girl);
        change.add(view);

        function.add(replayGame);
        function.add(loginGame);
        function.add(close);
        about.add(people);


        // 将功能添加到JMenuBar对象中
        menuBar.add(function);
        menuBar.add(about);

        // 为菜单添加监听事件
        dongman.addActionListener(this);
        girl.addActionListener(this);
        view.addActionListener(this);

        replayGame.addActionListener(this);
        loginGame.addActionListener(this);
        close.addActionListener(this);
        people.addActionListener(this);

        // 将整个菜单添加到界面中
        this.setJMenuBar(menuBar);
    }

    // 初始化界面
    private void initJFrame() {
        // 设置界面大小
        this.setSize(603, 680);
        // 设置界面标题
        this.setTitle("拼图单机版 v1.0");
        // 设置位置居中
        this.setLocationRelativeTo(null);
        // 设置界面顶置
        this.setAlwaysOnTop(true);
        // 设置默认关闭方式
        this.setDefaultCloseOperation(3);
        // 设置取消界面默认居中样式
        this.setLayout(null);


        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 长按不松执行的代码
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            System.out.println("查看原图");
            // 删除全部图片
            this.getContentPane().removeAll();
            // 创建JLabel对象
            JLabel all = new JLabel(new ImageIcon(path + a + "\\all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            //加载背景图
            // 获取JLabel对象容器
            JLabel background = new JLabel(new ImageIcon("puzzlegame\\image\\background.jpg"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            // 刷新
            this.getContentPane().repaint();
        }
    }

    // 松开键盘执行的代码
    @Override
    public void keyReleased(KeyEvent e) {
        // 获取按键的值
        int code = e.getKeyCode();

        // 如果胜利，不能继续移动
        if (victory()) {
            return;
        }

        if (code == 37) {
            System.out.println("向左移动");
            if (y == 3) {
                return;
            }
            // 将方块右面的图片与方块交换
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            // 重新加载图片
            initImage();
        }else if (code == 38) {
            System.out.println("向上移动");
            if (x == 3) {
                return;
            }
            // 将方块下面的图片与方块交换
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            // 重新加载图片
            initImage();
        }else if (code == 39) {
            System.out.println("向右移动");
            if (y == 0) {
                return;
            }
            // 将方块左面的图片与方块交换
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;

            // 重新加载图片
            initImage();
        }else if (code == 40) {
            System.out.println("向下移动");
            if (x == 0) {
                return;
            }
            // 将方块上面的图片与方块交换
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            // 重新加载图片
            initImage();
        }else if (code == 65) {
            // 加载原来的图片
            initImage();
        }else if (code == 87) {
            // 作弊代码，直接完成原图
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            // 初始化图片
            initImage();
        }
    }

    // 判断是否胜利
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayGame) {
            System.out.println("重新游戏");
            // 步数清零
            step = 0;
            // 初始化数据
            initData();
            // 初始化图片
            initImage();

        }else if (obj == loginGame) {
            System.out.println("重新登录");
            new LoginJFrame();
            this.setVisible(false);
        }else if (obj == close) {
            System.out.println("关闭游戏");
            System.exit(0);
        }else if (obj == people) {
            System.out.println("开发人员");
            // 创建弹窗对象
            JDialog dialog = new JDialog();
            // 设置弹窗大小
            dialog.setSize(344, 344);
            // 创建JLabel对象
            JLabel wechat = new JLabel(new ImageIcon("puzzlegame\\image\\me.jpg"));
            // 设置图片位置
            wechat.setBounds(0, 0, 258, 258);
            // 设置顶置
            dialog.setAlwaysOnTop(true);
            // 设置居中
            dialog.setLocationRelativeTo(null);
            // 在弹窗中显示图片
            dialog.getContentPane().add(wechat);
            // 弹窗无法关闭
            dialog.setModal(true);
            // 设置弹窗显示
            dialog.setVisible(true);

        }else if (obj == dongman) {
            System.out.println("动漫");
            a = r.nextInt(10);
            System.out.println("加载第" + a + "个图片");
            // 切换动漫图片的路径
            path = "puzzlegame\\image\\dongman\\dongman";
            // 步数清零
            step = 0;
            // 初始化数据
            initData();
            // 初始化图片
            initImage();
        }else if (obj == girl) {
            System.out.println("美女");
            a = r.nextInt(5);
            System.out.println("加载第" + a + "个图片");
            // 切换图片的路径
            path = "puzzlegame\\image\\gril\\gril";
            // 步数清零
            step = 0;
            // 初始化数据
            initData();
            // 初始化图片
            initImage();
        }else if (obj == view) {
            System.out.println("风景");
            a = r.nextInt(4);
            System.out.println("加载第" + a + "个图片");
            // 切换图片的路径
            path = "puzzlegame\\image\\view\\view";
            // 步数清零
            step = 0;
            // 初始化数据
            initData();
            // 初始化图片
            initImage();
        }
    }
}

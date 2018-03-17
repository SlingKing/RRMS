/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import tool.*;
import java.util.*;
/**
 *管理界面
 * @author Administrator
 */
public class Windows1 extends JFrame implements ActionListener,MouseListener{
    
    static int count=0;
    Image image;
    //定义组件
    JMenuBar jmb1;
    JMenu jm1,jm2,jm3,jm4,jm5,jm6;
    JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5;
    //工具栏
    JToolBar jtb;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
    //面板
    JPanel jp1,jp2,jp3,jp4,jp5;
    //显示当前时间-jb8
    JLabel time;
    //给jp1定义需要的Label
    JLabel jp1_jlb1,jp1_jlb2,jp1_jlb3,jp1_jlb4,jp1_jlb5,jp1_jlb6;
    ////给jp2定义需要的Label
    JLabel jp2_jlb1,jp2_jlb2;
    //javax.swing包中的Timer类可以定时的触发Action事件
    javax.swing.Timer t;
    Image timeGg;Image jp1_G;
    ImagePanel jp1_imagePanel;
    JSplitPane jsp1;
    CardLayout p3;
    Cursor myCursor = new Cursor(Cursor.HAND_CURSOR);
    
    public void initmenu(){
         //创建一级菜单
        jm1 = new JMenu("登录管理");
        jm1.setFont(Mytools.f1);
        //创建其二级菜单及其图标
        ImageIcon jmi1_Icon = new ImageIcon("Image/qhyh.jpg");
        ImageIcon jmi2_Icon = new ImageIcon("Image/qhsy.jpg");
        ImageIcon jmi3_Icon = new ImageIcon("Image/p1_dlgl.jpg");
        ImageIcon jmi4_Icon = new ImageIcon("Image/p1_rsgl.jpg");
        ImageIcon jmi5_Icon = new ImageIcon("Image/exit.jpg");
        jmi1= new JMenuItem("切换用户",jmi1_Icon);
        jmi1.setFont(Mytools.f2);
        jmi2= new JMenuItem("用户信息",jmi2_Icon);
        jmi2.setFont(Mytools.f2);
        jmi3= new JMenuItem("退出",jmi5_Icon);
        jmi3.setFont(Mytools.f2);
        //加入
        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
        jm2 = new JMenu("规章管理");
        jm2.setFont(Mytools.f1);
        jm3 = new JMenu("规章查询");
        jm3.setFont(Mytools.f1);
        jm4 = new JMenu("人事管理");
        jm4.setFont(Mytools.f1);
        jm5 = new JMenu("帮助");
        jm5.setFont(Mytools.f1);
        //把一级菜单加入JMenuBar
        jmb1=new JMenuBar();
        jmb1.add(jm1);
        jmb1.add(jm2);
        jmb1.add(jm3);
        jmb1.add(jm4);
        jmb1.add(jm5);
        this.setJMenuBar(jmb1);
    }
    
    public void inittoolsbar(){
        //处理工具栏
        jtb= new JToolBar();
        jb1= new JButton (new ImageIcon("image/jt1.jpg"));
        jb2= new JButton (new ImageIcon("image/jt2.jpg"));
        jb3= new JButton (new ImageIcon("image/jt3.jpg"));
        jb4= new JButton (new ImageIcon("image/jt4.jpg"));
        jb5= new JButton (new ImageIcon("image/jt5.jpg"));
        jb6= new JButton (new ImageIcon("image/jt6.jpg"));
        jb7= new JButton (new ImageIcon("image/jt7.jpg"));
        jb8= new JButton (new ImageIcon("image/jt8.jpg"));
        jb9= new JButton (new ImageIcon("image/jt9.jpg"));
        jb10= new JButton (new ImageIcon("image/jt10.jpg"));
        jtb.add(jb1);
        jtb.add(jb2);
        jtb.add(jb3);
        jtb.add(jb4);
        jtb.add(jb5);
        jtb.add(jb6);
        jtb.add(jb7);
        jtb.add(jb8);
        jtb.add(jb9);
        jtb.add(jb10);
    }

    public void initjp1(){
        jp1=new JPanel(new BorderLayout());
        try {
            jp1_G =ImageIO.read(new File("image/p1.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Windows1.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jp1_imagePanel=new ImagePanel(jp1_G);
        this.jp1_imagePanel.setLayout(new GridLayout(8,1));
        jp1_imagePanel.add(jp1_jlb1=new JLabel("某铁路局",new ImageIcon(""),0));
        jp1_imagePanel.add(jp1_jlb2=new JLabel("人事管理",new ImageIcon("image/p1_rsgl.jpg"),0));
        jp1_jlb2.setEnabled(false);
        jp1_jlb2.addMouseListener(this);
        jp1_jlb2.setCursor(myCursor);
        jp1_imagePanel.add(jp1_jlb3=new JLabel("登陆管理",new ImageIcon("image/p1_dlgl.jpg"),0));
        jp1_jlb3.setEnabled(false);
        jp1_jlb3.addMouseListener(this);
        jp1_jlb3.setCursor(myCursor);
        jp1_imagePanel.add(jp1_jlb4=new JLabel("规章管理",new ImageIcon("image/p1_cb.jpg"),0));
        jp1_jlb4.setEnabled(false);
        jp1_jlb4.addMouseListener(this);
        jp1_jlb4.setCursor(myCursor);
        jp1_imagePanel.add(jp1_jlb5=new JLabel("规章查询",new ImageIcon("image/p1_bbtj.jpg"),0));
        jp1_jlb5.setEnabled(false);
        jp1_jlb5.addMouseListener(this);
        jp1_jlb5.setCursor(myCursor);
        jp1_imagePanel.add(jp1_jlb6=new JLabel("退出系统",new ImageIcon("image/p1_xtsz.jpg"),0));
        jp1_jlb6.setEnabled(false);
        jp1_jlb6.addMouseListener(this);
        jp1_jlb6.setCursor(myCursor);
   /*   jp1_imagePanel.add(jp1_jlb7=new JLabel("动画演示",new ImageIcon("image/p1_dhbz.jpg"),0));
        jp1_jlb7.setEnabled(false);
        jp1_jlb7.addMouseListener(this);
        jp1_jlb7.setCursor(myCursor);  */
        jp1.add(jp1_imagePanel);
    }
    
    public void initjp234(){
        //处理jp2,jp3,jp4
        jp4=new JPanel(new BorderLayout());
        jp2=new JPanel(new CardLayout());
        jp2_jlb1=new JLabel(new ImageIcon("image/p2_zuo.jpg"),0);
        jp2_jlb2=new JLabel(new ImageIcon("image/p2_you.jpg"),0);
        jp2.add(this.jp2_jlb1, "0");
        jp2.add(this.jp2_jlb2, "1");
       //先给jp3加入一个主界面的卡片（ImagePanel)
        Image zhu_image=null;
        try {
            zhu_image=ImageIO.read(new File("image/p3_bj.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Windows1.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.p3= new CardLayout();
        jp3=new JPanel(p3);
        ImagePanel ip=new ImagePanel(zhu_image);
        jp3.add(ip,"0");
        //对jp3添加几个JPanel
        EmpInfo einfo=new  EmpInfo();
        jp3.add(einfo,"1");
        LoginManage lm=new LoginManage();
        jp3.add(lm,"2");
        RegulationManage rm=new RegulationManage();
        jp3.add(rm,"3");
        //把jp2,jp3加入到jp4
        jp4.add(jp2,"West");
        jp4.add(jp3,"Center");
        //做一个拆分窗口，分别存jp1，jp4
        jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
        //制定左边的面板多大
        jsp1.setDividerLocation(120);
        jsp1.setDividerSize(0);
    }
    
    public void initjp5(){
        //处理第五个面板
        time=new JLabel ("当前时间: "+Calendar.getInstance().getTime().toLocaleString()+"   ");
        jp5= new JPanel(new BorderLayout());
        t = new javax.swing.Timer(1000,this);
        t.start();
        try {
            timeGg=ImageIO.read(new File("image/bj.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Windows1.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImagePanel ip1=new ImagePanel(timeGg);
        ip1.setLayout(new BorderLayout());
        ip1.add(time,"East");
        jp5.add(ip1);
    }
    
    public Windows1() {
        //设置窗口大小
        int w=Toolkit.getDefaultToolkit().getScreenSize().width;
        int h=Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(w,h-50);
        //窗口标题
        this.setTitle("铁路规章系统");
        //关闭窗口时，退出系统
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
                image=ImageIO.read(new File("image/index1.jpg"));// 获得图标图片
            } catch (IOException ex) {
                Logger.getLogger(paint.class.getName()).log(Level.SEVERE, null, ex);
            }
        //this.setIconImage(image);
        //调用initmenu函数
        this.initmenu();
        //调用inittoolsbar函数
        this.inittoolsbar(); 
        //调用initjp1函数
        this.initjp1();
        //调用initjp234();
        this.initjp234();
        //调用initjp5();
        this.initjp5();        
        //获得Container
        Container ct=this.getContentPane();
        ct.add(jtb,"North");
        ct.add(jsp1,"Center");
        ct.add(jp5,"South");
        this.setVisible(true);
        count++;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.time.setText("当前时间: "+Calendar.getInstance().getTime().toLocaleString()+"   ");
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==this.jp1_jlb2 ){
            this.p3.show(jp3, "1");
        }else if(e.getSource()==this.jp1_jlb3 ){
            this.p3.show(jp3, "2");
        }else if(e.getSource()==this.jp1_jlb4){
        	this.p3.show(jp3, "3");
        }else if(e.getSource()==this.jp1_jlb6){
        	this.dispose();
		    System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==this.jp1_jlb2){
            this.jp1_jlb2.setEnabled(true);
        }else if(e.getSource()==this.jp1_jlb3)  {
            this.jp1_jlb3.setEnabled(true);
        }else if(e.getSource()==this.jp1_jlb4)  {
            this.jp1_jlb4.setEnabled(true);
        }else if(e.getSource()==this.jp1_jlb5)  {
            this.jp1_jlb5.setEnabled(true);
        }else if(e.getSource()==this.jp1_jlb6)  {
            this.jp1_jlb6.setEnabled(true);
        }      
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this.jp1_jlb2){
            this.jp1_jlb2.setEnabled(false);
        }else if (e.getSource()==this.jp1_jlb3){
            this.jp1_jlb3.setEnabled(false);
        }else if (e.getSource()==this.jp1_jlb4){
            this.jp1_jlb4.setEnabled(false);
        }else if (e.getSource()==this.jp1_jlb5){
            this.jp1_jlb5.setEnabled(false);
        }else if (e.getSource()==this.jp1_jlb6){
            this.jp1_jlb6.setEnabled(false);
        }
    }
}

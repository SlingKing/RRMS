/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.UserModel;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Administrator
 */
public class UserLogin extends JDialog implements ActionListener{
    JLabel jl1,jl2;
    JButton jb1,jb2;//确定按钮
    JTextField jtf1;
    JPasswordField jpw;
    Font f1 =new Font("宋体",Font.PLAIN,16);
    static Vector<Windows1> wv=new Vector<Windows1>();

    public UserLogin()
    {   Container ct=this.getContentPane();
        this.setLayout(null);
        //定义组件
        jl1=new JLabel("请输入用户名");
        jl1.setFont(f1);
        jl1.setBounds(60, 190, 150, 30);
        ct.add(jl1); 
        
        jb1=new JButton("确定");
        jb1.setFont(f1);
        jb1.setBounds(110, 300, 70, 30);
        ct.add(jb1);
        jb1.addActionListener(this);
        
        jb2=new JButton("取消");
        jb2.setFont(f1);
        jb2.setBounds(200, 300, 70, 30);
        ct.add(jb2);
        jb2.addActionListener(this);
        
        jtf1=new JTextField();
        jtf1.setFont(f1);
        jtf1.setBounds(170, 190, 150, 30);
        ct.add(jtf1);
        
        jl2=new JLabel("请输入密码");
        jl2.setFont(f1);
        jl2.setBounds(60, 240, 150, 30);
        ct.add(jl2); 
        
        jpw = new JPasswordField(30);
        jpw.setBounds(170,240,150,30);
        ct.add(jpw);
        
        this.setLocationRelativeTo(this);
        BackImage bi=new BackImage();
        bi.setBounds(0, 0, 360, 360);
        this.add(bi);
        this.setUndecorated(true);
        this.setSize(360,360);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    class BackImage extends JPanel
    {
        Image im;

        public BackImage() 
        {
            try {
                im=ImageIO.read(new File("image/login.gif"));
            } catch (IOException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void paintComponent(Graphics g){
            g.drawImage(im, 0, 0,360,360,this);
        }
        
    }
    
    //响应用户登录的请求
    public void actionPerformed(ActionEvent e)
    {   
        if(e.getSource()==jb1){
	        //取出员工号，密码
	        String u=this.jtf1.getText().trim();
	        String p=new String(this.jpw.getPassword());
	        UserModel um=new UserModel();
	        String res=um.checkUser(u,p);
	        if(res!=null){            
                wv.add(new Windows1());
                if(Windows1.count>=2){
                    wv.get((Windows1.count-2)).dispose();
                    System.out.println(Windows1.count);
            }
	        this.dispose();
	        }else{
		        JOptionPane.showMessageDialog(this, "用户名或密码错误", "登录提示", JOptionPane.ERROR_MESSAGE);
		    return;
		    } 
	    }
	    else if(e.getSource()==jb2){
		    this.dispose();
		    System.exit(0);
	    }  
    }
}
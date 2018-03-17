/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.UserModel;

/**
 *
 * @author Administrator
 */
public class LoginManage extends JPanel implements ActionListener{
    
    JButton jb1,jb2;
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
    
    public LoginManage(){
 
        Container ct = new Container();  
        ct.setLayout(new GridLayout(5,2,20,40));
        
        UserModel um=new UserModel();
        
        jlb1=new JLabel("当前用户编号");
        jlb1.setSize(30,40);
        ct.add(this.jlb1);
        
        jlb2=new JLabel(um.getWorkerId());
        jlb2.setSize(30,40);
        ct.add(this.jlb2);
        
        jlb3=new JLabel("当前用户姓名");
        jlb3.setSize(30,40);
        ct.add(this.jlb3);
        
        jlb4=new JLabel(um.getWorkerName());
        jlb4.setSize(30,40);
        ct.add(this.jlb4);
        
        jlb5=new JLabel("当前用户权限");
        jlb5.setSize(30,40);
        ct.add(this.jlb5);
        
        jlb6=new JLabel(um.getworkerLevel());
        jlb6.setSize(30,40);
        ct.add(this.jlb6);
        
        
        jb1=new JButton("切换用户");
        ct.add(this.jb1);
        jb1.addActionListener(this);
        
        jb2=new JButton("修改密码");
        ct.add(this.jb2);
        jb2.addActionListener(this);
        
        this.add(ct);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jb1){
            new UserLogin();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.EmpModel;

/**
 *
 * @author Administrator
 */
public class AddWorker extends JFrame implements ActionListener {
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5;
    JTextField jtf1,jtf3,jtf4,jtf5;
    JPasswordField jpw;
    JButton jb1,jb2;
    String workerId,workerPW,workerZW,workerName,workerLevel;
    public AddWorker(){
        this.setLayout(new GridLayout(6,2));
        
        jlb1 =new JLabel("                    员工号");
        jlb1.setSize(50, 40);
        this.add(jlb1);
        jtf1=new JTextField(10);
        jtf1.setSize(150, 40);
        this.add(jtf1);
        
        jlb2 =new JLabel("                    密码");
        jlb2.setSize(50, 40);
        this.add(jlb2);
        jpw=new JPasswordField();
        this.add(jpw);
        
        jlb3 =new JLabel("                    职位");
        jlb3.setSize(50, 40);
        this.add(jlb3);
        jtf3=new JTextField(10);
        this.add(jtf3);
        
        jlb4 =new JLabel("                    姓名");
        jlb4.setSize(50, 40);
        this.add(jlb4);
        jtf4=new JTextField(10);
        this.add(jtf4);
        
        jlb5=new JLabel("                     级别");
        jlb5.setSize(50, 40);
        this.add(jlb5);
        jtf5=new JTextField(10);
        this.add(jtf5);
        
        jb1=new JButton("确定");
        this.add(jb1);
        jb1.addActionListener(this);
        jb2=new JButton("取消");
        this.add(jb2);
        jb2.addActionListener(this);
        
        this.setTitle("增加新员工");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb1)
        {
	//取出员工号，密码及其他信息
	    workerId=this.jtf1.getText().trim();
	    workerPW=new String(this.jpw.getPassword());
            workerZW=this.jtf3.getText().trim();
            workerName=this.jtf4.getText().trim();
            workerLevel=this.jtf5.getText().trim();
            EmpModel em=new EmpModel();
            if(em.addEmpById(workerId, workerPW,workerName,workerZW,workerLevel))
            {
                JOptionPane.showMessageDialog(null, "添加数据成功数据成功","添加提示",JOptionPane.INFORMATION_MESSAGE);
            }else 
            {
                JOptionPane.showMessageDialog(null, "添加数据成功数据失败","添加提示",JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }else if(e.getSource()==jb2){
		this.dispose();		
	}
    }


}

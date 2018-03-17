/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 用于显示人事管理
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.EmpModel;
import tool.Mytools;
/**
 *
 * @author Administrator
 */
public class EmpInfo extends JPanel implements ActionListener{
    //定义需要的组件
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jp1_jlb1,jp3_jlb1;
    JTextField jp1_jtf1,jp2_jtf;
    JButton jp1_jb1,jp2_jb;
    private final JButton jp4_jb1;
    private final JButton jp4_jb2;
    private final JButton jp4_jb3;
    private final JButton jp4_jb4;
    JButton jp4_jb5;
    JScrollPane jsp;
    //定义信息表
    JTable jtb;
    EmpModel em= new EmpModel();
    public EmpInfo(){
        //创建需要的组件
        jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp1_jlb1=new JLabel("请输入姓名（员工号或职位)");
        jp1_jlb1.setFont(Mytools.f2);
        jp1_jtf1=new JTextField(20);
        jp1_jb1=new JButton("查询");
        jp1_jb1.setFont(Mytools.f1);
        jp1_jb1.addActionListener(this);
        jp1.add(this.jp1_jlb1);
        jp1.add(this.jp1_jtf1);
        jp1.add(this.jp1_jb1);
        //处理中间
        String []paras={"1"};
        em.query("select workerId '员工号',workerName '姓名',workerLevel '级别',workerZW '职位' from worker where  1=? ", paras);
        jtb= new JTable(em);
        jp2= new JPanel();
        jsp=new JScrollPane();
        jsp=new JScrollPane(this.jtb);
        jp2.add(this.jsp);
        //处理南面
        jp3= new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp3_jlb1=new JLabel("总记录条数");
        this.jp3_jlb1.setFont(Mytools.f2);
        jp3.add(this.jp3_jlb1);
        jp4= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jp4_jb1=new JButton("更新");
        this.jp4_jb1.setFont(Mytools.f2);
        jp4_jb1.addActionListener(this);
        jp4_jb2=new JButton("添加");
        this.jp4_jb2.setFont(Mytools.f2);
        jp4_jb2.addActionListener(this);
        jp4_jb3 = new JButton("修改");
        jp4_jb3.addActionListener(this);
        this.jp4_jb3.setFont(Mytools.f2);
        jp4_jb4=new JButton("删除");
        this.jp4_jb4.setFont(Mytools.f2);
        jp4_jb4.addActionListener(this);
        jp4.add(this.jp4_jb1);
        jp4.add(this.jp4_jb2);
        jp4.add(this.jp4_jb3);
        jp4.add(this.jp4_jb4);
        jp5= new JPanel(new BorderLayout());
        jp5.add(this.jp3,"West");
        jp5.add(this.jp4,"East");
        //把jp1,2,3,4,5加入总面板中
        this.setLayout(new BorderLayout());
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp5,"South");
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jp1_jb1)
        {

        }else if (e.getSource()==this.jp4_jb1)
        {
            //更新显示一下
	    em=new EmpModel();
	    String []paras={"1"};
	    em.query("select workerId'员工号',workerName'姓名',workerLevel'级别',workerZW'职位' from worker where 1=?", paras);
	    jtb.setModel(em); 
        }else if (e.getSource()==this.jp4_jb2)
        {
            new AddWorker();   
        }else if (e.getSource()==this.jp4_jb3)
        {
            int selRowNum=jtb.getSelectedRow();//选中的行
            int selColumNum=jtb.getSelectedColumn();//选中的列
            if(selRowNum!=1&&selColumNum!=1){
				JOptionPane.showMessageDialog(null, "请选中要修改的数据","修改提示",JOptionPane.INFORMATION_MESSAGE);
			}
            else{
                jp2_jtf=new JTextField(10);
                jp2.add(jp2_jtf,"South");
                jp2_jb=new JButton("确定");
                jp2_jb.addActionListener(this);
                jp2.add(jp2_jb,"South");
            }  
        }else if(e.getSource()==this.jp4_jb4)
        {
            int selRowNum=jtb.getSelectedRow();//选中的行
			if(selRowNum!=1){
				JOptionPane.showMessageDialog(null, "请选中要删除的数据","删除提示",JOptionPane.INFORMATION_MESSAGE);
			}
			String empNo=(String)em.getValueAt(selRowNum, 0);
			if(em.delEmpById(empNo)){
				JOptionPane.showMessageDialog(null, "删除数据成功","删除提示",JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "删除数据失败","删除提示",JOptionPane.ERROR_MESSAGE);
			}    

        } else if(e.getSource()==this.jp2_jb){
            int selRowNum=jtb.getSelectedRow();//选中的行
            int selColumNum=jtb.getSelectedColumn();//选中的列
            String temp=(String)em.getValueAt(selRowNum, 0);
            String name=em.getColumnName(selColumNum);
            System.out.println(name);
            if (name.equals("员工号"))
            {  
                name="workerId";
            }else if (name.equals("姓名"))
            {
                name="workerName";
            }else if (name.equals("职位"))
            {
                name="workerZW";
            }else if (name.equals("级别"))
            {
                name="workerLevel";
            }
            System.out.println(name);
            String aim=jp2_jtf.getText().trim();
            System.out.println(aim);
            System.out.println(temp);
            if(em.updata(name,aim,temp)){
				JOptionPane.showMessageDialog(null, "修改数据成功","修改提示",JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "修改数据失败","删除提示",JOptionPane.ERROR_MESSAGE);
			}  
        }
    }   
    
}

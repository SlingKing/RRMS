package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RegulationManage extends JPanel implements ActionListener{
    
	JButton jb1,jb2,jb3,jb4;
	public RegulationManage(){
		
        Container ct = new Container();  
        ct.setLayout(new GridLayout(4,1,50,40));
		
		jb1=new JButton("录入规章");
		jb1.setSize(50 , 40);
		ct.add(this.jb1);
        jb1.addActionListener(this);
        
        jb2=new JButton("删除规章");
		jb2.setSize(50 , 40);
		ct.add(this.jb2);
        jb2.addActionListener(this);
        
        jb3=new JButton("修改规章");
		jb3.setSize(50 , 40);
		ct.add(this.jb3);
        jb3.addActionListener(this);
        
        jb4=new JButton("查询规章");
		jb4.setSize(50 , 40);
		ct.add(this.jb4);
        jb4.addActionListener(this);
        
        this.add(ct);
        this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			
		}else if(e.getSource()==jb2){
			
		}else if(e.getSource()==jb3){
			
		}else if(e.getSource()==jb4){
			
		}
		
	}
	
    
	
}

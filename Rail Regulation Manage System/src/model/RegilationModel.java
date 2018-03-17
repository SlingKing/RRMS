package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.SqlHelper;

public class RegilationModel {
    Vector colums;
    Vector rows;
    //用于删除规章
    public boolean  delRlById(String Id){
                boolean b=false;
		String sql="delete from regulation where Id=?";
		String []paras={Id};
		SqlHelper sh=new SqlHelper();
		try {
                    b=sh.exeUpdata(sql, paras);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sh.close();
		}
                return b;
	}
    //用于增加规章
    public boolean  addEmpById(String ID,String title,
            String kind,String num,String time,String url){
                boolean b=false;
		String sql="insert into regulation values(?,?,?,?,?,?)";
		String []paras={ID,title,kind,num,time,url};
		SqlHelper sh=new SqlHelper();
		try {
		        b=sh.exeUpdata(sql, paras);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sh.close();
		}
                return b;
	}
    //用于修改规章信息
    public boolean  updata(String name,String aim,String temp){
                boolean b=false;
		String sql="update regulation set "+ name +"= ? where Id =?";
		String []paras={aim,temp};
		SqlHelper sh=new SqlHelper();
		try {
                    b=sh.exeUpdata(sql, paras);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sh.close();
		}
                return b;
    }
    //用于查询需要的浏览的规章信息
    public void query(String sql,String paras[]){
        //初始化列
        this.colums=new Vector<String>();
        this.rows=new Vector<Vector>();
      
        //创建SqlHelper对象
        SqlHelper sh=new SqlHelper();
        
        ResultSet rs=sh.query(sql, paras);
        
        try{
            //从rs对象中可以得到一个ResultSetMetaData
            //rsmt可以得到结果有多少列，而且可以知道每列的名字
	    ResultSetMetaData rsmt=rs.getMetaData();
	    for(int i=0;i<rsmt.getColumnCount();i++){
		colums.add(rsmt.getColumnName(i+1));
	    }
            while (rs.next()){
                Vector<String> temp=new Vector<String>();
                for(int i=0;i<rsmt.getColumnCount();i++){
					temp.add(rs.getString(i+1));
				}
                rows.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            sh.close();
        }
    }
    
    
    public String getColumnName(int column) {
		return this.colums.get(column).toString();
    }

    
    
    public int getRowCount() {
        return this.rows.size();
    }

    
    public int getColumnCount() {
       return this.colums.size();
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector)rows.get(rowIndex)).get(columnIndex);
    }
}

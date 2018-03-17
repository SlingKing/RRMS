package db;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class SqlHelper {
    PreparedStatement ps=null;
    Connection ct=null;
    ResultSet  rs=null;

    public SqlHelper()
    {
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                             
                ct=DriverManager.getConnection("jdbc:sqlserver://219.217.155.159:1433;databaseName=RRMS;user=sa;password=leng7666352");
            }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet query(String sql,String [] paras)
    {
        try{
            ps=ct.prepareStatement(sql);
            for(int i=0;i<paras.length;i++)
            {
                ps.setString(i+1, paras[i]);
            }
            rs=ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    //把对数据库的增、删、改写一个函数
	public boolean exeUpdata(String sql,String []paras){
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			//执行
			ps.executeUpdate();
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		
		return b;
	}
    
    public void close()
    {
        try{
            if(rs!=null)
                rs.close();
            if(ps!=null)
                ps.close();
            if(ct!=null)
                ct.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 这是用户表数据模型，用它完成对用户的各种操作
 * [这里主要是编写项目需要的业务操作]
 */
package model;

import db.SqlHelper;
import java.sql.ResultSet;

public class UserModel {
	/**
	 * 
	 * @param workerId 用户编号
	 * @param workerPW 用户密码
	 * @return 该用户的职位,如果该用户不存在，则返回""
	 */
    public static String workerId,workerPW,workerLevel,workerName;
	public String checkUser(String workerId,String workerPW){
                this.workerId=workerId;
                this.workerPW=workerPW;
		SqlHelper sp=null;
		try {
			//组织sql语句和参数列表
			String sql="select w.workerLevel ,w.workerName from worker w where w.workerId=? and w.workerPW=?";
			String paras[]={this.workerId,this.workerPW};
			sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			if(rs.next()){
				//取出职位zhiwei
				this.workerLevel=rs.getString(1);
                this.workerName=rs.getString(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sp.close();
		}
		
		return this.workerLevel;
	}

    public String getWorkerId() {
        return workerId;
    }

    public String getWorkerPW() {
        return workerPW;
    }

    public String getworkerLevel() {
        return workerLevel;
    }

    public String getWorkerName() {
        return workerName;
    }
        
}


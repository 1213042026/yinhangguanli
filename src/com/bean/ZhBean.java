package com.bean;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.util.Constant;
import com.util.DBO;

public class ZhBean {
	private List list;
	private ResultSet rs;
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////���� �޸� ɾ�� ��ѯ
	//����
	public int addZH(String type,String pwd,String name,String sex,String bir,String sfz,String address,String remark){
		String sql = "insert into zh (type,pwd,name,sex,bir,sfz,address,remark,flag,addtime)" +
				" values('"+type+"','"+pwd+"','"+name+"','"+sex+"','"+bir+"','"+sfz+"','"+address+"','"+remark+"','����','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// �޸�
	public int upZH(String id,String type,String pwd,String name,String sex,String bir,String sfz,String address,String remark){
		String sql = "update zh set type='"+type+"',pwd='"+pwd+"',name='"+name+"',sex='"+sex+"',bir='"+bir+"',sfz='"+sfz+"',address='"+address+"',remark='"+remark+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
//	 ��ʧ
	public int closeZH(String id){
		String sql = "update zh set flag='��ʧ' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// ɾ��
	public int delZH(String id){
		String sql = "delete from zh where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// ����
	public List getAllZH(){ 
		String sql = "select * from zh order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getAllVIPZH(){ 
		String sql = "select * from zh where type='VIP�ʻ�' order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public int getVipSum(){
		String sql="select count(*) from zh where  type='VIP�ʻ�'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public int getTkCount(){
		String sql="select count(*) from tk ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	///����
	public List getZH(String id){ 
		String sql = "select * from zh where id='"+id+"' ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				list.add(rs.getString(9));
				list.add(rs.getString(10));
				list.add(rs.getString(11));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	//////////////////////////////////////////////////////////////////////////////�û������ʻ�
	//�޸�����
	public int upZHPwd(String id,String pwd){
		String sql = "update zh set pwd='"+pwd+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	//��¼
	public int useZHLogin(String id,String pwd){
		String sql = "select * from zh where id='"+id+"' and pwd='"+pwd+"' and flag='����'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs= dbo.executeQuery(sql);
			if(rs.next())
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	///////////////////////////////////////////////////////////////////////////////��ȡ��
	//���
	public int addMoney(String type,String money,String member){
		String sql="insert into cq(type,member,money,addtime) values('"+type+"','"+member+"','"+money+"','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public float cunMoney(String member){//ȡ��ʱ���Ȳ�ѯ���
		String sql="select sum(money) from cq where type='���' and member='"+member+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
		
	}
	public float cunMoney(){//ȡ��ʱ���Ȳ�ѯ���
		String sql="select sum(money) from cq where type='���'  ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
		
	}
	public float quMoney(String member){//ȡ��ʱ���Ȳ�ѯ���
		String sql="select sum(money) from cq where type='ȡ��' and member='"+member+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
		
	}
	public List getMoneyInfo(String member){
		String sql="select * from cq where member='"+member+"' order by id desc";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getMoneyInfo(String member,String type){
		String sql="select * from cq where member='"+member+"' and type='"+type+"' order by id desc";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getQuMoneyInfo(){
		String sql="select * from cq where type='ȡ��' order by id desc";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getCunMoneyInfo(){
		String sql="select * from cq where type='���' order by id desc";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public float quMoney(){
		String sql="select sum(money) from cq where type='ȡ��'  ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
		
	}
	public List getQKJ(){
		String sql="select * from cq where type='ȡ��' order by id desc";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
///////////////////////////////////////////////Ͷ��
	public int touKuan(String money, String jsr){
		String sql="insert into tk(money,jsr,addtime)values('"+money+"','"+jsr+"','"+date+"') ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int delTouKuan(String id){
		String sql="delete from tk where id='"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public List getTouKuan(){
		String sql="select * from tk  order by id desc";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public float tKSUM(){
		String sql="select sum(money) from tk ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
		
	}
}

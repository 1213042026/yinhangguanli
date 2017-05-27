package com.bean;

/**
 * ��̨��վ���ò�����
 * 
 */

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.Constant;
import com.util.DBO;

public class SiteBean {

	private ResultSet rs;
	private List list;
/*****************************************************************
 * �������˵�
 ******************************************************************/	
	//���ӵ��������˵�
	public int addMenu(String menuname,String pic,String linkurl,String wordcolor,String targettype,String hide,String ordernum){
		String sql="select * from menu where menuname='"+menuname+"'";
		String sql2="insert into menu(menuname,pic,linkurl,wordcolor,targettype,hide,ordernum) " +
				"values('"+menuname+"','"+pic+"','"+linkurl+"','"+wordcolor+"','"+targettype+"','"+hide+"','"+ordernum+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return Constant.SAME_NAME;
			}
			else{
				int i=dbo.executeUpdate(sql2);
				if(i==1){
					return Constant.SUCCESS;
				}
				else{
					return Constant.SUCCESS;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
//	�޸ĵ��������˵����޸�װ��ͼƬ��
	public int upmenu(int id,String menuname,String pic,String linkurl,String wordcolor,String targettype,String hide,String ordernum){
		String sql="select * from menu where menuname='"+menuname+"'and id!='"+id+"'";
		String sql2="update menu set menuname='"+menuname+"',pic='"+pic+"',linkurl='"+linkurl+"',wordcolor='"+wordcolor+"'," +
				"targettype='"+targettype+"',hide='"+hide+"',ordernum='"+ordernum+"' where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return Constant.SAME_NAME;
			}
			else{
				int i=dbo.executeUpdate(sql2);
				if(i==1){
					return Constant.SUCCESS;
				}
				else{
					return Constant.SUCCESS;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}

//	�޸ĵ��������˵������޸�װ��ͼƬ��
	public int upmenu(int id,String menuname,String linkurl,String wordcolor,String targettype,String hide,String ordernum){
		String sql="select * from menu where menuname='"+menuname+"'and id!='"+id+"'";
		String sql2="update menu set menuname='"+menuname+"',linkurl='"+linkurl+"',wordcolor='"+wordcolor+"'," +
				"targettype='"+targettype+"',hide='"+hide+"',ordernum='"+ordernum+"' where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return Constant.SAME_NAME;
			}
			else{
				int i=dbo.executeUpdate(sql2);
				if(i==1){
					return Constant.SUCCESS;
				}
				else{
					return Constant.SUCCESS;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	
	//get all menu 
	public List getAllmenu(){
		String sql = "select * from menu order by ordernum desc";
		DBO dbo = new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2 = new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
//	get all menu hide is 1
	public List getAllmenuIsUse(){
		String sql = "select menuname,linkurl from menu order by ordernum desc";
		DBO dbo = new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2 = new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
//	get a menu with id to update
	public List get1menu(int id){
		String sql = "select * from menu where id='"+id+"'  ";
		DBO dbo = new DBO();
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
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	//ɾ�������˵�
	public int delMenu(int id){
		String sql = "delete from menu where id='"+id+"'";
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
	//�鿴�����˵�װ��ͼƬ�Ƿ�����
	public String getMenuPicOff(){
		String sql = "select isoff from menupic ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			rs.next();
			if(rs.getInt(1) == 1)
				return "open";
			else
				return "close";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	//�ر� �����˵�ͼƬ
	public int upDownMenuPower(int isoff){
		String sql = "update menupic  set isoff='"+isoff+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int getMenu1Count(){//��ѯ�˵���������ѭ����������
		String sql = "select count(*) from menu";
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
//	���µ����˵�����˳��
	public int updateMenuOrder(int id,int ordernum){
		String sql = "update menu set ordernum = '"+ordernum+"' where id = '"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.DEFAULT_ERROR;
		}finally{
			dbo.close();
		}
	}
	/**************************************************************
	 * ����ҳ������ alone.jsp
	 * �������ǩ� վ�㵼���� ������Ŀ�� ��ļӢ�ũ� ��ϵ����| ��վ����
	 **************************************************************/
	public int upDateAlone(String type,String title,String content){//����
		String sql = "update alone set title='"+title+"',content='"+content+"' where type='"+type+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else 
				return Constant.DEFAULT_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.DEFAULT_ERROR;
		}finally{
			dbo.close();
		}
	}
	//��ѯ����ҳ��
	public List getAlone(String type){
		String sql = "select title,content from alone where type='"+type+"'";
		DBO dbo = new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			rs.next();
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	/**************************************************************
	 * ��ҳͼƬ �õ� ��������ͼ ��Ѷ����ͼ
	 **************************************************************/
//	add pic
	public int addPic(String picname,String place,String picurl,String linkurl,String ifhide){
		String sql = "insert into pic (picname,place,picurl,linkurl,ifhide) " +
				"values ('"+picname+"','"+place+"','"+picurl+"','"+linkurl+"','"+ifhide+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			if(place.equals("news")&&Integer.parseInt(ifhide)==1||place.equals("info1")&&Integer.parseInt(ifhide)==1||place.equals("info2")&&Integer.parseInt(ifhide)==1||place.equals("info3")&&Integer.parseInt(ifhide)==1||place.equals("info4")&&Integer.parseInt(ifhide)==1){
				dbo.executeUpdate("update pic set ifhide='0' where place='"+place+"'");
			}
			int i = dbo.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	
	//update pic with pic
	public int updatePic(int id,String picname,String place,String picurl,String linkurl,String ifhide){
		String sql = "update pic set picname = '"+picname+"',place='"+place+"',picurl='"+picurl+"'," +
				"linkurl='"+linkurl+"',ifhide='"+ifhide+"' where id = '"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			if(place.equals("news")&&Integer.parseInt(ifhide)==1||place.equals("info1")&&Integer.parseInt(ifhide)==1||place.equals("info2")&&Integer.parseInt(ifhide)==1||place.equals("info3")&&Integer.parseInt(ifhide)==1||place.equals("info4")&&Integer.parseInt(ifhide)==1){
				dbo.executeUpdate("update pic set ifhide='0' where place='"+place+"'");
			}
			int i = dbo.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	
//	update pic without pic
	public int updatePicNoPic(int id,String picname,String place,String linkurl,String ifhide){
		String sql = "update pic set picname = '"+picname+"',place='"+place+"'," +
				"linkurl='"+linkurl+"',ifhide='"+ifhide+"' where id = '"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			if(place.equals("news")&&Integer.parseInt(ifhide)==1||place.equals("info1")&&Integer.parseInt(ifhide)==1||place.equals("info2")&&Integer.parseInt(ifhide)==1||place.equals("info3")&&Integer.parseInt(ifhide)==1||place.equals("info4")&&Integer.parseInt(ifhide)==1){
				dbo.executeUpdate("update pic set ifhide='0' where place='"+place+"'");
			}
			int i = dbo.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	//delete pic
	public int delPic(int id,String dir){
		String sql = "delete from pic where id = '"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery("select picurl from pic where id='"+id+"'");
			rs.next();
			String str=rs.getString(1);
			del(dir+str);
			int i = dbo.executeUpdate(sql);
			if(i == 1){
				return Constant.SUCCESS;
			}
			else{
				return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public void del(String filepath) {
		try{
			File f = new File(filepath);//�����ļ�·��        
			if(f.exists()){//�ж����ļ�����Ŀ¼
			    f.delete();//�ݹ����
			}
		}catch(Exception e){
			
		}
	}
	//get one pic to update
	public List getOnePic(int id){
		String sql = "select * from pic where id = '"+id+"'";
		DBO dbo = new DBO();
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
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	//get pic count
	public int getPicCount(){
		String sql = "select count (*) from pic ";
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
	
	//ǰ̨��ʾͼƬ
	public List getPic(String place){
		String sql = "select * from pic where place='"+place+"' and ifhide='1'";
		DBO dbo = new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				list.add(rs.getString("picname"));
				list.add(rs.getString("picurl"));
				list.add(rs.getString("linkurl"));
				return list;
			}
			else{
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	//��ҳ�õ���ʾͼƬ
	public List getRollPic(){
		String sql = "select * from pic where place='rollpic' and ifhide='1' order by id desc ";
		DBO dbo = new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2 = new ArrayList();
				list2.add(rs.getString("picname"));
				list2.add(rs.getString("picurl"));
				list2.add(rs.getString("linkurl"));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	///��̨��ҳ
	private int EVERYPAGENUM = 2;
	private int count = -1;
	private int qq = 0;
	private String sql="select count(*) from pic";
	private String sql2="select * from pic order by id desc ";
    public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
    public int getMessageCount() { //�õ���Ϣ����
       DBO dbo=new DBO();
       dbo.open();
        try { 
            rs = dbo.executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            dbo.close();
        }
    }
    public int getPageCount() { //�õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
        if (count % EVERYPAGENUM == 0) {
            return count / EVERYPAGENUM;
        } else {
            return count / EVERYPAGENUM + 1;
        }
    }
    public List getMessage(int page) { //�õ�ÿҳҪ��ʾ����Ϣ
        DBO dbo=new DBO();
        dbo.open();
        List list = new ArrayList();
        try {
            rs = dbo.executeQuery(sql2);
            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
                rs.next();
            }
            for (int t = 0; t < EVERYPAGENUM; t++) {
                if (rs.next()) {
                    qq++;
                    List list2=new ArrayList();
                    list2.add(rs.getString(1));
    				list2.add(rs.getString(2));
    				list2.add(rs.getString(3));
    				list2.add(rs.getString(4));
    				list2.add(rs.getString(5));
    				list2.add(rs.getString(6));
    				list.add(list2);
                } else {
                    break; //���ٿ�ѭ����ʱ��
                }
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        } finally {
            dbo.close();
        }
    }
}

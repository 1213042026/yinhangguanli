<%@ page language="java" import="java.util.*,com.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="com.bean.*" %>
<jsp:useBean id="zb" scope="page" class="com.bean.ZhBean" />
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<HTML><HEAD><TITLE>��̨������</TITLE>
<LINK href="<%=basePath %><%=dir %>/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %><%=dir %>/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="<%=basePath %><%=dir %>/images/Common.js"></SCRIPT>
<SCRIPT language=JavaScript src="<%=basePath %><%=dir %>/images/calendar.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
<script type="text/javascript">
function check()
{//String type,String pwd,String name,String sex,String bir,String sfz,String address,String remark
	if(document.form1.pwd.value==""||document.form1.name.value==""||document.form1.bir.value==""
	||document.form1.sfz.value==""||document.form1.address.value==""||document.form1.remark.value=="")
	{
		alert("������Ŀ������д��");
		return false;
	}
	
}

</script>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{//String type,String pwd,String name,String sex,String bir,String sfz,String address,String remark	
	String method=request.getParameter("method").trim();
	String id=request.getParameter("id");
	String type="";String pwd="";String name="";String sex="";String bir="";String sfz="";
	String address="";String remark="";
	if(method.equals("upZH")){
		List list=zb.getZH(id);
		type=list.get(1).toString();pwd=list.get(2).toString();name=list.get(3).toString();sex=list.get(4).toString();
		bir=list.get(5).toString();sfz=list.get(6).toString();
		address=list.get(7).toString();remark=list.get(8).toString();
	}
		
%>
<BODY >
 <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23>�ʻ���Ϣ���� ������Ŀ������д</TD>
		  </TR>
		  <TR align="center" >
			<TD >
		<form name="form1" action="<%=basePath %>ZhServlet" method="post" onsubmit="return check()">
		  <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 >
		  <TBODY>	  
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�ʻ����ͣ�<input type=hidden name=method value=<%=method %>><input type=hidden name=id value=<%=id %>></TD>
			<TD align=left><select name=type>
			<%if(method.equals("upZH")) {%><option value="<%=type %>"><%=type %></option><%}else{ %>
			<option value="��ͨ�ʻ�">��ͨ�ʻ�</option>
			<option value="VIP�ʻ�">VIP�ʻ�</option>
			<%} %>
			</select>
			 </TD>	
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�˺����룺</TD>
			<TD align=left><input type=password name=pwd value=<%=pwd %>></TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�û�������</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=name value=<%=name %>> </TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�û��Ա�</TD>
			<TD align=left><input type=radio name=sex value="��" checked> �� <input type=radio name=sex value="Ů"> Ů</TD>
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�������ڣ�</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=bir value="<%=bir %>" > </TD>
		  </TR>
		 <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>���֤�ţ�</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=sfz value="<%=sfz %>" > </TD>
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>��ϵ��ַ��</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=address value="<%=address %>" > </TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>��ע��Ϣ��</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=remark value=<%=remark %>> </TD>
		  </TR>
		    <TR  align="center" bgColor=#ffffff>
			<TD colspan=2 align=center><input type=submit value="�ύ"></TD>
		  </TR>
		  </TBODY>
	   </TABLE>
		  </form>
		  </TD>
		  </TR>
		  </TBODY>
	   </TABLE>
</BODY>
<%} %>

</HTML>

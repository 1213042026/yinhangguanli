<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<jsp:useBean id="zb" scope="page" class="com.bean.ZhBean"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD>
<LINK href="<%=basePath %>member/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %>member/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="<%=basePath %>images/css/Common.js"></SCRIPT>
<SCRIPT language=JavaScript src="<%=basePath %>member/images/calendar.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
<SCRIPT language=JavaScript src="<%=basePath %>member/images/city.js"></SCRIPT>
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
	String member=(String)session.getAttribute("member");
	String type=(String)session.getAttribute("type");
	if(member==null||type==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	 String types="";String pwd="";String name="";String sex="";String bir="";String sfz="";String address="";String remark="";
		List list=zb.getZH(member);
		types=list.get(1).toString();pwd=list.get(2).toString();name=list.get(3).toString();sex=list.get(4).toString();
		bir=list.get(5).toString();sfz=list.get(6).toString();
		address=list.get(7).toString();remark=list.get(8).toString();
%>
<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %>member/images/MainBg.gif topMargin=0 scroll=yes marginheight="0" marginwidth="0">
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
			<TD width=40% id=map align=right>�ʻ����ͣ� </TD>
			<TD align=left><%=types %></TD>	
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�˺����룺</TD>
			<TD align=left><%=pwd %></TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�û�������</TD>
			<TD align=left><%=name %> </TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�û��Ա�</TD>
			<TD align=left><%=sex %></TD>
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>�������ڣ�</TD>
			<TD align=left><%=bir %> </TD>
		  </TR>
		 <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>���֤�ţ�</TD>
			<TD align=left><%=sfz %> </TD>
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>��ϵ��ַ��</TD>
			<TD align=left><%=address %> </TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>��ע��Ϣ��</TD>
			<TD align=left><%=remark %> </TD>
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

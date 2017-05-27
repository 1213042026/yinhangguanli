<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="com.bean.*" %>
<jsp:useBean id="zb" scope="page" class="com.bean.ZhBean" />
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<HTML><HEAD><TITLE>后台操作区</TITLE>
<LINK href="<%=basePath %><%=dir %>/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %><%=dir %>/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="<%=basePath %><%=dir %>/images/Common.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
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
	else{
		List list=(List)session.getAttribute("list");
		List list2=zb.getAllZH();	
		//String type,String pwd,String name,String sex,String bir,String sfz,String address,String remark	
%>
<BODY >
 <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23>序号</TD>
			<TD>卡号</TD>
			<TD>用户类型</TD>
			<TD>姓名</TD>
			<TD>性别</TD>
			<TD>出生日期</TD>
			<TD>身份证号码</TD>
			<TD>地址</TD>
			<TD>备注信息</TD>
			<TD>挂失</TD>
			<TD>开户日期</TD>
			<TD>修改</TD>
			<TD>销户</TD>
		  </TR>
		<%
		if(list2.size()!=0){
			for(int i = 0; i<list2.size(); i++){
				List list3 = (List)list2.get(i);
		%>
		  <TR  align="center" bgColor=#ffffff>
			<TD width="30" id=map><%=i+1 %></TD>
			<TD id=map><%=list3.get(0).toString() %></TD>
			<TD id=map><%=list3.get(1).toString() %></TD>
			<TD id=map><%=list3.get(3).toString() %></TD>
			<TD id=map><%=list3.get(4).toString() %></TD>
			<TD id=map><%=list3.get(5).toString() %></TD>
			<TD id=map><%=list3.get(6).toString() %></TD>
			<TD id=map><%=list3.get(7).toString() %></TD>
			<TD id=map><%=list3.get(8).toString() %></TD>			
			<TD id=map><a href="<%=basePath %>ZhServlet?method=closeZH&id=<%=list3.get(0).toString()%>"><%=list3.get(9).toString() %></a></TD>
			<TD id=map><%=list3.get(10).toString() %></TD>
			<TD id=map><a href="<%=basePath %>admin/zh/add.jsp?method=upZH&id=<%=list3.get(0).toString()%>">修改</a></TD>
			<TD id=map><a href="<%=basePath %>ZhServlet?method=delZH&id=<%=list3.get(0).toString()%>">销户</a></TD>
		  </TR>
		<%}}%>
		 </TBODY>
	   </TABLE>
<style media=print> 
.Noprint{display:none;}<!--用本样式在打印时隐藏非打印项目--> 
.PageNext{page-break-after: always;}<!--控制分页--> 
</style> 
<object id="WebBrowser" width=0 height=0 classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"> 
</object> 

<center class="Noprint" > 
<input type=button value=打印 onclick=document.all.WebBrowser.ExecWB(6,1)> 
<input type=button value=直接打印 onclick=document.all.WebBrowser.ExecWB(6,6)> 
<input type=button value=页面设置 onclick=document.all.WebBrowser.ExecWB(8,1)> 
</p> 
<p> <input type=button value=打印预览 onclick=document.all.WebBrowser.ExecWB(7,1)> 
</center>	  
</BODY>
<%} %>

</HTML>

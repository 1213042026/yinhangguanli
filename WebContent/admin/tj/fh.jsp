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
		List mlist=zb.getQuMoneyInfo();
		List mlist2=zb.getCunMoneyInfo(); 
%>
<BODY >
 <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23 colspan=2>工作负荷量统计</TD>
		</TR>
		  <TR align="center">
			<TD> 投款累计：<%=zb.getTkCount() %> 次 </TD>
			<TD>金 额 总 计：<%=zb.tKSUM() %> 元</TD>
		  </TR>
		  <TR align="center">
			<TD>客户存款累计：<%=mlist2.size() %> 次 </TD>
			<TD>金 额 总 计：<%=zb.cunMoney() %> 元</TD>
		  </TR>
		  <TR align="center">
			<TD>客户取款累计：<%=mlist.size() %> 次 </TD>
			<TD>金 额 总 计：<%=zb.quMoney() %> 元</TD>
		  </TR>
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

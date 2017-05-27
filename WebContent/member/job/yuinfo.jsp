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
	 if(member==null ){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
 List mlist=zb.getMoneyInfo(member);
 float cun=zb.cunMoney(member);
 float qu=zb.quMoney(member);
%>
<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %>member/images/MainBg.gif topMargin=0 scroll=yes marginheight="0" marginwidth="0">
<TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		    <TR align="center" class=head>
		    <TD align=center>序号</TD>
			<TD align=center>操作类型</TD>
			<TD align=center>金额</TD>
			<TD align=center>日期</TD>
		  </TR>
		  <%if(!mlist.isEmpty()){
		  		for(int i=0;i<mlist.size();i++){
		  			List list2=(List)mlist.get(i);
		  %>
		  <TR align="center">
		    <TD align=center><%=i+1 %></TD>
			<TD align=center><%=list2.get(1).toString() %></TD>
			<TD align=center><%=list2.get(2).toString() %></TD>
			<TD align=center><%=list2.get(4).toString() %></TD>
		  </TR>
		  <%
		  		}
		  	}	
		   %>
		    <TR >
		    <TD align="center" colspan=5>累计存款：<font color=red><%=cun %></font> 元 累计取款：<font color=red><%=qu %></font> 元 帐户余额：<font color=red><%=cun-qu %></font> 元</TD>
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

<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="com.bean.*" %>
<jsp:useBean id="lb" scope="page" class="com.bean.AdminBean" />
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zb" scope="page" class="com.bean.ZhBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<HTML><HEAD><TITLE>��̨������</TITLE>
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
		List list2=zb.getTouKuan();
		
%>
<script type="text/javascript">
function ab()

{
	if(document.form1.money.value==""||document.form1.jsr.value=="")	
	{
		alert("����д������Ŀ");
		return false;
	}
}
</script>
<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %><%=dir %>/images/MainBg.gif topMargin=0 scroll=no marginheight="0" marginwidth="0">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD align="left" vAlign=top >
	<form action="<%=basePath %>/ZhServlet?method=TOUKUAN" method="post" name="form1" onSubmit="return ab()">
       <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23>���</TD>
			<TD>Ͷ����</TD>
			<TD>������</TD>
			<TD>ʱ��</TD>
			<TD>ɾ��</TD>
		  </TR>
		<%
		if(list2.size()!=0){
			for(int i = 0; i<list2.size(); i++){
				List list3 = (List)list2.get(i);
		%>
		  <TR onClick=OnclikeTable(this) align="center" bgColor=#ffffff>
			<TD width="30" id=map><%=i+1 %></TD>
			<TD id=map><%=list3.get(1).toString() %></TD>
			<TD id=map><%=list3.get(2).toString() %></TD>
			<TD id=map><%=list3.get(3).toString() %></TD>
			<TD id=map><a href="<%=basePath %>ZhServlet?method=DELTK&id=<%=list3.get(0).toString()%>">ɾ��</a></TD>
		  </TR>
		<%}%>
		<TR align="center" bgColor=#ffffff>
			<TD colspan=8 align=center id=map>�ܼ�Ͷ�<font color=red><%=zb.tKSUM() %></font> Ԫ</TD>
		  </TR>
		<%}else{%>	
		  <TR align="center" bgColor=#ffffff>
			<TD colspan=8 align=center id=map>��ǰ��û��Ͷ��</TD>
		  </TR>
		<%} %>  
		  </TBODY>
	   </TABLE><br>
	   <TABLE width="40%" border=0 align="center" cellPadding=3 cellSpacing=1>
	   <TR><TD>
	   <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23 colspan="2">����Ͷ��</TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width="40%" align="right" id=map>Ͷ���</TD>
			<TD width="60%" align="left" id=map>
			<input type=text name=money size=20 maxlength=20 onkeyup="if   (!(/^[\d]+\.?\d*$/.test(this.value))   ){alert('������������');   this.value='';this.focus();}"></TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD align="right" id=map>�� �� �ˣ�</TD>
			<TD align="left" id=map><input type="text" name="jsr" maxlength="16" size="18" ></TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD colspan="2" align="center" id=map><input type="submit" value="ȷ��">&nbsp;&nbsp;<input type="reset" value="����"></TD>
			</TR>
		  </TBODY>
	   </TABLE>
	   </TD></TR></table><br>
	  </form>
    </TD>
  </TR>
  </TBODY>
</TABLE>
</BODY>
<%} %>
</HTML>

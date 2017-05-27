<%@ page language="java" import="java.util.*,com.util.*"  contentType="text/html;charset=gb2312"%>

<jsp:useBean id="hsb" scope="page" class="com.bean.HouseBean"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD>
<LINK href="<%=basePath %>member/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %>member/images/style.css" type=text/css rel=stylesheet>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
<script  language="javascript" >
function del()
{
	pageform.submit();
}
</script>
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
	String member=(String)session.getAttribute("member");
	if(member==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
%>
<BODY >
<%

String type=Common.toChineseAndTrim(request.getParameter("type")).trim(); 
String str=Common.toChineseAndTrim(request.getParameter("ss")).trim(); 
List list=new ArrayList();
if(str.equals("出售")){
	String sql2="select * from salehouse where type like '%"+type+"%' order by id desc";
	list=hsb.getAllOut(sql2);
%>
<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=1>
		<TBODY>
        <TR>
          <TD class=head colspan="2">
			<SPAN class=TAG>出售信息</SPAN> 
			 </TD>
		</TR>
		<TR>
		<TD border=1  class=middle align="left" >
               <TABLE class=xsnr id=tb1_nr1  cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
         <TR>
          <TD  align=left>房屋类型</TD>
		   <TD align=center>面积</TD>
		  <TD align=center>价格</TD>
		  <TD align=right>联系电话</TD>
		  <TD align=right>发布时间</TD>
		</TR>
                    <%if(!list.isEmpty()){
					for(int job11=0;job11<list.size();job11++){
						List jobList11=(List)list.get(job11);
			%>
        <TR border=1>
          <TD  align=left>
		  <A href="<%=basePath%>saleinfo.jsp?id=<%=jobList11.get(0).toString()%>" target=_blank><%=jobList11.get(1).toString()%></A>
		   </TD>
		   <TD align=center>
		  <%=jobList11.get(3).toString()%>  
		  </TD>
		  <TD align=center>
		  <%=jobList11.get(4).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(5).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(9).toString()%>  
		  </TD>
		</TR>
		<%}} %>
				</TBODY>
			</TABLE>			
			</TD>
		</TR>
        </TBODY>
	  </TABLE>
<%
}
else if(str.equals("求租")){
String sql3="select * from inhouse where type like '%"+type+"%' order by id desc";
list=hsb.getAllIn(sql3);
%>
 <TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
	  <TBODY>
        <TR>
          <TD class=head colspan="2">
            <SPAN class=TAG>求租信息</SPAN> 
          </TD>
		</TR>
		<TR>
		<TD  class=middle align="left" >
               <TABLE class=xsnr id=tb1_nr1  cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                      <TR>
          <TD  align=left>房屋类型</TD>
		   <TD align=center>面积</TD>
		  <TD align=center>价格</TD>
		  <TD align=right>联系电话</TD>
		  <TD align=right>发布时间</TD>
		</TR>
                    <%if(!list.isEmpty()){
					for(int job11=0;job11<list.size();job11++){
						List jobList11=(List)list.get(job11);
			%>
        <TR>
          <TD  align=left>
		  <A href="<%=basePath%>ininfo.jsp?id=<%=jobList11.get(0).toString()%>" target=_blank><%=jobList11.get(1).toString()%></A>
		   </TD>
		   <TD align=center>
		  <%=jobList11.get(2).toString()%>  
		  </TD>
		  <TD align=center>
		  <%=jobList11.get(3).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(4).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(8).toString()%>  
		  </TD>
		</TR>
		<%}} %>
				</TBODY>
			</TABLE>			
			</TD>
		</TR>
        </TBODY>
<%
}
else if(str.equals("求购")){
String sql4="select * from buyhouse where type like '%"+type+"%' order by id desc";
list=hsb.getAllIn(sql4);
%>
<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
	  <TBODY>
        <TR>
          <TD class=head colspan="2">
            <SPAN class=TAG>求购信息</SPAN> 
          </TD>
		</TR>
		<TR>
		<TD  class=middle align="left" >
               <TABLE class=xsnr id=tb1_nr1  cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                          <TR>
          <TD  align=left>房屋类型</TD>
		   <TD align=center>面积</TD>
		  <TD align=center>价格</TD>
		  <TD align=right>联系电话</TD>
		  <TD align=right>发布时间</TD>
		</TR>
                    <%if(!list.isEmpty()){
					for(int job11=0;job11<list.size();job11++){
						List jobList11=(List)list.get(job11);
			%>
        <TR>
          <TD  align=left>
		  <A href="<%=basePath%>buyinfo.jsp?id=<%=jobList11.get(0).toString()%>" target=_blank><%=jobList11.get(1).toString()%></A>
		   </TD>
		   <TD align=center>
		  <%=jobList11.get(2).toString()%>  
		  </TD>
		  <TD align=center>
		  <%=jobList11.get(3).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(4).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(8).toString()%>  
		  </TD>
		</TR>
		<%}} %>
				</TBODY>
			</TABLE>			
			</TD>
		</TR>
        </TBODY>
	  </TABLE>
<%
}
else{
String sql="select * from outhouse where type like '%"+type+"%' order by id desc";
list=hsb.getAllOut(sql);
%>
<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
		<TBODY>
        <TR>
          <TD class=head colspan="2">
			<SPAN class=TAG>出租信息</SPAN> 
			 </TD>
		</TR>
		<TR>
		<TD  class=middle align="left" >
               <TABLE class=xsnr id=tb1_nr1  cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
         <TR>
          <TD  align=left>房屋类型</TD>
		   <TD align=center>面积</TD>
		  <TD align=center>价格</TD>
		  <TD align=right>联系电话</TD>
		  <TD align=right>发布时间</TD>
		</TR>
                    <%if(!list.isEmpty()){
					for(int job11=0;job11<list.size();job11++){
						List jobList11=(List)list.get(job11);
			%>
        <TR>
          <TD  align=left>
		  <A href="<%=basePath%>outinfo.jsp?id=<%=jobList11.get(0).toString()%>" target=_blank><%=jobList11.get(1).toString()%></A>
		   </TD>
		   <TD align=center>
		  <%=jobList11.get(3).toString()%>  
		  </TD>
		  <TD align=center>
		  <%=jobList11.get(4).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(5).toString()%>  
		  </TD>
		  <TD align=right>
		  <%=jobList11.get(9).toString()%>  
		  </TD>
		</TR>
		<%}} %>
				</TBODY>
			</TABLE>			
			</TD>
		</TR>
        </TBODY>
	  </TABLE>
<%
}
%>
<script type="text/javascript">
function check()
{
	if(document.form1.type.value=="")
	{
		alert("请输入房屋类型！");
		document.form1.type.focus();
		return false;
	}
}
</script>
</BODY>
<%} %>
</HTML>

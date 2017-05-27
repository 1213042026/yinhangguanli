package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ZhBean;
import com.util.Constant;

public class ZhServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ZhServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENTTYPE);
		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		HttpSession session=request.getSession();
		ZhBean zb=new ZhBean();
		String method=request.getParameter("method").trim();
		if(method.equals("addZH")){///////////////////////////////////////////////////////addzh
			String type=request.getParameter("type");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String bir=request.getParameter("bir");
			String sfz=request.getParameter("sfz");
			String address=request.getParameter("address");
			String remark=request.getParameter("remark");
			int flag=zb.addZH(type,pwd, name, sex, bir, sfz, address, remark);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("upZH")){///////////////////////////////////////////////////////upzh
			String id=request.getParameter("id");
			String type=request.getParameter("type");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String bir=request.getParameter("bir");
			String sfz=request.getParameter("sfz");
			String address=request.getParameter("address");
			String remark=request.getParameter("remark");
			int flag=zb.upZH(id, type,pwd, name, sex, bir, sfz, address, remark);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("closeZH")){///////////////////////////////////////////////////////closezh
			String id=request.getParameter("id");
			int flag=zb.closeZH(id);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("delZH")){///////////////////////////////////////////////////////delzh
			String id=request.getParameter("id");
			int flag=zb.delZH(id);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("admin/zh/index.jsp").forward(request, response);
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////用户操作
		else if(method.equals("upZHPwd")){///////////////////////////////////////////////////////delzh
			String id=(String)session.getAttribute("member");
			String pwd=request.getParameter("newpwd");
			int flag=zb.upZHPwd(id,pwd);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("member/info/editpwd.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("member/info/editpwd.jsp").forward(request, response);
			}
		}
		else if(method.equals("useZHLogin")){///////////////////////////////////////////////////////user login
			String id=request.getParameter("username");
			String pwd=request.getParameter("password");
			int flag=zb.useZHLogin(id,pwd);
			if(flag==Constant.SUCCESS){
				session.setAttribute("member", id);
				session.setAttribute("type", id);
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("member/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "密码错误！");
				request.getRequestDispatcher("user.jsp").forward(request, response);
			}
		}
		else if(method.equals("MEXIT")){///////////////////////////////////////////////////////user login
			session.removeAttribute("member");
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		/////////////////////////////////////////////////////////////////////////////////存取款
		else if(method.equals("CQK")){
			String type=request.getParameter("type");
			String money=request.getParameter("money");
			String member=(String)session.getAttribute("member");
			if(type.trim().equals("存款")){
				int flag=zb.addMoney(type, money, member);
				if(flag==Constant.SUCCESS){
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("member/job/default.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("member/job/default.jsp").forward(request, response);
				}
			}
			else{
				float cun=zb.cunMoney(member);
				float qu=zb.quMoney(member);
				if(cun==0){
					request.setAttribute("message", "您的帐户余额为0元，请先存款！");
					request.getRequestDispatcher("member/job/cq.jsp").forward(request, response);
				}
				else{
					float m=Float.parseFloat(money);
					if((cun-qu)>=m){
						float atm=zb.tKSUM();
						float qk=zb.quMoney();
						if((atm-qk)<m){//如果金额不足
							request.setAttribute("message", "余款不足，暂停服务！");
							request.getRequestDispatcher("member/job/default.jsp").forward(request, response);
						}
						else{
							int flag=zb.addMoney(type, money, member);
							if(flag==Constant.SUCCESS){
								request.setAttribute("message", "操作成功！");
								request.getRequestDispatcher("member/job/default.jsp").forward(request, response);
							}
							else{
								request.setAttribute("message", "系统维护中，请稍后再试！");
								request.getRequestDispatcher("member/job/default.jsp").forward(request, response);
							}
						}						
					}
					else{
						request.setAttribute("message", "您的帐户余额为"+(cun-qu)+"元，低于取款金额！");
						request.getRequestDispatcher("member/job/default.jsp").forward(request, response);
					}
				}
			}
		}
		else if(method.equals("TOUKUAN")){///////////////////////////////////////////////////////user login
			String money=request.getParameter("money");
			String jsr=request.getParameter("jsr");
			int flag=zb.touKuan(money, jsr);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/qk/tk.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("admin/zh/qk.jsp").forward(request, response);
			}
		}
		else if(method.equals("DELTK")){///////////////////////////////////////////////////////user login
			String id=request.getParameter("id");
			String jsr=request.getParameter("jsr");
			int flag=zb.delTouKuan(id);
			if(flag==Constant.SUCCESS){
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("admin/qk/tk.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "系统维护中，请稍后再试！");
				request.getRequestDispatcher("admin/zh/qk.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

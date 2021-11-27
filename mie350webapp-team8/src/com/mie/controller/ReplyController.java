package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.ReviewDao;
import com.mie.model.Review;
import com.mie.dao.ReplyDao;
import com.mie.model.Reply;


public class ReplyController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. INSERT leads
	 * to the Add A Student page. EDIT leads to the Edit A Student page.
	 * LIST_STUDENT_PUBLIC leads to the public listing of students.
	 * LIST_STUDENT_ADMIN leads to the admin-only listing of students (for them
	 * to modify student information).
	 * 
	 */
	private static final long serialVersionUID = 1L; //what is thiss
	private static String INSERT = "/addReply.jsp"; //NEED TO MAKE CREATE NEW JSP
	//private static String EDIT = "/editReview.jsp";
	private static String LIST_REPLY = "/listReview.jsp"; //NEED TO CREATE NEW JSP (listReview)
	//private static String LIST_STUDENT_ADMIN = "/listStudentAdmin.jsp";

	private ReplyDao dao;

	/**
	 * Constructor for this class.
	 */
	public ReplyController() {
		super();
		dao = new ReplyDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 * 
		 * - delete will direct the servlet to let the user delete a student in
		 * the database. - insert will direct the servlet to let the user add a
		 * new student to the database. - edit will direct the servlet to let
		 * the user edit student information in the database. - listStudent will
		 * direct the servlet to the public listing of all students in the
		 * database. - listStudentAdmin will direct the servlet to the admin
		 * listing of all students in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT; //new review to restaurant page
		} 
		
		else if (action.equalsIgnoreCase("listReply")) {
			forward = LIST_REPLY;
			request.setAttribute("replies", dao.getReviewReplies(1));//how to get review id as param
		}

		else {
			forward = INSERT;
		}

		//this does something with the jsp 
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the addStudent.jsp or the editStudent.jsp pages.
		 */
		
		Reply reply = new Reply();
		reply.setReplyContent(request.getParameter("content"));
		reply.setUserId(Integer.parseInt(request.getParameter("userId"))); //how would we get this from the jsp? @gabriel
		reply.setReviewId(Integer.parseInt(request.getParameter("reviewId")));
		
		String replyid = request.getParameter("replyId"); //same as for user id @gabriel
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		reply.setPostTime(timestamp);
		dao.addReply(reply);
		
		/**
		 * Once the student has been added or updated, the page will redirect to
		 * the listing of students.
		 * 
		 * ^^ where would we redirect to (restaurant page?)
		 */
		RequestDispatcher view = request
				.getRequestDispatcher(LIST_REPLY);
		request.setAttribute("reviews", dao.getReviewReplies(Integer.parseInt(request.getParameter("reviewId"))));
		view.forward(request, response);
	}

}

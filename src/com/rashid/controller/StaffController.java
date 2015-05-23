package com.rashid.controller;

import com.rashid.dao.StaffDao;
import com.rashid.model.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rashid on 23.05.2015.
 */
public class StaffController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/staff.jsp";
    private static String LIST_STAFF = "/listStaff.jsp";
    private StaffDao dao;

    public StaffController() {
        super();
        dao = new StaffDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteStaff(id);
            forward = LIST_STAFF;
            request.setAttribute("staff", dao.getAllStaff());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Staff staff = dao.getStaffById(id);
            request.setAttribute("staff", staff);
        } else if (action.equalsIgnoreCase("listStaff")){
            forward = LIST_STAFF;
            request.setAttribute("staff", dao.getAllStaff());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = new Staff();

        staff.setIndexNum(Integer.parseInt(request.getParameter("indexNum")));
        staff.setSurname(request.getParameter("surname"));
        staff.setName(request.getParameter("name"));
        staff.setPatronymic(request.getParameter("patronymic"));

        try {
            Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dob"));
            staff.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        staff.setIdPost(Integer.parseInt(request.getParameter("idPost")));
        staff.setIdRank(Integer.parseInt(request.getParameter("idRank")));
        staff.setIdSubdiv(Integer.parseInt(request.getParameter("idSubdiv")));

        try {
            Date contractDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("contractDate"));
            staff.setDob(contractDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        staff.setContractPeriond(Integer.parseInt(request.getParameter("contractPeriond")));


        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            dao.addStaff(staff);
        }
        else
        {
            staff.setId(Integer.parseInt(id));
            dao.updateStaff(staff);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_STAFF);
        request.setAttribute("staff", dao.getAllStaff());
        view.forward(request, response);
    }
}

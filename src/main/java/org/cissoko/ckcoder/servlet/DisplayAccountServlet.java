package org.cissoko.ckcoder.servlet;

import org.cissoko.ckcoder.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "displayAccount", urlPatterns = {"/displayAccount"})
public class DisplayAccountServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Repository repository = Repository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = (int) req.getAttribute("accountId");
        logger.info("Post Account info " + id);
        logger.info("Post Account info " + repository.findById(id).toString());
        req.getRequestDispatcher("DisplayAccountView.jsp").forward(req, resp);

    }
}

package org.cissoko.ckcoder.servlet;

import org.cissoko.ckcoder.model.Account;
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
        logger.info("Post method are call");
        String id = req.getParameter("accountId");
        logger.info("Post Account info " + id);
        Account account = repository.findById(Integer.valueOf(id));
        req.setAttribute("account", account);
        logger.info("Post Account info " + account.toString());
        req.getRequestDispatcher("/DisplayAccountView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

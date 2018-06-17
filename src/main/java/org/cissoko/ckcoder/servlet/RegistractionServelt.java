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
import java.util.Date;

@WebServlet(name = "registration", urlPatterns = {"/"})
public class RegistractionServelt extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("RegistrationView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String bornofText = req.getParameter("bornon");
        /*Date bornof;
        try {
            bornof = new Date(Date.parse(bornofText));
        } finally {
            bornof = null;
        }*/
        String sexe = req.getParameter("sexe");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String region = req.getParameter("region");
        String city = req.getParameter("city");
        String street = req.getParameter("street");


        logger.info("Account info " + name + " " + surname + " " + bornofText + " " + sexe + " " + telephone + " " + email + " " + country + " " + region + " " + city + " " + street);
        Account account = new Account();
        account.setName(name);
        account.setSurname(surname);
        account.setEmail(email);
        account.setTelephone(telephone);
        account.setCountry(country);
        account.setRegion(region);
        account.setCity(city);
        account.setStreet(street);

        Repository repository = Repository.getInstance();
        repository.save(account);

        req.setAttribute("accountId", account.getId());
        logger.error("save account " + account.toString());
        req.getRequestDispatcher("/displayAccount").forward(req, resp);
    }
}

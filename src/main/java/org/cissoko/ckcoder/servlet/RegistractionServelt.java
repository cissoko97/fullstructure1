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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "registration", urlPatterns = {"/"})
public class RegistractionServelt extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Repository repository = Repository.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        logger.info("get method is call");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String telephone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConf = req.getParameter("password_conf");

        Account account = new Account();

        if (name.length() == 0)
            errors.put("name", "Votre nom ne doit pas etre vide");
        else if (name.length() < 4)
            errors.put("name", "Doit contenir plus de 4 caractères");
        else if (!name.matches("[a-zA-Z]+"))
            errors.put("name", "Ne doit pas contenir des carectères speciaux");

        if (surname.length() == 0)
            errors.put("surname", "Votre prenom ne doit pas etre vide");
        else if (!surname.matches("[a-zA-Z]+"))
            errors.put("surname", "Ne doit pas contenir des carectères speciaux");

        if (email.length() == 0)
            errors.put("email", "Votre email n edoit pas etre vide");
        else if (!email.matches("[a-z0-9._-]+@[a-z0-9._-]+\\.[a-z]{2,6}"))
            errors.put("email", "Votre email n'a pas un format d'email valide");
        else if (repository.findByEmail(email) != null)
            errors.put("email", "This email is present in database change it");

        if (telephone.length() == 0)
            errors.put("telephone", "Votre contact ne doit pas etre vide");
        else if (telephone.length() < 9)
            errors.put("telephone", "Doit contenir plus de 9 caractères");
        else if (!telephone.matches("\\d{9,}"))
            errors.put("telephone", "Doit contenir uniquement des chiffres");
        else if (repository.findByPhone(telephone) != null)
            errors.put("telephone", "This phone number is present in database change it");

        if (password.length() == 0)
            errors.put("password", "Ne doit pas etre vide");
        else if (password.length() < 6)
            errors.put("password", "Ne doit pas contenir moins de 6 caractères");

        if (passwordConf.length() == 0)
            errors.put("passwordConf", "Ne doit pas etre vide");
        else if (!passwordConf.equals(password))
            errors.put("passwordConf", "Doit etre indentique au ùot de passe");


        account.setName(name);
        account.setSurname(surname);
        account.setEmail(email);
        logger.error(telephone);
        account.setPhone(telephone);
        account.setPassword(password);

        if (errors.size() == 0) {
            repository.save(account);
            logger.warn("good account to registration");
            resp.sendRedirect("/displayAccount" + "?accountId=" + account.getId());
        } else {
            req.setAttribute("account", account);
            req.setAttribute("errors", errors);
            this.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            logger.error("failed to create account");
        }
    }
}

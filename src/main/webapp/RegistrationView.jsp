<%--
  Created by IntelliJ IDEA.
  User: cissoko
  Date: 16/06/2018
  Time: 07:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name" placeholder="Your name"></td>
        </tr>
        <tr>
            <td><label for="surname">surname</label></td>
            <td><input type="text" name="surname" id="surname" placeholder="Your surname"></td>
        </tr>
        <tr>
            <td><label for="bornon">birthday</label></td>
            <td><input type="date" name="bornon" id="bornon" placeholder="Born On"></td>
        </tr>
        <tr>
            <td><label>gender</label></td>
            <td>M<input type="radio" name="sexe"></td>
            <td>F<input type="radio" name="sexe"></td>
        </tr>
        <tr>
            <td><label for="email">email</label></td>
            <td><input type="email" name="email" id="email" placeholder="Your Email"></td>
        </tr>
        <tr>
            <td><label for="telephone">Telephone</label></td>
            <td><input type="text" name="telephone" id="telephone" placeholder="Your Telephone"></td>
        </tr>
        <tr>
            <td><label for="country">country</label></td>
            <td><input type="text" name="country" id="country" placeholder="Your Country"></td>
        </tr>
        <tr>
            <td><label for="region">Region</label></td>
            <td><input type="text" name="region" id="region" placeholder="Your Region"></td>
        </tr>
        <tr>
            <td><label for="city">City</label></td>
            <td><input type="text" name="city" id="city" placeholder="Your City"></td>
        </tr>
        <tr>
            <td><label for="street">Street</label></td>
            <td><input type="text" name="street" id="street" placeholder="Your Street"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>

</form>
</body>
</html>

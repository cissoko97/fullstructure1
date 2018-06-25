<%--
  Created by IntelliJ IDEA.
  User: cissoko
  Date: 16/06/2018
  Time: 07:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
            <td><label for="email">email</label></td>
            <td><input type="email" name="email" id="email" placeholder="Your Email"></td>
        </tr>
        <tr>
            <td><label for="telephone">Telephone</label></td>
            <td><input type="text" name="telephone" id="telephone" placeholder="Your Telephone"></td>
        </tr>
        <tr>
            <td><label for="password">password</label></td>
            <td><input type="text" name="password" id="password" placeholder="Password"></td>
        </tr>
        <tr>
            <td><label for="authentificat_pass">Street</label></td>
            <td><input type="text" name="password_confirm" id="authentificat_pass" placeholder="Password confirm"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>

</form>
</body>
</html>

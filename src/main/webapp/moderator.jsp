<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1, h2 {
            color: #333;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        .message {
            color: green;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Admin Page</h1>

<%-- Afficher le message s'il est présent --%>
<% if (request.getAttribute("message") != null) { %>
<div class="message"><%= request.getAttribute("message") %></div>
<% } %>

<h2>Informations de moderateur :</h2>
<ul>
    <li>Username: <%= session.getAttribute("username") %></li>
</ul>

<h2>Supprimer un utilisateur :</h2>
<form method="post" action="deleteUser">
    <label for="username">Nom d'utilisateur :</label>
    <input type="text" id="username" name="username" required>
    <button type="submit">Supprimer</button>
</form>

<h2>Chat :</h2>
<form method="post" action="chat">
    <button type="submit">Accéder au chat</button>
</form>

</body>
</html>

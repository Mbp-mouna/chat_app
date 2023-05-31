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

        .admin-actions {
            margin-top: 20px;
        }

        .admin-actions label {
            display: block;
            margin-bottom: 5px;
        }

        .admin-actions button {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h1>Admin Page</h1>


<% if (request.getAttribute("message") != null) { %>
<div class="message"><%= request.getAttribute("message") %></div>
<% } %>

<h2>Informations de l'administrateur :</h2>
<ul>
    <li>Username: <%= session.getAttribute("username") %></li>
    <!-- Ajoutez d'autres informations de l'administrateur ici -->
</ul>

<h2>Supprimer un utilisateur :</h2>
<form method="post" action="deleteUser">
    <label for="username">Nom d'utilisateur :</label>
    <input type="text" id="username" name="username" required>
    <button type="submit">Supprimer</button>
</form>

<div class="admin-actions">
    <h2>Modifier le type d'utilisateur :</h2>
    <form method="post" action="changeUserType">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>
        <label for="usertype">Type d'utilisateur :</label>
        <select id="usertype" name="usertype">
            <option value="MODERATOR">Modérateur</option>
            <option value="USER">Utilisateur</option>
        </select>
        <button type="submit">Modifier</button>
    </form>
    <h2>Chat :</h2>
    <form method="post" action="chat">
        <button type="submit">Accéder au chat</button>
    </form>
</div>
</body>
</html>

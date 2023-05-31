<%@ page import="entities.Message" %>
<%@ page import="entities.ChatManager" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Chat</title>
	<meta http-equiv="refresh" content="6; URL=chat.jsp">
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f1f1f1;
		}

		.chat-container {
			max-width: 800px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
		}

		.chat-container h1 {
			font-size: 24px;
			margin-bottom: 20px;
		}

		.chat-messages {
			height: 300px;
			overflow-y: scroll;
			border: 1px solid #ccc;
			padding: 10px;
			margin-bottom: 10px;
		}

		.chat-message {
			margin-bottom: 10px;
		}

		.chat-message .timestamp {
			font-size: 10px;
			color: #999;
		}

		.chat-form {
			display: flex;
		}

		.chat-form input[type="text"] {
			flex: 1;
			padding: 10px;
			border: none;
			border-radius: 5px 0 0 5px;
			border: 1px solid #ccc;
		}

		.chat-form button {
			padding: 10px 15px;
			background-color: #4CAF50;
			color: #fff;
			border: none;
			border-radius: 0 5px 5px 0;
			cursor: pointer;
		}

		.chat-form button:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
<div class="chat-container">
	<h1>Chat</h1>

	<div class="chat-messages">
		<%-- Afficher les messages --%>
		<% for (Message message : ChatManager.getMessages()) { %>
		<div class="chat-message">
			<span><strong><%= message.getUser().getUsername() %>:</strong></span>
			<span><%= message.getContent() %></span>
			<span class="timestamp"><%= message.getTimestamp() %></span>
		</div>
		<% } %>
	</div>

	<form class="chat-form" action="chat" method="post">
		<input type="text" name="message" placeholder="Votre message">
		<button type="submit">Envoyer</button>
	</form>
	<h2>Supprimer un utilisateur :</h2>
	<form method="post" action="deleteUser">
		<label for="username">Nom d'utilisateur :</label>
		<input type="text" id="username" name="username" required>
		<button type="submit">Supprimer</button>
	</form>
</div>
</body>
</html>
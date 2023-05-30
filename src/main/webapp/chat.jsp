<%@ page import="entities.Message" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Chat</title>

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

		.message-list {
			list-style-type: none;
			padding: 0;
		}

		.message-list li {
			margin-bottom: 10px;
		}

		.message-list li .message {
			background-color: #f9f9f9;
			border-radius: 5px;
			padding: 10px;
		}

		.message-list li .author {
			font-weight: bold;
			margin-bottom: 5px;
		}

		.message-list li .timestamp {
			color: #888;
			font-size: 12px;
		}

		.add-message-form {
			margin-top: 20px;
		}

		.add-message-form textarea {
			width: 100%;
			padding: 10px;
			border-radius: 5px;
			resize: vertical;
		}

		.add-message-form input[type="submit"] {
			margin-top: 10px;
			padding: 5px 10px;
			background-color: #4CAF50;
			color: #fff;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}
	</style>
</head>
<body>
<div class="chat-container">
	<h1>Chat</h1>

	<ul class="message-list">
		<% List<Message> messages = (List<Message>) request.getAttribute("messages");
			if (messages != null && !messages.isEmpty()) {
				for (Message message : messages) { %>
		<li>
			<div class="message">
				<div class="author"><%= message.getAut() %></div>
				<div><%= message.getMessage() %></div>

			</div>
		</li>
		<% }
		} else { %>
		<li>No messages yet.</li>
		<% } %>
	</ul>

	<form class="add-message-form" action="chat" method="POST">
		<textarea name="message" rows="4" placeholder="Type your message here"></textarea><br>
		<input type="submit" value="Send">
	</form>
</div>
</body>
</html>

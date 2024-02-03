<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="xamp.VocabularyItem" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vocabulary Quiz</title>
</head>
<body>
    <h2>Vocabulary Quiz</h2>
    
    <ul>
        <% List<VocabularyItem> vocabularyList = (List<VocabularyItem>)request.getAttribute("vocabularyList");
           for (VocabularyItem item : vocabularyList) { %>
            <li><strong><%= item.getTerm() %></strong>: <%= item.getDefinition() %></li>
        <% } %>
    </ul>
    
    <!-- Add quiz functionality or other features as needed -->
</body>
</html>

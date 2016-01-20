<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${user.login} books</title>
</head>
<body>
<div class="gratings">
    <h1>${user.firstName} ${user.lastName} your books</h1>
</div>
<div class="actions">
    <div class="add-book">
        <g:link controller="user" action="createBookPage">Add new book</g:link>
    </div>
</div>
<div class="content">
    <table>
        <tr>
            <td>Title</td>
            <td>Author</td>
            <td>Pages count</td>
            <td>Priority</td>
        </tr>
        <g:each in="books" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.pagesCount}</td>
                <td>${book.priority}</td>
            </tr>
        </g:each>
    </table>
</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Activities</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        /* Table Styling */
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .timestamp {
            font-size: 0.9em;
            color: #666;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Activities</h2>
    <table>
        <thead>
        <tr>
            <th>Username</th>
            <th>Action</th>
            <th>Endpoint</th>
            <th>Timestamp</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="activity" items="${activities}">
            <tr>
                <td>${activity.username}</td>
                <td>${activity.action}</td>
                <td>${pageContext.request.contextPath}${activity.endpoint}</td>
                <td class="timestamp">${activity.timestamp}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

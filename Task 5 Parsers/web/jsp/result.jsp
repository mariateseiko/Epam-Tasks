<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Parsing result</title>
</head>
<body>
    <h1 align="center">${parser} parsing results</h1>
    <h2>Components</h2>
    <table>
        <tr >
            <td width="200">Name</td>
            <td width="200">Type</td>
            <td width="100">Origin</td>
            <td width="100">Price</td>
            <td width="100">Critical</td>
            <td width="100">Cooler</td>
            <td width="100">Power</td>
        </tr>
    <c:forEach items="${components}" var="component" varStatus="status">
        <tr>
            <td><c:out value="${component.name}"/></td>
            <td><c:out value="${component.deviceType}"/></td>
            <td><c:out value="${component.origin}"/></td>
            <td><c:out value="${component.price}"/></td>
            <td><c:out value="${component.critical}"/></td>
            <td><c:out value="${component.getType().getCooler()}"/></td>
            <td><c:out value="${component.getType().getPower()}"/></td>
        </tr>
    </c:forEach>
    </table>
    <h2>Peripherals</h2>
    <table>
        <tr>
            <td width="200">Name</td>
            <td width="200">Type</td>
            <td width="100">Origin</td>
            <td width="100">Price</td>
            <td width="100">Plug&Play</td>
            <td width="200">Group</td>
            <td width="100">Port</td>
        </tr>
    <c:forEach items="${peripherals}" var="peripheral" varStatus="status">
        <tr>
            <td><c:out value="${peripheral.name}"/></td>
            <td><c:out value="${peripheral.deviceType}"/></td>
            <td><c:out value="${peripheral.origin}"/></td>
            <td><c:out value="${peripheral.price}"/></td>
            <td><c:out value="${peripheral.plugAndPlay}"/></td>
            <td><c:out value="${peripheral.getType().getGroup()}"/></td>
            <td><c:out value="${peripheral.getType().getPort()}"/></td>
        </tr>
    </c:forEach>
    </table>
    <a href="index.jsp">Return to index</a>
</body>
</html>

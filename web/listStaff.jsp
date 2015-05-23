<%--
  Created by IntelliJ IDEA.
  User: Rashid
  Date: 23.05.2015
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>Show All Staff</title>
</head>
<body>
<table border=1>
  <thead>
  <tr>
    <th>ID</th>
    <th>№ п/п</th>
    <th>Фамилия</th>
    <th>Имя</th>
    <th>Отчество</th>
    <th>Дата рождения</th>
    <th>Должность</th>
    <th>Звание</th>
    <th>Подразделение</th>
    <th>Дата заключения контракта</th>
    <th>Срок контракта (в годах)</th>
    <th>Дата завершения контракта</th>
    <th colspan=2>Выберите действие</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${staff}" var="staff">
    <tr>
      <td><c:out value="${staff.id}" /></td>
      <td><c:out value="${staff.indexNum}" /></td>
      <td><c:out value="${staff.surname}" /></td>
      <td><c:out value="${staff.name}" /></td>
      <td><c:out value="${staff.patronymic}" /></td>
      <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${staff.dob}" /></td>
      <td><c:out value="${staff.idPost}" /></td>
      <td><c:out value="${staff.idRank}" /></td>
      <td><c:out value="${staff.idSubdiv}" /></td>
      <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${staff.contractDate}" /></td>
      <td><c:out value="${staff.contractPeriond}" /></td>

      <td><a href="StaffController?action=edit&id=<c:out value="${staff.id}"/>">Редактировать</a></td>
      <td><a href="StaffController?action=delete&id=<c:out value="${staff.id}"/>">Удалить</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="StaffController?action=insert">Добавить сотрудника</a></p>
</body>
</html>
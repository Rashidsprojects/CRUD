<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <link type="text/css"
        href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
  <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
  <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
  <title>Add new Staff</title>
</head>
<body>
<script>
  $(function() {
    $('input[name=dob]').datepicker();
  });
  $(function() {
      $('input[name=contractDate]').datepicker();
  });
</script>

<form method="POST" action='StaffController' name="frmAddStaff">
  ID : <input type="text" readonly="readonly" name="id"
                   value="<c:out value="${staff.id}" />" /> <br />
  № п/п : <input
        type="text" name="indexNum"
        value="<c:out value="${staff.indexNum}" />" /> <br />
  Фамилия : <input
        type="text" name="surname"
        value="<c:out value="${staff.surname}" />" /> <br />
  Имя : <input
        type="text" name="name"
        value="<c:out value="${staff.name}" />" /> <br />
  Отчество : <input
        type="text" name="patronymic"
        value="<c:out value="${staff.patronymic}" />" /> <br />
  Дата рождения : <input
        type="text" name="dob"
        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${staff.dob}" />" /> <br />
  Должность : <input
        type="text" name="idPost"
        value="<c:out value="${staff.idPost}" />" /> <br />
  Звание : <input
        type="text" name="idRank"
        value="<c:out value="${staff.idRank}" />" /> <br />
  Подразделение : <input
        type="text" name="idSubdiv"
        value="<c:out value="${staff.idSubdiv}" />" /> <br />
  Дата заключения контракта : <input
        type="text" name="dob"
        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${staff.contractDate}" />" /> <br />
  Срок контракта : <input type="text" name="contractPeriond"
                 value="<c:out value="${staff.contractPeriond}" />" /> <br /> <input
        type="submit" value="Submit" />

</form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
    <title>${title}</title>
    <script type="text/javascript" src='<c:url value="/web-resources/js/scripts.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/web-resources/js/jquery-1.11.3.min.js"/>'></script>
    <link href='<c:url value="/web-resources/css/style.css"/>' rel="stylesheet" type="text/css">
  </head>

  <body>
  <div id="wrapper">
    <div id="header">
      <h3><a href="/JavaWebFramework/">Home</a> ${title}</h3>
      <button onclick="create_OT();"> New </button>
      <button onclick="edit_OT(${object_type_id});"> Edit </button>
      <c:if test="${parentTypes == null}">
        <a href="/JavaWebFramework/admin/0">Root</a>
      </c:if>
      <c:if test="${parentTypes != null}">
        <c:forEach items="${parentTypes}" var="parentType">
          <a href="/JavaWebFramework/admin/${parentType.object_type_id}">${parentType.name}</a>
          > <!-- delimeter -->
        </c:forEach>
      </c:if>


    </div>
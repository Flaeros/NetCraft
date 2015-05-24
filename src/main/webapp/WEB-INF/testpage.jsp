<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello test Hibernate&Spring!</title>
</head>
<body>
  <h1>Flaeros here.</h1>
  <h3>Object Test: ${object.object_id} ${object.name} ${object.parent_id} ${object.object_type_id} </h3>
  <h3>Attribute Test: ${attribute.attr_id} ${attribute.name} ${attribute.attr_type_id} </h3>
  <h3>ObjectType Test: ${objectType.object_type_id} ${objectType.name} ${objectType.parent_id} </h3>

  <p>
    <h3>AttrObjectType Test:  </h3>

    <c:forEach items="${objectType.attributes}" var="attribute1">
      ${attribute1.attr_id} ${attribute1.name} ${attribute1.attr_type_id}
    </c:forEach>
    <c:forEach items="${attribute.objectTypes}" var="objectType1">
      ${objectType1.object_type_id} ${objectType1.name} ${objectType1.parent_id}
    </c:forEach>
  </p>

  <p>
  <h3>Param Zero Test:  </h3>

  <c:forEach items="${object.params}" var="param1">
    ${param1.value}
  </c:forEach>

  <h3>Param Test: ${param.value} ${param.attribute.name}</h3>

</body>
</html>

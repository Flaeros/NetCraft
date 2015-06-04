  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <jsp:include page="admin_header.jsp" />

  <div id="main">
    <div id="left">
      <!-- TODO: nice view -->
      <c:if test="${childTypes != null}">
        <c:forEach items="${childTypes}" var="childType">
          <a href="/JavaWebFramework/admin/${childType.object_type_id}">${childType.name}</a>
          <br/> <!-- delimeter -->
        </c:forEach>
      </c:if>
    </div>
    <div id="right">
      <div id="upper">
        <c:if test="${attributes != null}">
          <c:forEach items="${attributes}" var="attribute">
            <a href="#" id="attr_${attribute.attr_id}" class="attr_div_link" onclick="showAttribute(${attribute.attr_id}); return false;"><div class="attr_div">${attribute.name}</div></a>
            <br/> <!-- delimeter -->
          </c:forEach>
        </c:if>
      </div>
      <div id="bottom">
        <form id="edit_attr">
          <p>Attribute name: <input name="name" value=""/> </p>
          <p>Attribute type:
            <select name="attr_type_id">
              <option value="1">Text</option>
              <option value="2">Reference</option>
            </select>
          </p>
          <p>
            Attribute group: <input name="attr_group_id" value=""/>
          </p>
          <button onclick="saveAttribute()" >Save</button>
        </form>
      </div>
    </div>
  </div>

  <div class="b-popup" id="popup1">
    <div class="b-popup-content">
      Create new Object Type
      <form id="create_type">
        <input name="name"/>
        <button onclick="createObjectType(${object_type_id}); return false;">Create</button>
      </form>
    </div>
  </div>


  <jsp:include page="footer.jsp" />

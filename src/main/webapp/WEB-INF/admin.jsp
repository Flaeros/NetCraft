  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <jsp:include page="admin_header.jsp" />

  <div id="main">
    <div id="left">
      <!-- TODO: nice view -->
      <c:if test="${childTypes != null}">
        <c:forEach items="${childTypes}" var="childType">
          <a href="/JavaWebFramework/admin/${childType.object_type_id}">${childType.name}</a>
          <a href="javascript:deleteObjectType(${childType.object_type_id});"> X </a>
          <br/> <!-- delimeter -->
        </c:forEach>
      </c:if>
    </div>
    <div id="right">
      <div id="upper">
        <c:if test="${attributes != null}">
          <c:forEach items="${attributes}" var="attribute">
              <div>
                <a href="#" id="attr_${attribute.attr_id}" class="attr_div_link" onclick="showAttribute(${attribute.attr_id}); return false;"><div class="attr_div">${attribute.name}</div></a>
                <a href="javascript:deleteAttribute(${attribute.attr_id});"> X </a>
              </div>
          </c:forEach>
        </c:if>
      </div>
      <div id="bottom">
          <div style="float:left;">
            <form id="edit_attr" action="#">
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
              <button id="save_attribute" onclick="saveAttribute(${object_type_id}); return false;" >Save</button>
              <button id="create_attribute" onclick="createMyAttribute(${object_type_id}); return false;" >Create</button>
            </form>
              <button onclick="showCreateAttribute()" >New</button>
          </div>
          <div>
              <select id="types_to_bind">
                  <c:if test="${allTypes != null}">
                      <c:forEach items="${allTypes}" var="type3">
                          <option value="${type3.object_type_id}">${type3.name}</option>
                      </c:forEach>
                  </c:if>

              </select>
              <button onclick="bind_attr_to_type($('#types_to_bind').val()); return false;"> Bind </button>
          </div>
      </div>
    </div>
  </div>

  <div class="b-popup" id="popup1">
    <div class="b-popup-content">
      Create/Edit Object Type
      <form id="create_type">
        <input name="name"/>
        <button id="create_button" onclick="createObjectType(${object_type_id}); return false;">Create</button>
        <button id="save_button" onclick="saveObjectType(${object_type_id}); return false;">Save</button>
        <button onclick="PopUpHide(); return false;">Close</button>
      </form>
    </div>
  </div>


  <jsp:include page="footer.jsp" />

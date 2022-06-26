<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout>
    <jsp:attribute name="content">
        <a href="/todos/add" class="link">
          <button class="btn btn-primary">
            Add
          </button>
        </a>
        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Title</th>
              <th scope="col">Description</th>
              <th scope="col">Status</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${todos}" var="todo">
              <tr>
                <td>${todo.id}</td>
                <td>${todo.title}</td>
                <td>${todo.description}</td>
                <td>${todo.status}</td>
                <td><button class="btn btn-secondary">Edit</button></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
    </jsp:attribute>
</t:layout>
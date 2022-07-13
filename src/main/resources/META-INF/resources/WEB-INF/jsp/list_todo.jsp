<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:layout>
  <jsp:attribute name="content">
        <%@ include file="common/navbar.jspf" %>	
        <h3 class="text-center">List Todos</h3>
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
                <td>
                  <div class="row align-items-center justify-content-center">
                    <div class="col-md-4">
                      <a href="/todos/${todo.id}" class="btn btn-primary">Edit</a>
                    </div>
                    <form:form action="/todos/${todo.id}" method="DELETE" class="col-md-4 m-2">
                      <button type="submit" class="btn btn-danger">Delete</button>
                    </form:form>
                  </div>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <div class="d-flex justify-content-end">
          <a href="/todos/add" class="link btn btn-success px-4">
            Add Todo
          </a>
        </div>
    </jsp:attribute>
</t:layout>
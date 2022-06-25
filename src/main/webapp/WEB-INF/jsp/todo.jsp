<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:layout>
    <jsp:attribute name="content">
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <form:label path="title">Title</form:label>
                <form:input type="text" path="title"/>
                <form:errors path="title" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="targetDate">Target Date</form:label>
                <form:input type="text" path="targetDate"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>

            <input type="submit" class="btn btn-success"/>
        </form:form>
    </jsp:attribute>
</t:layout>
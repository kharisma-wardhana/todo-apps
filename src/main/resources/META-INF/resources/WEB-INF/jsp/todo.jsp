<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
    <jsp:attribute name="content">
        <div class="my-5 card py-4 px-5">
            <h2 class="text-center">Todo Details</h2>
            <form:form method="POST" modelAttribute="todo">
                <fieldset class="mb-3 row form-group">
                    <div class="col-md-6">
                        <form:label path="title">Title</form:label>
                    </div>
                    <div class="col-md-6">
                        <form:input class="form-control" type="text" name="title" id="title" required="required" path="title" />
                        <form:errors class="w-full d-inline-block" path="title" cssClass="text-warning"/>
                    </div>
                </fieldset>
    
                <fieldset class="mb-3 row">
                    <div class="col-md-6">
                        <form:label path="description">Description</form:label>
                    </div>
                    <div class="col-md-6">
                        <form:input class="form-control" type="text" name="description" id="description" path="description" />
                        <form:errors class="w-full d-inline-block" path="description" cssClass="text-warning"/>
                    </div>
                </fieldset>
    
                <fieldset class="mb-3 row">
                    <div class="col-md-6">
                        <form:label path="status">Target Date</form:label>
                    </div>
                    <div class="col-md-6">
                        <form:input class="form-control" type="text" name="status" id="status" path="status" />
                        <form:errors path="status" cssClass="text-warning"/>
                    </div>
                </fieldset>
    
                <div class="d-flex justify-content-center">
                    <button type="submit" class="col-md-4 btn btn-success">
                        Add
                    </button>
                </div>
            </form:form>
        </div>
    </jsp:attribute>
</t:layout>
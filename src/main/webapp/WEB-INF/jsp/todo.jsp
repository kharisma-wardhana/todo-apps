<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:attribute name="content">
        <h1>Enter Todo Details</h1>
        <form method="post">
            <fieldset class="mb-3">
                <label path="title">Title</label>
                <input type="text" name="title" id="title"/>
                <errors path="title" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <label path="description">Description</label>
                <input type="text" name="description" id="description/>
                <errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <label path="status">Target Date</label>
                <input type="text" name="status" id="status"/>
                <errors path="status" cssClass="text-warning"/>
            </fieldset>

            <input type="submit" class="btn btn-success"/>
        </form>
    </jsp:attribute>
</t:layout>
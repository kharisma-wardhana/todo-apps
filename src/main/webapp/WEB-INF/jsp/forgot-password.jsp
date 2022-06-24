<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:attribute name="content">
        <div class="rounded d-flex justify-content-center pt-5">
            <div class="col-md-4 col-sm-12 shadow-lg p-4 bg-light">
                <div class="text-center">
                    <h3 class="text-primary">Forgot Password</h3>
                </div>
                <form action="/auth/login" method="POST">
                    <div class="p-4">
                        <div class="input-group mb-3">
                            <span class="input-group-text bg-primary">
                                <img src="/img/user.svg" alt="user_icon" class="text-white" width="14" height="14">
                            </span>
                            <input type="text" name="username" id="username" class="form-control" placeholder="Username">
                        </div>
                        <div class="d-flex justify-content-between">
                            <a href="/auth/login" class="btn btn-secondary text-center mt-2">
                                Back
                            </a>
                            <button class="btn btn-primary text-center mt-2" type="submit">
                                Reset Password
                            </button>
                        </div>
                    </div>
                </form>
            </div>
    </jsp:attribute>
</t:layout>
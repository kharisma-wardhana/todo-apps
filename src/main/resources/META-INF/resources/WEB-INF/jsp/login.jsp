<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:attribute name="content">
        <div class="rounded d-flex justify-content-center pt-5">
            <div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light">
                <div class="text-center">
                    <h3 class="text-primary">Sign In</h3>
                </div>
                <form action="/auth/login" method="POST">
                    <div class="p-4">
                        <div class="input-group mb-3">
                            <span class="input-group-text bg-primary">
                                <img src="/img/user.svg" alt="user_icon" class="text-white" width="14" height="14">
                            </span>
                            <input type="text" name="username" id="username" class="form-control" placeholder="Username">
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text bg-primary">
                                <img src="/img/key.svg" alt="key_icon" class="text-white" width="14" height="14">
                            </span>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="d-flex justify-content-center">
                            <button class="btn btn-primary text-center mt-2" type="submit">
                                Login
                            </button>
                        </div>
                        <p class="text-center mt-5">Don't have an account?
                            <a href="/auth/register" id="link">
                                <span>Sign Up</span>
                            </a>
                        </p>
                        <a href="/auth/forgot-password" id="link">
                            <p class="text-center text-primary">
                                Forgot your password?
                            </p>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </jsp:attribute>
</t:layout>
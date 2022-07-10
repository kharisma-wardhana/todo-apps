<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:attribute name="content">
        <div class="rounded d-flex justify-content-center pt-5">
            <div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light">
                <div class="text-center">
                    <h3 class="text-primary">Create Account</h3>
                </div>
                <form action="/auth/register" method="POST" class="p-4">
                    <div class="input-group mb-3">
                        <span class="input-group-text bg-primary">
                            <img src="/img/user.svg" alt="user_icon" class="text-white" width="14" height="14">
                        </span>
                        <input type="text" class="form-control" placeholder="Username">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text bg-primary">
                            <img src="/img/email.svg" alt="key_icon" class="text-white" width="14" height="14">
                        </span>
                        <input type="email" class="form-control" placeholder="Email">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text bg-primary">
                            <img src="/img/key.svg" alt="key_icon" class="text-white" width="14" height="14">
                        </span>
                        <input type="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text bg-primary">
                            <img src="/img/key.svg" alt="key_icon" class="text-white" width="14" height="14">
                        </span>
                        <input type="password" class="form-control" placeholder="Confirm Password">
                    </div>
                    <div class="d-grid col-12 mx-auto">
                        <button class="btn btn-primary" type="submit"><span></span> Sign up</button>
                    </div>
                    <p class="text-center mt-3">Already have an account?
                        <a href="/auth/login" id="link">
                            <span>Sign in</span>
                        </a>
                    </p>
                </form>
            </div>
            <div class="col-md-4 d-sm-none d-md-block">
                <img src="https://images.unsplash.com/photo-1528716321680-815a8cdb8cbe"
                    class="d-block rounded w-auto h-100 img-fluid" alt="image">
            </div>
        </div>
    </jsp:attribute>
</t:layout>
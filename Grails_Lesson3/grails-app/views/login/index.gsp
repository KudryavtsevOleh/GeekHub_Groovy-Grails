<!doctype html>
<html>
    <head>
        <title>Welcome to Grails</title>
    </head>
    <body>
        <div class="main-container">
            <div class="register-container">
                <g:form controller="login" action="register">
                    <div class="login">
                        <label>Login</label>
                        <g:textField name="login"/>
                    </div>
                    <div class="password">
                        <label>Password</label>
                        <g:passwordField name="password"/>
                    </div>
                    <div class="first-name">
                        <label>First name</label>
                        <g:textField name="firstName"/>
                    </div>
                    <div class="last-name">
                        <label>Last name</label>
                        <g:textField name="lastName"/>
                    </div>
                    <div class="submit">
                        <g:submitButton name="submit" value="Register"/>
                    </div>
                </g:form>
            </div>
            <div class="login-container">
                <g:form controller="login" action="login">
                    <div class="login">
                        <label>Login</label>
                        <g:textField name="login"/>
                    </div>
                    <div class="password">
                        <label>Password</label>
                        <g:passwordField name="password"/>
                    </div>
                    <div class="submit">
                        <g:submitButton name="login" value="Login"/>
                    </div>
                </g:form>
            </div>
        </div>
    </body>
</html>

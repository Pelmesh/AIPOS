<#macro login path>
    <form action="${path}" method="post">
            <label> User Name : <input type="text" name="username"/> </label>
            <label> Password: <input type="password" name="password"/> </label>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input class="btn btn-primary" type="submit" value="Sign In"/>
    </form>
</#macro>
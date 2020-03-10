<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div  class="col-lg-2 col-md-3 col-sm-3 col-xs-6">
    Login page
    <@l.login "/login" />
    <a  class="btn btn-primary" href="/registration">Add new user</a>
    </div>
</@c.page>
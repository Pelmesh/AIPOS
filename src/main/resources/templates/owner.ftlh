<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
    <div>
        <form method="post">
            <input type="text" name="ownerName" placeholder="имя" />
            <input type="text" name="year" placeholder="год рождения">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <#list owners as owner>
        <div>
            <b>${owner.id_owner}</b>
            <span>${owner.ownerName}</span>
            <i>${owner.year}</i>
            <a href="/owner/${owner.id_owner}">edit</a>
        </div>
    </#list>
</@c.page>
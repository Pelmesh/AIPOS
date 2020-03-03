<#import "parts/common.ftlh" as c>
<@c.page>
    Owner Edit
    <form  method="post">
        <#list owners as owner>
            <input type="text" value="${owner.ownerName}" name="ownerName">
            <input type="text" value="${owner.year}" name="year">
            <input type="hidden" value="${owner.idOwner}" name="idOwner">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Изменить</button>
        </#list>
    </form>
</@c.page>

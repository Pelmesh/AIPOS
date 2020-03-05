<#import "parts/common.ftlh" as c>
<@c.page>
    Owner Edit
    <form  method="post">
        <#list owners as owner>
            <input type="text" value="${owner.ownerName}" name="ownerName" class="form-control mr-2">
            <input type="text" value="${owner.year}" name="year" class="form-control mr-2">
            <input type="hidden" value="${owner.idOwner}" name="idOwner" class="form-control mr-2">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn mr-2">Изменить</button>
        </#list>
    </form>
</@c.page>

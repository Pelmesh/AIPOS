<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/check" method="post">
        <div>
            <select name="engineNumber">
                <#list cars as car>
                <option >${car.engineNumber}</option>
                </#list>
            </select>
            <select name="ownerName">
                <#list owners as owner>
                <option>${owner.ownerName}</option>
                </#list>
            </select>
            <select name="result">
                <option>Прошел</option>
                <option>Не прошел</option>
            </select>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
    <#list checks as check>
    <div>
        <b>${check.id_check}</b>
        <span>${check.vin}</span>
        <i>${check.ownerName}</i>
        <strong>${check.result}</strong>
    </div>
    </#list>
</@c.page>
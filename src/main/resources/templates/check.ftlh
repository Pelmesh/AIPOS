<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/check" method="post" class="form-inline">
        <div  class="form-group mx-sm-3 mb-2 ml-2">
            <select name="vin" class="form-control mr-2">
                <#list cars as car>
                <option >${car.vin}</option>
                </#list>
            </select>
            <select name="ownerName" class="form-control mr-2 ">
                <#list owners as owner>
                <option>${owner.ownerName}</option>
                </#list>
            </select>
            <select name="result" class="form-control">
                <option>Прошел</option>
                <option>Не прошел</option>
            </select>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn mr-2 btn-primary">Добавить</button>
        </div>
    </form>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>VIN</th>
            <th>Имя владельца</th>
            <th>Рзультат</th>
        </tr>
        </thead>
        <tbody>
        <#list checks as check>
            <tr>
                <td>${check.id_check}</td>
                <td>${check.vin}</td>
                <td>${check.ownerName}</td>
                <td>${check.result}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
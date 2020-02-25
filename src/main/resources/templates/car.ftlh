<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
    <div>
        <form method="post">
            <input type="text" name="modelCar" placeholder="Модель" />
            <input type="text" name="vin" placeholder="Vin">
            <input type="text" name="number" placeholder="Номер">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <table>
    <#list cars as car>
        <tr>
            <td>${car.idCar}</td>
            <td>${car.modelCar}</td>
            <td>${car.vin}</td>
            <td>${car.number}</td>
            <td><a href="/carList/${car.idCar}">edit</a></td>
        </tr>
    </#list>
    </table>
</@c.page>
<#import "parts/common.ftlh" as c>
<@c.page>
<table>
    тупо лист
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
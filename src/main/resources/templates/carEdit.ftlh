<#import "parts/common.ftlh" as c>
<@c.page>
    Car Edit
    <form  method="post">
        <#list cars as car>
            <input type="text" value="${car.vin}" name="vin">
            <input type="text" value="${car.modelCar}" name="modelCar">
            <input type="text" value="${car.number}" name="number">
            <input type="hidden" value="${car.idCar}" name="idCar">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Изменить</button>
        </#list>
    </form>
</@c.page>

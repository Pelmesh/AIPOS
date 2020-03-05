<#import "parts/common.ftlh" as c>
<@c.page>
    Car Edit
    <form  method="post">
        <#list cars as car>
            <input type="text" value="${car.vin}" name="vin" class="form-control mr-2">
            <input type="text" value="${car.modelCar}" name="modelCar" class="form-control mr-2">
            <input type="text" value="${car.number}" name="number" class="form-control mr-2">
            <input type="hidden" value="${car.idCar}" name="idCar" class="form-control mr-2">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" lass="btn btn-primary mr-2">Изменить</button>
        </#list>
    </form>
</@c.page>

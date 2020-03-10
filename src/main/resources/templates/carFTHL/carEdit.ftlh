<#import "../parts/common.ftlh" as c>
<@c.page>
    Car Edit
    <form  method="post" class="form-inline">
        <#list cars as car>
            <input type="text" value="${car.vin}" name="vin" class="form-control mr-2 mb-2" >
            <input type="text" value="${car.modelCar}" name="modelCar" class="form-control mr-2 mb-2 ">
            <input type="text" value="${car.number}" name="number" class="form-control mr-2 mb-2 ">
            <input type="hidden" value="${car.idCar}" name="idCar" class="form-control mr-2 mb-2 ">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn mr-2 mb-2 ">Изменить</button>
            <a href="/carDelete/${car.idCar}" class="btn btn-primary mb-2 mr-2">Удалить</a>
        </#list>
    </form>
</@c.page>

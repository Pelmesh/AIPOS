<#import "../parts/common.ftlh" as c>
<@c.page>
    <div>
        <form method="post" class="form-inline">
            <div class="form-group mx-sm-3 mb-2 ml-2">
                <input class="form-control mb-2 mr-2" type="text" name="modelCar" placeholder="Модель" />
                <input class="form-control mb-2 mr-2" type="text" name="vin" placeholder="Vin">
                <input class="form-control mb-2 mr-2" type="text" name="number" placeholder="Номер">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Добавить</button>
            </div>
        </form>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Модель</th>
                <th>VIN</th>
                <th>Номер</th>
                <th>Изменить</th>
            </tr>
        </thead>
        <tbody>
            <#list cars as car>
                <tr>
                    <td>${car.idCar}</td>
                    <td>${car.modelCar}</td>
                    <td>${car.vin}</td>
                    <td>${car.number}</td>
                    <td><a href="/carList/${car.idCar}" class="btn btn-primary">Изменить</a></td>
                </tr>
            </#list>
        </tbody>
    </table>

</@c.page>
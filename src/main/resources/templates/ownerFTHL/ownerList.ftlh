<#import "../parts/common.ftlh" as c>
<@c.page>
    <table>
        тупо лист
        <#list owners as owner>
            <tr>
                <td>${owner.ownerName}</td>
                <td>${owner.year}</td>
                <td><a href="/carList/${owner.idOwner}">edit</a></td>
            </tr>
        </#list>
    </table>
</@c.page>
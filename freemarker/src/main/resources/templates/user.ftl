<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>地址</td>
            <td>性别</td>
        </tr>
        <#list users as u>
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.addr}</td>
                <td>
                   <#-- <#if u.gender==0>
                        男
                        <#elseif u.gender==1>
                        女
                        <#else >
                        其他
                    </#if>-->
                    <#switch u.gender>
                        <#case 0>男<#break >
                        <#case 1>女<#break >
                        <#default >未知
                    </#switch>
                </td>
            </tr>
        </#list>
    </table>
</body>
</html>
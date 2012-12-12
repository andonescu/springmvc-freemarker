<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <#--Greet the user with his/her name-->
    <h1>Welcome ${user?cap_first}!</h1>

    <p>We have ${animals?size} animals:</p>
    <ul>
    <#list animals as being>
        <li>${being.name?cap_first} for ${being.price} Euros</li>
    </#list>
    </ul>
</body>
</html>





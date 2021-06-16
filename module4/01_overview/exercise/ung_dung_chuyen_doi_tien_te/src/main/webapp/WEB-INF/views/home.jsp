<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/13/2021
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #aa{
            padding: 10px;
            font: 20px Arial;
            width: 70%;
        }
    </style>
</head>
<body>
<form action="abc" method="post">
    <table border="1">
        <tr>
            <th>Input money need to change</th>
            <th>Money</th>
            <th>To Money</th>
            <th>Result</th>
        </tr>
        <tr>
            <th>
                <input type="number" name="money" placeholder="Money need to change">
            </th>
            <th>
                <select name="typeMoney">
                    <option value="23000">VND</option>
                    <option value="1">USD</option>
                </select>
            </th>
            <th>
                <select name="typeMoney1">
                    <option value="1">USD</option>
                    <option value="23000">VND</option>
                </select>
            </th>
            <th>
                <input type="submit" value="Convert">
                <input type="text" name="result" readonly value="${result}">
            </th>
        </tr>
    </table>
</form>






<input type='currency' value="00" placeholder='Type a number & click outside' id="aa"/>
<script>
    var currencyInput = document.querySelector('input[type="currency"]')
    var currency = 'USD' // https://www.currency-iso.org/dam/downloads/lists/list_one.xml
    // format inital value
    onBlur({target:currencyInput})
    // bind event listeners
    currencyInput.addEventListener('focus', onFocus)
    currencyInput.addEventListener('blur', onBlur)
    function localStringToNumber( s ){
        return Number(String(s).replace(/[^0-9.-]+/g,""))
    }
    function onFocus(e){
        var value = e.target.value;
        e.target.value = value ? localStringToNumber(value) : ''
    }
    function onBlur(e){
        var value = e.target.value
        var options = {
            maximumFractionDigits : 2,
            currency              : currency,
            style                 : "currency",
            currencyDisplay       : "symbol"
        }

        e.target.value = value
            ? localStringToNumber(value).toLocaleString(undefined, options)
            : ''
    }
</script>




</body>
</html>

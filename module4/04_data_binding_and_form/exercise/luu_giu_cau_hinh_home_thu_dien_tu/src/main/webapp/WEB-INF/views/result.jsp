<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 6/17/2021
  Time: 6:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Your Setting</h3>
<b>Language:</b> ${setting.language}<br><br>
<b>Page Size:</b> ${setting.pagesize}<br><br>
<b>Spam filter:</b> ${setting.spamFilter}<br><br>
<b>Signature:</b> ${setting.signature}<br><br>
<a href="/setting"><button>Back to setting</button></a>

</body>
</html>

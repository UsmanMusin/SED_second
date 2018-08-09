<%--
  Created by IntelliJ IDEA.
  User: Усман
  Date: 13.06.2018
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" g_init="2210496201808081247"><head>
    <meta charset="utf-8">
    <title>Demo: dojo/request/xhr</title>
    <link rel="stylesheet" href="style.css" media="screen">
    <!--<link rel="stylesheet" href="../../_common/demo.css" media="screen" type="text/css">-->
</head>
<body>
<h1>Demo: dojo/request/xhr</h1>
<p>Click the button below to see dojo/request/xhr in action.</p>
<div>
    <button id="textButton">Request Text File</button>
</div>
<br><br>
<div id="resultDiv">
</div>
<script src="//ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js" data-dojo-config="isDebug: 1, async: 1, parseOnLoad: 1"></script>
<script>
    require(["dojo/dom", "dojo/on", "dojo/request", "dojo/domReady!"],
        function(dom, on, request){
            // Results will be displayed in resultDiv
            var resultDiv = dom.byId("resultDiv");

            // Attach the onclick event handler to the textButton
            on(dom.byId('textButton'), "click", function(evt){
                // Request the text file
                request.get("http://localhost:8080/war_exploded/rest/employee").then(
                    function(response){
                        // Display the text file content
                        resultDiv.innerHTML = "<pre>" + response + "</pre>";
                    },
                    function(error){
                        // Display the error returned
                        resultDiv.innerHTML = "<div class=\"error\">" + error + "<div>";
                    }
                );
            });
        }
    );
</script>


</body></html>
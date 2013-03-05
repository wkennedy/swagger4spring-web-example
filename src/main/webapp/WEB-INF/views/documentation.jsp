<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>
    <title>swagger4spring-web-example API documentation</title>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>

    <link href='<c:url value='/resources/swagger-ui-1.1.7/css/hightlight.default.css' />' media='screen'
          rel='stylesheet' type='text/css'/>
    <link href='<c:url value='/resources/swagger-ui-1.1.7/css/screen.css' />' media='screen' rel='stylesheet'
          type='text/css'/>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/jquery-1.8.0.min.js' />' type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/jquery.slideto.min.js' />'
            type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/jquery.wiggle.min.js' />'
            type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/jquery.ba-bbq.min.js' />'
            type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/handlebars-1.0.rc.1.js' />'
            type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/underscore-min.js' />' type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/backbone-min.js' />' type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/swagger.js' />' type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/swagger-ui.js' />' type='text/javascript'></script>
    <script src='<c:url value='/resources/swagger-ui-1.1.7/lib/highlight.7.3.pack.js' />'
            type='text/javascript'></script>

    <style type="text/css">
        .swagger-ui-wrap {
            max-width: 960px;
            margin-left: auto;
            margin-right: auto;
        }

        #message-bar {
            min-height: 30px;
            text-align: center;
            padding-top: 10px;
        }
    </style>

    <script type="text/javascript" th:inline="javascript">
        $(document).ready(function () {

            displaySwaggerDocuments();

            function displaySwaggerDocuments() {
                var url = '<c:url value="/documentation/resourceList"/>';
                window.swaggerUi = new SwaggerUi({
                    discoveryUrl: url,
                    dom_id: "swagger-ui-container",
                    supportHeaderParams: false,
                    supportedSubmitMethods: ['get', 'post', 'put'],
                    apiKey: "",
                    onComplete: function (swaggerApi, swaggerUi) {
                        if (console) {
                            console.log("Loaded SwaggerUI")
                            console.log(swaggerApi);
                            console.log(swaggerUi);
                        }
                        $('pre code').each(function (i, e) {
                            hljs.highlightBlock(e)
                        });
                    },
                    onFailure: function (data) {
                        if (console) {
                            console.log("Unable to Load SwaggerUI");
                            console.log(data);
                        }
                    },
                    docExpansion: "none"
                });

                window.swaggerUi.load();
            }
        });
    </script>
</head>

<body>

<div id="message-bar" class="swagger-ui-wrap">
    &nbsp;
</div>

<div id="swagger-ui-container" class="swagger-ui-wrap">

</div>

</body>

</html>
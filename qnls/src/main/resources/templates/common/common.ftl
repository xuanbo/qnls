<#-- html head -->
<#macro htmlHead title>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/assets/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="/assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <#nested>
    <title>
        ${title}
    </title>
</head>
</#macro>

<#-- html body -->
<#macro htmlBody>
<body>
    <#nested>
</body>
</html>
</#macro>


<#-- 引入分页paginator js -->
<#macro paginator>
<script type="text/javascript" src="/assets/bootstrap/js/bootstrap-paginator.js"></script>
</#macro>


<#-- copyright -->
<#macro copyright name date>
@${name} ${date} All rights reserved.
</#macro>
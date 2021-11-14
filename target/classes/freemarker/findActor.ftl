<#import  "partial/siteTemplate.ftl" as siteTemplate>
<head>
    <@siteTemplate.importantLibraries/>
</head>
<body>
<@siteTemplate.navbar currentPage="findActor"/>
Get:
<form method="get" action="/mvc/findActor">
	<input type="text" name="actorName" id="actorName">
	<input type="submit">
</form>
Post:
<form method="post" action="/mvc/findActor">
	<input type="text" name="actorName" id="actorName">
	<input type="submit">
</form>

<#if actor??>
	<p>${actor}</p>
</#if>
<@siteTemplate.footer/>
</body>

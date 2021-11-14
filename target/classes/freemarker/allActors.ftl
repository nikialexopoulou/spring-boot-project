<#import  "partial/siteTemplate.ftl" as siteTemplate>
<head>
    <@siteTemplate.importantLibraries/>
</head>
<body>
<@siteTemplate.navbar currentPage="allActors"/>

<table>
	<tr>
		<th>#</th>
		<th>Actor's name</th>
	</tr>
    <#list actors as actor>
		<tr>
			<td>${actor?counter}</td>
			<td>${actor.name}</td>
		</tr>
    </#list>
</table>

<@siteTemplate.footer/>
</body>

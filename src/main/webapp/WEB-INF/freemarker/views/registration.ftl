<@layout.mainLayout title="Registration LIst">

	<h1>Saved persons</h1>
	<h2>Add a new person: <a href="/registration/add">ADD</a></h2>
	
	<#if (persons?? && persons?size!=0)>
		
		<#list persons as person>
			<dl class="entireWidth">
				<dt>${person_index + 1}. ${person.lastName?lower_case?cap_first}.${person.firstName?lower_case?cap_first} <br/>${person.email} ${person.birthDate?date?string.long}</dt>
				<dd>Address: ${person.address} ${person.city} ${person.county}</dd>
			</dl>			
		</#list>
		
		<#else>
			<p>no person is stored</p>
	</#if>

</@layout.mainLayout>
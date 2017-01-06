<#macro formInput form path required=false type="text" showErrors=true containerClass="" labelClass="">
<@spring.bind path="${form}.${path}" />
<div class="${containerClass} ${getErrorsClass()}">
	<label for="${path?replace(".","_")}" class="${labelClass} <#if required==true>required</#if>"><@spring.message code="${form}.${path}.label"/> <#if required==true><span>*</span></#if> </label>
	<@input id=path name=spring.status.expression type=type/>
	${printErrors(showErrors)}
</div>
</#macro>

<#macro input id name type >
		<input  id="${id?replace('.', '_')}" name="${name}" type="${type}" value="${getCurrentValue()}"/>
</#macro>

<#macro checkbox form path required=false showErrors=true containerClass="" value="true">
<@spring.bind path="${form}.${path}" />
<div class="${containerClass}  ${getErrorsClass()}">
	<ul class="idealcheck">
		<li>
			<label for="${path?replace(".","_")}">
			   	<#assign checked>
		        	<#if spring.status.value?? && spring.status.value = value>checked="checked"</#if>
		    	</#assign>
				<input type="checkbox" name="${spring.status.expression}"  id="${path?replace(".","_")}" value="${value?trim}" ${checked}/>
				<input type="hidden" name="_${spring.status.expression}"/>
				<@spring.message code="${form}.${path}.label"/> <#if required==true>*</#if>
				${printErrors(showErrors)}
			</label>
		</li>
	</ul>
</div>
</#macro>

<#macro formSelect form path values required=false showErrors=true containerClass="" labelClass="">
<@spring.bind path="${form}.${path}" />
<div class="${containerClass}">
	<label for="${path?replace(".","_")}" class="${labelClass}" <#if required==true>required</#if>"><@spring.message code="${form}.${path}.label"/> <#if required==true>*</#if> </label>
	
	<select  id="${path?replace(".","_")}" name="${spring.status.expression}">
		<option value="">Choose</option>
	    <#if values?? && values?has_content >
	        <#list values as item>
	            <#if spring.status.value?exists && spring.status.value = item>
	                	<option value="${item}" selected="selected">${item}</option>
	                <#else>
	                    <option value="${item}">${item}</option>
	            </#if>
	        </#list>
	    </#if>
	</select>
	${printErrors(showErrors)}
</div>
</#macro>

<#function getErrorsClass>
	<#if spring.status.errorMessages?? && (spring.status.errorMessages?size > 0) >
		<#return "error"/>
	<#else>
		<#return ""/>
	</#if>
</#function>

<#function getCurrentValue>
 	<#if spring.status.value??>
        <#return spring.status.value?string/>
        <#else>
            <#return "" />
    </#if>
</#function>

<#function printErrors showErrors>
	<#assign errorsData>
	<#if showErrors == true>
        <#list spring.status.errorMessages as error>
            <span class="error">${error}</span>
        </#list>
    </#if>
    </#assign>
    <#return errorsData>
</#function>
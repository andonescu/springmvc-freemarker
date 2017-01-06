<@layout.mainLayout title="New Registration">
	
	<#import "/lib/macros.ftl" as  libs/>	

<form id="myform" class="idealform" method="post">
	<fieldset>
		<h1>New Registration</h1>
		
		<@libs.formInput form="registrationForm" path="email" labelClass="main-label" required=true/>
		<@tags.formInput form="registrationForm" path="password" type="password" labelClass="main-label" required=true/>
		<@tags.formInput form="registrationForm" path="passwordConf" type="password" labelClass="main-label" required=true/>
		
		<@tags.formInput form="registrationForm" path="lastName" labelClass="main-label" required=true/>
		<@tags.formInput form="registrationForm" path="firstName" labelClass="main-label" required=true/>
		<@tags.formInput form="registrationForm" path="birthDate" labelClass="main-label" required=true/>
		<@tags.formInput form="registrationForm" path="address" labelClass="main-label" required=true/>
		<@tags.formInput form="registrationForm" path="city" labelClass="main-label" required=true/>
		
		<@tags.formSelect form="registrationForm" path="county" values=dataService.counties required=true  />
		
		<@tags.checkbox form="registrationForm" path="agreement"  containerClass="fullWidth" required=true/>

		<div>
				<label class="main-label" style="width: 91px;">&nbsp;</label>
				<input type="submit" value="Submit">
		</div>
	</fieldset>
</form>

	
</@layout.mainLayout>
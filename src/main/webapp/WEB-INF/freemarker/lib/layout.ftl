<#macro mainLayout title="Spring Freemarker Project">
<!DOCTYPE html>
<html lang="en">
<head>
	<title>${title}</title>
	
	<link href="/resources/css/normalize.css" rel="stylesheet"/>
	<link href="/resources/css/idealforms/idealforms.css" rel="stylesheet"/>
	
	<link href="/resources/css/master.css" rel="stylesheet" media="screen"/>

</style>
</head>
<body>

	<@header/>
	
	<div class="content clearfix">
		<#nested/>
	</div>
	
	
	<@footer/>
	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="/resources/js/jquery.idealforms.js"></script>
	<script src="/resources/js/scripts.js"></script>
	<script src="/resources/js/plusone.js"></script>
</body>
</html>
</#macro>

<#macro header>
	<div id="header">
		<a id="logo" href="/en.aspx" title="Return to Endava Homepage">
		<h1>Endava</h1></a><div id="searchlang">
		<dl id="langsel"><dt><img src="/resources/images/C3BD4845B6C34C2A88F84CAAC060B889.ashx" alt="English" width="16" height="16">English</dt><dd><a href="/ro-RO.aspx">
		<img src="/resources/images/8C73137C2C854128909CF95A6FD5706B.ashx" alt="Română" width="16" height="16">Română</a></dd></dl></div><ul id="nav"><li class=""><a href="/en/Who-we-are.aspx">Who we are</a><ul><li class="first"><a href="/en/Who-we-are/Management-Team.aspx">Management Team</a></li><li class=""><a href="/en/Who-we-are/Key-Facts-And-Figures.aspx">Key Facts And Figures</a></li><li class=""><a href="/en/Who-we-are/Awards-Acreditations.aspx">Awards &amp; Accreditations</a></li><li class=""><a href="/en/Who-we-are/Endava-In-The-Community.aspx">Endava In The Community</a></li><li class="last"><a href="/en/Who-we-are/Compudava-Foundation.aspx">Compudava Foundation</a></li></ul></li><li class=""><a href="/en/What-we-do.aspx">What We Do</a><ul><li class="first"><a href="/en/What-we-do/Application-Development.aspx">Application Development</a></li><li class=""><a href="/en/What-we-do/Digital-Media.aspx">Digital media</a></li><li class=""><a href="/en/What-we-do/Independent-Testing.aspx">Independent Testing</a></li><li class=""><a href="/en/What-we-do/Application-Management.aspx">Application Management</a></li><li class="last"><a href="/en/What-we-do/Cloud.aspx">Cloud</a></li></ul></li><li class=""><a href="/en/Industries.aspx">Industries</a><ul><li class="first last"><a href="/en/Industries/CaseStudies.aspx">Case Studies</a></li></ul></li><li class=""><a href="/en/Our-Delivery-Model.aspx">Our Delivery Model</a><ul><li class="first"><a href="/en/Our-Delivery-Model/Global-Partnerships.aspx">Global Partnerships</a></li><li class="last"><a href="/en/Our-Delivery-Model/Our-Locations.aspx">Our Locations</a></li></ul></li><li class=""><a href="/en/News.aspx">News</a><ul><li class="first last"><a href="/en/News/Endava-in-the-News.aspx">Endava in the News</a></li></ul></li><li class=""><a href="/en/Careers.aspx">Careers</a><ul><li class="first"><a href="/en/Careers/Jobs-at-Endava.aspx">Job Opportunities</a></li><li class=""><a href="/en/Careers/Working-at-Endava.aspx">Working at Endava</a></li><li class=""><a href="/en/Careers/Graduate-Programme.aspx">Graduate Programme</a></li><li class="last"><a href="/en/Careers/Internship-Programme.aspx">Internship Programme</a></li></ul></li><li class="nodrop"><a href="/en/Contact-us.aspx">Contact us</a></li><li class="nodrop"><a href="http://blog.endava.com/" title="This link will open in a new window" target="_blank">Blog</a></li></ul>
	</div>
</#macro>

<#macro footer>
<div id="footer">
	<dl>
		<dt>Endava&nbsp;</dt>
		<dd><a href="/en/Who-we-are.aspx">Who we are</a></dd><dd><a href="/en/Who-we-are/Management-Team.aspx">Management Team</a></dd><dd><a href="/en/Who-we-are/Key-Facts-And-Figures.aspx">Key Facts And Figures</a></dd><dd><a href="/en/Who-we-are/Awards-Acreditations.aspx">Awards &amp; Accreditations</a></dd></dl><dl><dt>What we do&nbsp;
        </dt><dd><a href="/en/What-we-do/Application-Development.aspx">Application Development</a></dd><dd><a href="/en/What-we-do/Digital-Media.aspx">Digital media</a></dd><dd><a href="/en/What-we-do/Independent-Testing.aspx">Independent Testing</a></dd><dd><a href="/en/What-we-do/Application-Management.aspx">Application Management</a></dd><dd><a href="/en/What-we-do/Cloud.aspx">Cloud</a></dd></dl><dl><dt>How can we help&nbsp;
        </dt><dd><a href="/en/Industries.aspx">Industries</a></dd><dd><a href="/en/Industries/CaseStudies.aspx">Case Studies</a></dd><dd><a href="/en/Our-Delivery-Model.aspx">Our Delivery Model</a></dd></dl><dl><dt>Other&nbsp;
        </dt><dd><a href="/en/News.aspx">News</a></dd><dd><a href="/en/Other-pages/Terms-and-conditions.aspx">Terms and conditions</a></dd><dd><a href="/en/Other-pages/PrivacyStatement.aspx">Privacy Policy</a></dd><div class="contactbutton"><p>If you think we can help you</p><a href="/en/Contact-us.aspx"><span>Contact us</span></a></div></dl><p class="footnote">Copyright ©2012 Endava. All Rights Reserved.</p>
</div>
</#macro>
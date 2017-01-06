<#macro mainLayout title="Spring Freemarker Project">
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>${title}</title>

            <link href="/resources/css/normalize.css" rel="stylesheet"/>
        </head>
        <body>
            <@header/>

            <div class="content clearfix">
                <#nested/>
            </div>

            <@footer/>

        </body>
    </html>
</#macro>

<#macro header>
    <div id="header">
    </div>
</#macro>

<#macro footer>
    <div id="footer">
    </div>
</#macro>
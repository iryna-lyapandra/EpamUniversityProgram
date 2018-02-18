<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    table.tfmt {
                    border: 1px ;
                    }

                    td.colfmt {
                    border: 1px ;
                    background-color: yellow;
                    color: red;
                    text-align:right;
                    }

                    th {
                    background-color: #2E9AFE;
                    color: white;
                    }

                </style>
            </head>

            <body>
                <table class="tfmt">
                    <tr>
                        <th style="width:250px">name</th>
                        <th style="width:350px">energy</th>
                        <th style="width:250px">type</th>
                        <th style="width:250px">ingredients</th>
                        <th style="width:250px">value</th>
                        <th style="width:250px">production</th>

                    </tr>

                    <xsl:for-each select="candies/candy">

                        <tr>
                            <td class="colfmt">
                                <xsl:value-of select="name" />
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="energy" />
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="type" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="ingredients" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="value" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="production" />
                            </td>
                        </tr>

                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
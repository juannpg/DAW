<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <style>
          .info {
            background-color: green;
          }
          .ok {
            background-color: purple;
          }
          .nota {
            background-color: grey;
            font-weight: bold;
          }
        </style>
      </head>
      <body>
        <h2 style="text-align:center;">Clase</h2>
        <table>
            <tr><th colspan="2">Profesor</th></tr>
            <tr class="info"><td>Nombre</td><td><xsl:value-of select="clase/profesor/nombre"/></td></tr>
            <tr class="info"><td>Email</td><td><xsl:value-of select="clase/profesor/email"/></td></tr>
            <tr class="info"><td>Edad</td><td><xsl:value-of select="clase/profesor/edad"/></td></tr>

            <tr><th colspan="2">Aula</th></tr>
            <tr class="ok"><td>Codigo</td><td><xsl:value-of select="clase/aula/codigo"/></td></tr>
            <tr class="ok"><td>Grado</td><td><xsl:value-of select="clase/aula/grado"/></td></tr>

            <tr><th colspan="2">Nota Media</th></tr>
            <tr class="nota">
              <td>media</td>
              <td>
                <xsl:choose>
                  <xsl:when test="clase/media &lt;= 4">
                    <span style="color: red;"><xsl:value-of select="clase/media"/></span>
                  </xsl:when>
                  <xsl:when test="clase/media &gt; 4 and clase/media &lt;= 7">
                    <span style="color: orange;"><xsl:value-of select="clase/media"/></span>
                  </xsl:when>
                  <xsl:otherwise>
                    <span style="color: green;"><xsl:value-of select="clase/media"/></span>
                  </xsl:otherwise>
                </xsl:choose>
              </td>
            </tr>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
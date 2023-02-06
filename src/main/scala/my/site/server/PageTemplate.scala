package my.site.server


object PageTemplate {
  def genPage(content: String): String
  =
  s"""
     |<!DOCTYPE html>
     |<html lang="en">
     |<head>
     |    <meta charset="UTF-8">
     |</head>
     |<body>
     |      LOL it works
     |      See some content: $content
     |</body>
     |</html>
     |""".stripMargin
}

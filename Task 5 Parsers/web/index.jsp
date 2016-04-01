<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <p>Choose XML parser type</p>
  <div>
    <h2>${errorMessage}</h2>
    <form action="ParserServlet" method="post">
      <input type="radio" name="parser" value="DOM" checked>DOM <br>
      <input type="radio" name="parser" value="SAX">SAX <br>
      <input type="radio" name="parser" value="STAX">StAX <br>
      <table>
        <tr>
          <td><input type="submit" value="Parse" /></td>
        </tr>
      </table>
    </form>
  </div>
  </body>
</html>

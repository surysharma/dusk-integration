<html>
    <head></head>
    <title>Admin Registration</title>
    <body>
    <table>
        <tr>
            <form method="POST">
            <select name="command" multiple="true">
                <option value="light" label="Dark light">Dark light</option>
                <option value="Amber" label="Dark amber">Dark amber</option>
                <option value="dark" label="Dark dark">Dark dark</option>
                <option value="white" label="Dark White">Dark White</option>
            </select>
                <input type="hidden" name="id" value="${id}"/>
            <input type="submit" name="Hit me">
        </form>
        </tr>
    </table>

    </body>
</html>
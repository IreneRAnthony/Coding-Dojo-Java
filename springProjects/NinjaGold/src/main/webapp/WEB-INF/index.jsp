<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Ninja Money</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="row">
        <h3>Your Gold: <c:out value="${total}" /></h3>
        <form action="/clear" method="POST" class="reset">
            <input type="submit" name="submit" value="Reset gold" />
        </form>
    </div>
    <div class="row">
        <div class="place">
            <h3>Farm</h3>
            <p>(earns 10-20 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="farm"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="place">
            <h3>Cave</h3>
            <p>(earns 5-10 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="cave"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="place">
            <h3>House</h3>
            <p>(earns 2-5 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="house"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="place">
            <h3>Casino</h3>
            <p>(earns/takes 0-50 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="casino"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="activities">
            <h3>Activities:</h3>
            <ul>
               	<c:forEach var="activity" items="${activities}">
                <li><c:out value="${activity}" /></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>
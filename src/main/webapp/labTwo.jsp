<%-- 
    Document   : labTwo
    Created on : Feb 5, 2017, 12:13:40 PM
    Author     : Mike
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Calculator Lab</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="index.css">
        </head>

        <body>
            <div class="centerContainer">
                <header>
                    <h2>Calculator Lab</h2>
                </header>
                <main>
                    <div id="results">
                        <%
                            Object obj = request.getAttribute("area");
                            if (obj != null)
                            {
                                if (!obj.toString().equalsIgnoreCase("ERROR"))
                                {
                        %>
                                <div class="successContainer">
                                    <h4>Results</h4>
                                    <p>${area}</p>
                                </div>
                        <%
                                }
                                else 
                                {
                        %>
                                <div class="errorContainer">
                                    <h4>Error</h4>
                                    <p>Please check your values and try again.</p>
                                </div>
                        <%
                                }
                            }
                        %>
                        
                    </div>
                        
                    <div class="infoContainer">
                        <h4>Calculate Rectangle Area</h4>
                        <p>Use the following form to calculate the area of a rectangle from its length and width.</p>

                        <div class="rectangleContainer">
                            <form id="rectForm" name="rectForm" method="POST" action="CalcController">
                                <img src="images/rect.png">
                                <p>
                                    <label for="lengthString">Length in feet: </label>
                                    <input type="text" name="lengthString" id="lengthString">
                                </p>
                                <p>
                                <label for="widthString">Width in feet: </label>
                                <input type="text" name="widthString" id="widthString">
                                </p>
                                <input type="submit" value="Calculate">
                            </form>
                        </div>
                    </div>
                </main>
            </div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <script src="index.js"></script>
        </body>

        </html>
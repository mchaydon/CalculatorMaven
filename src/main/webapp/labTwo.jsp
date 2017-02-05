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
                    <div class="infoContainer">
                        <h4>Rectangle Area</h4>
                        <p>Use the following form to calculate the area of a rectangle from its length and width.</p>

                        <div class="rectangleContainer">
                            <form id="form1" name="form1" method="POST" action="CalcController">
                                <label for="lengthString" style="float: left; margin-left: 5em; padding-right: 1em;">Length in feet: </label>
                                <input type="text" name="lengthString" id="lengthString" style="float: left; width: 6.6em;">
                                <div class="rectangle"></div>
                                <label for="widthString" style="float: left; margin-top: 5.5em;margin-bottom: 1em;">Width in feet: </label>
                                <input type="text" style="float: left; width: 6.6em;" name="widthString" id="widthString">
                                <input type="submit" value="Calculate" style="float: left; clear: both; margin-left: 12em;">
                            </form>
                        </div>
                    </div>
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
                                    <p>The area is ${area} square feet.</p>
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
                </main>
            </div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <script src="index.js"></script>
        </body>

        </html>
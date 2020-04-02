<html>
    <head>
        <title>Test Quesstions</title>
    </head>
    <body>
        <form action="">
            <table>
                        <%
                        try{
                        connection = DriverManager.getConnection(connectionUrl+database, userid, password);
                        statement=connection.createStatement();
                        String sql ="select * from questions";
                        resultSet = statement.executeQuery(sql);
                        while(resultSet.next()){
                        %>
                        <tr colspan="2">
                            <td><%=resultSet.getRow()%>.<%=resultSet.getString("question") %></td>
                        </tr>
                        <tr>
                            <td><input type="radio" name=<%=resultSet.getInt("id") %> value=<%=resultSet.getString("opt1") %>>
                            <%=resultSet.getString("opt1") %></td>
                        </tr>
                        <tr>
                            <td><input type="radio" name=<%=resultSet.getInt("id") %> value=<%=resultSet.getString("opt2") %>>
                            <%=resultSet.getString("opt2") %></td>
                        </tr>
                        <tr>
                            <td><input type="radio" name=<%=resultSet.getInt("id") %> value=<%=resultSet.getString("opt3") %>>
                            <%=resultSet.getString("opt3") %></td>
                        </tr>
                        <tr>
                            <td><input type="radio" name=<%=resultSet.getInt("id") %> value=<%=resultSet.getString("opt4") %>>
                            <%=resultSet.getString("opt4") %></td>
                        </tr>
                        <%
                        }
                            connection.close();
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                    </table>
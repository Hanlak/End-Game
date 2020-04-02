<%@page import="java.util.*"%>
<html>
    <head>
        <title>Select</title>
    </head>
    <body>
        <form action="processConsumerQuestions" method="POST">
        <h1>Select your Answers</h1>
        <table>
            <%
            try{
            Map<Integer,String> questAndId = new LinkedHashMap<>();
            questAndId.put(1,"what do you prefer in theatre?");
            questAndId.put(2,"if he get a chance to travel where will he prefer?");
            Map<Integer,List<String>> idAndAns = new LinkedHashMap<>();
            List<String> opts = new ArrayList<>();
            opts.add("Popcorn");
            opts.add("IceCream");
            opts.add("Drink");
            opts.add("FrenchFries");
            idAndAns.put(1,opts);
            List<String> opts1 = new ArrayList<>();
            opts1.add("NorthIndia");
            opts1.add("southIndia");
            opts1.add("eastasia");
            opts1.add("europe");
            idAndAns.put(2,opts1);
            for(int i=1;i<=2;i++){
            %>
            <tr colspan="2">
                <td><%=i%>.<%=questAndId.get(i) %></td>
            </tr>
            <tr>
                <td><input type="radio" name=<%=i%> value=<%= idAndAns.get(i).get(0) %>>
                <%=idAndAns.get(i).get(0) %></td>
            </tr>
            <tr>
                <td><input type="radio" name=<%=i%> value=<%=idAndAns.get(i).get(1) %>>
                <%=idAndAns.get(i).get(1) %></td>
            </tr>
            <tr>
                <td><input type="radio" name=<%=i%> value=<%=idAndAns.get(i).get(2) %>>
                <%=idAndAns.get(i).get(2) %></td>
            </tr>
            <tr>
                <td><input type="radio" name=<%=i%> value=<%=idAndAns.get(i).get(3) %>>
                <%=idAndAns.get(i).get(3) %></td>
            </tr>
            <%
            }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </table>
        <button>Check Your Result</button>
        </form>
    </body>
</html>
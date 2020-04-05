<%@page import="java.util.*"%>
<html>
    <head>
        <title>Select</title>
        <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class ="container">
        <form action="processConsumerQuestions" method="POST">
        <h1>Choose Answers for all the options(mandatory)</h1>
        <div class="table-responsive">
        <table class ="table table-borderless">
            <%
            try{
                        Map<Integer,String> questAndId = new LinkedHashMap<>();
                        questAndId.put(1,"what does your prefer eating in the middle of movie?");
                        questAndId.put(2,"if your friend get a chance to travel where will he/she prefer?");
                        questAndId.put(3,"what makes your friend happy?");
                        questAndId.put(4, "what type of marriage your friend will prefer?");
                        questAndId.put(5,"In which below industry your friend loved to work?");
                        questAndId.put(6,"what your friend are believe in?");
                        questAndId.put(7,"what kind of guy your friend think he/she is?");
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
                        List<String> opts2 = new ArrayList<>();
                        opts2.add("Home");
                        opts2.add("work");
                        opts2.add("travel");
                        opts2.add("Movies");
                        idAndAns.put(3,opts2);
                        List<String> opts3 = new ArrayList<>();
                        opts3.add("Love");
                        opts3.add("Love&Arrange");
                        opts3.add("Arranged");
                        opts3.add("Bachelor");
                        idAndAns.put(4,opts3);
                        List<String> opts4 = new ArrayList<>(Arrays.asList("TechOrFinance","Manufacturer&Engineering","Entertainment","Agriculture"));
                        idAndAns.put(5,opts4);
                        List<String> opts5 = new ArrayList<>(Arrays.asList("God","MysticalForce","NoOne","Karma"));
                        idAndAns.put(6,opts5);
                        List<String> opts6 = new ArrayList<>(Arrays.asList("soft","active","tough","lazy"));
                        idAndAns.put(7,opts6);
            for(int i=1;i<=7;i++){
            %>
            <tbody>
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
            </tbody>
            <%
            }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </table>
        <button>Check Your Result</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        </div>
    </body>
</html>
<html>
    <head>
        <title>Your Name</title>
    </head>
	<body>
	<form action="/displayConsumerQuestions" method ="POST">
			<table>
			    <tr>
			        <td>How far do you know your friend</td>
			    </tr>
				<tr>
					<td>Enter UserName</td>
					<td><input type="text" placeholder="Enter Name" name="user" id="user"></td>
					<td><input type="hidden" name="parentUser" id="parentUser" value=${parentuser}></td>
				</tr>
				<tr colspan="2">
				    <td><button>Check</button></td>
				</tr>
			</table>
		</form>
        				${errmsg}
	</body>
</html>
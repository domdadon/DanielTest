<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %> 
	<form action="../signinservlet" method="post">
	<fieldset>
	<legend>${tb["legend"]}</legend>
	<table>
		<tbody>
		<tr>
			<th>
				<label for="email">Email:</label>
			</th>
			<td>
				<input 
					type="email" 
					name="email"
					id="email"
					size="40"
					maxlength="40"
					title="${tb['email_title']}"
					placeholder="${tb['email_placeholder']}"
					pattern=".{6,40}" 
					required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label for="password">
					${tb['password']}:
				</label>
			</th>
			<td>
				<input 
					type="password" 
					name="password"
					id="password"
					size="10"
					maxlength="10"
					title="${tb['password_title']}"
					placeholder="${tb['password_placeholder']}"
					pattern=".{6,10}" 
					required="required">
			</td>
		</tr>
		<tr>
			<td>
				<button type="submit">${tb["bt_send"]}</button>
			</td>
			<td>		
				<button type="reset">${tb["bt_reset"]}</button> 		
			</td>
		</tr>
	</tbody>
	</table>
	</fieldset>
	</form>
<%@ include file="footer.jspf" %>

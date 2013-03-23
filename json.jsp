<html>
<head>
	<title></title>
	<script type="text/javascript" src='js/jquery-1.9.1.js'></script>
	<script type="text/javascript">
	$(document).ready(function() {
		console.log('Document Loaded');
		data = '{"name":"Harsh","age":"10"}';
		// result = jQuery.parseJSON(data);
		// console.log(result.name);
		// data = '{"name":"John"}';
		var obj = jQuery.parseJSON(data);
		alert( obj.name === "John" );
	});
	</script>
</head>
<body>
	<div class='result'>Here will be result.</div>
</body>
</html>
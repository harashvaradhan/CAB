$(document).ready(function () {
	console.log('loaded');

	$('.menu ul li a').click(function () {
		if ($(this).attr('href')=='#view') {
			console.log('view ');
			$('#operation').load('ViewUsersServlet');
		};
		if ($(this).attr('href')=='#add') {
			console.log('Add ');
			$('#operation').load('./html/add_Admin.html');
		};
		if ($(this).attr('href')=='#modify') {
			console.log('modify');
		};
		if ($(this).attr('href')=='#remove') {
			console.log('remove ');
		};
		if ($(this).attr('href')=='#backup') {
			console.log('backup');
		};
		if ($(this).attr('href')=='#restore') {
			console.log('restore');
		};
		/*if ($(this).attr('href')=='#') {
			console.log(' ');
		};*/
	});
});
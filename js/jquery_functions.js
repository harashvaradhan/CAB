$(document).ready(function () {
	// console.log('loaded');
	$('#operation').load('ViewUsersServlet');
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
			$('#operation').load('./html/edit_Admin.html',function () {
				$('#edit_find').click(function () {
					var username = $('.username').val();
					console.log(username);
					jQuery.get('EditUserServlet', {username: username}, function(data, textStatus, xhr) {
					  console.log(data+textStatus+xhr);
					});
/*
					jQuery.ajax({
					  url: 'EditUserServlet',
					  type: 'GET',
					  data: {username: username},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete');
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log(data);
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					  }
					});*/
				});
			});
		};
		if ($(this).attr('href')=='#remove') {
			console.log('remove ');
			$('#operation').load('./html/remove_Admin.html',function () {
				$('#remove_find').click(function () {
					var username = $('.username').val();
					console.log(username);
					jQuery.get('../EditUserServlet', {username: username}, function(data, textStatus, xhr) {
					  console.log("Harsh");
					});

/*					jQuery.ajax({
					  url: '../EditUserServlet',
					  type: 'GET',
					  data: {username: username},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete');
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log(data);
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					  }
					});*/
				});
			});
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
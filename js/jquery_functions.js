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
					$('.record').hide();
					$('.error').hide();
				$('#edit_find').click(function () {
					$('.record').hide();
					$('.error').hide();
					var username = $('.username').val();
					console.log(username);
					jQuery.ajax({
					  url: './EditUserServlet',
					  type: 'GET',
					  data: {username : username},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    // console.log('complete');
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    // if (jQuery.type(data)) {};
						    var object = jQuery.parseJSON(data);
						    // console.log(object.username+','+object.fname+','+object.lname);
						    if (object.username ==="null") {
							    $('.error').show();
							} else {
								$('.record').show();
							    $('.id').val(object.username);
							    $('.fname').val(object.fname);
							    $('.lname').val(object.lname);
							}
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown);
					  }
					});

				});
			});
		};
		if ($(this).attr('href')=='#remove') {
			console.log('modify');
			$('#operation').load('./html/remove_Admin.html',function () {
				$('.record').hide();
				$('#remove_find').click(function () {
					var username = $('.username').val();
					console.log(username);
					jQuery.ajax({
					  url: './RemoveUserServlet',
					  type: 'GET',
					  data: {username : username},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    // console.log('complete');
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    // if (jQuery.type(data)) {};
					    console.log(jQuery.type(data));
					    var object = jQuery.parseJSON(data);
					    $('.record').show();
					    $('.id').val(object.username);
					    $('.fname').val(object.fname);
					    $('.lname').val(object.lname);
					    console.log(object.username+','+object.fname+','+object.lname);
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown);
					  }
					});

				});
			});
		};
/*		if ($(this).attr('href')=='#remove') {
			console.log('remove ');
			$('#operation').load('./html/remove_Admin.html',function () {
				$('#remove_find').click(function () {
					var username = $('.username').val();
					console.log(username);
					jQuery.ajax({
					  url: './RemoveUserServlet',
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
  					    console.log('error'+errorThrown);
					  }
					});
				});
			});
		};*/
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
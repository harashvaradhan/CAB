$(document).ready(function () {
	// console.log('loaded');
	//$('#operation').load('ViewUsersServlet');
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
		if ($(this).attr('href')=='#remove') {
			console.log('remove ');
		/*	$('#operation').load('./html/remove_Admin.html',function () {
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
			});*/
		};
		if ($(this).attr('href')=='#backup') {
			console.log('backup');
		};
		if ($(this).attr('href')=='#restore') {
			console.log('restore');
		};
	});
	$('.menu_admin ul li a').click(function () {
		if ($(this).attr('href')=='#viewemp') {
			console.log('viewemp');
			$('#operation').load('ViewEmpServlet');
		}
		if ($(this).attr('href')=='#addemp') {
			console.log('Addemp');
			$('#operation').load('./html/add_Emp.html');
		};
		if ($(this).attr('href')=='#modifyemp') {
			console.log('modifyemp');
			$('#operation').load('./html/edit_Emp.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'GET',
					  data: {emp_id: emp_id},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log(data);
					    var object = jQuery.parseJSON(data);
					    if (object.eid === "null") {
					    	$('.error').show();
					    } else{
					    	$('.record').show();
					    	$('.e_fname').val(object.fname);
					    	$('.e_lname').val(object.lname);
					    	$('.e_id').val(object.eid);
					    	$('.email_id').val(object.email);
					    	$('.address').val(object.addr);
					    	$('.mobile').val(object.mob);
					    	$('.locality').val(object.loc);
					    	$('.unit').val(object.unt);
					    	$('.gender').val(object.gen);
					    }
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end
				});
			});//load end
		};
		if ($(this).attr('href')=='#removeemp') {
			console.log('');
			$('#operation').load('./html/remove_Emp.html',function () {
				$('.record').hide();
				$('.error').hide();
					$('#remove_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'GET',
					  data: {emp_id: emp_id},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log(data);
					    var object = jQuery.parseJSON(data);
					    if (object.eid === "null") {
					    	$('.error').show();
					    } else{
					    	$('.record').show();
					    	$('.e_fname').val(object.fname);
					    	$('.e_lname').val(object.lname);
					    	$('.e_id').val(object.eid);
					    	$('.email_id').val(object.email);
					    	$('.address').val(object.addr);
					    	$('.mobile').val(object.mob);
					    	$('.locality').val(object.loc);
					    	$('.unit').val(object.unt);
					    	$('.gender').val(object.gen);
					    }
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end
				});
			});
		};
		if ($(this).attr('href')=='#viewdrv') {
			console.log('View Drivers');
			$('#operation').load('ViewDriverServlet')
		};
		if ($(this).attr('href')=='#adddrv') {
			console.log('add driver');
			$('#operation').load('./html/add_Driver.html');
		}
		if ($(this).attr('href')=='#modifydrv') {
			console.log('modify driver');
			$('#operation').load('./html/edit_Driver.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var d_id = $('.d_id').val();
					console.log(d_id)
					jQuery.ajax({
					  url: './EditDriverServlet',
					  type: 'GET',
					  data: {d_id: d_id},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log(data);
					    // {"did":"null","fname":"null","lname":"null","addr":"null","mob":"null"} 
					    object = jQuery.parseJSON(data);
					    if (object.did === "null") {
					    	$('.error').show();
					    } else {
							$('.record').show();
					    	$('.d_fname').val(object.fname);
					    	$('.d_lname').val(object.lname);
					    	$('.d_id').val(object.did);
					    	$('.address').val(object.addr);
					    	$('.mobile').val(object.mob);
					    	// $('.').val();
					    }
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end
				});
			});
		}
		if ($(this).attr('href')=='#removedrv') {
			console.log('');
			$('#operation').load('./html/.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					/*jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'POST',
					  data: {param1: 'value1'},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end*/
				});
			});
		}
		if ($(this).attr('href')=='#viewcab') {
			console.log('');
			$('#operation').load('./html/.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					/*jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'POST',
					  data: {param1: 'value1'},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end*/
				});
			});
		}
		if ($(this).attr('href')=='#addcab') {
			console.log('');
			$('#operation').load('./html/.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					/*jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'POST',
					  data: {param1: 'value1'},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end*/
				});
			});
		}
		if ($(this).attr('href')=='#removecab') {
			console.log('');
			$('#operation').load('./html/.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					/*jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'POST',
					  data: {param1: 'value1'},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end*/
				});
			});
		}
		if ($(this).attr('href')=='#') {
			console.log('');
			$('#operation').load('./html/.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					/*jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'POST',
					  data: {param1: 'value1'},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end*/
				});
			});
		}
		if ($(this).attr('href')=='#') {
			console.log('');
			$('#operation').load('./html/.html',function () {
				$('.record').hide();
				$('.error').hide();
				$('#edit_find').click(function () {
					var emp_id = $('.emp_id').val();
					console.log(emp_id)
					/*jQuery.ajax({
					  url: './EditEmpServlet',
					  type: 'POST',
					  data: {param1: 'value1'},
					  complete: function(xhr, textStatus) {
					    //called when complete
					    console.log('complete')
					  },
					  success: function(data, textStatus, xhr) {
					    //called when successful
					    console.log('successful')
					  },
					  error: function(xhr, textStatus, errorThrown) {
					    //called when there is an error
					    console.log('error'+errorThrown)
					  }
					});//ajax end*/
				});
			});
		}
	});
});
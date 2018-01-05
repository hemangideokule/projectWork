$(function() {
	// solving the active menu problem

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'New Products':
		$('#listProducts').addClass('active');
		break;
	case 'Sign in':
		$('#login').addClass('active');
		break;
	case 'Sign Up':
		$('#register').addClass('active');
		break;
	case 'My Account':
		$('#account').addClass('active');
		break;
	
	}

});
$(document).ready(function() {
	$("#form").validate({
		rules: {
			name: {
				required: true,
				rangelength: [6, 100]
			},
			email: {
				required: true,
				email: true,
				rangelength: [6, 60]
			},
			password: {
				required: true
			}
		},
		messages: {
			name: {
				required: "Empty field.",
				rangelength: "Must have 6-100 characters"	
			},
			email: {
				required: "Empty field.",
				email: "Please, insert a valid e-mail.",
				rangelength: "Must have 6-60 characters"
			},
			password: {
				required: "Empty field."
			}
		}
	});
});
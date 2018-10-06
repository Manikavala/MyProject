var Andromeda = {
	showPage: function(path, targetDiv) {
		var jqxhr = jQuery.post(path, function(data) {
			jQuery("#" + targetDiv).html(data);
		});
	},

	showMainPage:function() {
		var path="html/adminLogin.html";
		Andromeda.showPage(path, "loginChange");
	},
	showLoginPage:function(){
		var path="html/loginForm.html";
		Andromeda.showPage(path,"indexdiv");
	},
	showRegPage:function(){
		var path= "html/register.html";
		Andromeda.showPage(path, "indexdiv");
	},
	
	showReportPage:function(){
		var path= "html/report.html";
		Andromeda.showPage(path, "reportDiv");
	},
	showFeedbackPage:function(){
		var path= "html/feedback.html";
		Andromeda.showPage(path, "reportDiv");
	},
	
	
	//for storing value accessing entire application until unless we close the session 

	setSessionValue: function(key, value) {
		sessionStorage.setItem(key, value);
	},

	getSessionValue: function(key) {
		return sessionStorage.getItem(key);
	},

	removeSessionValue: function(key) {
		sessionStorage.removeItem(key);
	},

	showError: function(errorMessage) {
		var message = "<div class=\"alert alert-danger\"><strong>Error: </strong>"+errorMessage+"</div>"
		jQuery("#errorDiv").html(message);
	},

	logout: function() {
		var username = Andromeda.getSessionValue("userName") || "";
		
		Andromeda.setSessionValue("userName", null);
		Andromeda.setSessionValue("context", null);
		var data = {
			userName : username
		};

		Andromeda.post('auth/logout', data);
		Andromeda.setSessionValue("registrationId", '');
		console.log(Andromeda.getSessionValue("registrationId"));
		Andromeda.showLoginPage();
	},

	post: function(url, data) {
		
		var responseData = null;
	
		jQuery.ajax({
			url : url,
			type : 'post',
			data : JSON.stringify(data), // Stringified Json Object
			dataType : 'json',
			async : false, // Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
			cache : false, // This will force requested pages not to be cached by the browser
			processData : false, // To avoid making query String instead of JSON
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				responseData = data;
			}
		});
		console.log(responseData);
		return responseData;
	},
	
	// if we r in login f5 it will load same page
    isUserLoggedIn: function() {
		var username = Andromeda.getSessionValue("userName") || "";
		var password = Andromeda.getSessionValue("password") || "";
		var role="";
		var data = {
			userName : username,
			password : password
		};
		var response=Andromeda.post("login/user", data);
		role=response.responseObeject.role;
		console.log(role);
		role=1;
		return role;
	},
	showModulesPage: function() {
		var path = "/andromeda/modules";

		var jqxhr = jQuery.post(path, function(data) {
			Andromeda.showModules(data);
		});
	},
	
	loadModule: function(path) {
		var targetDiv = "amdContainerDiv";
		Andromeda.showPage(path, targetDiv);
	}
	
};

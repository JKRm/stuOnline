function update() {
	if (document.getElementById("t_button").value == "修改") {
		document.getElementById("tq_question").readOnly = false;
		document.getElementById("tq_question").className = "";
		var test_option = document.getElementById("test_option");
		var to_option = test_option.getElementsByTagName("input");
		for(var i = 0; i < to_option.length; ++i){
			to_option[i].readOnly = false;
			to_option[i].className = "";
		}
		document.getElementById("t_button").value = "保存";
	}
	else{
		var tq_question =  document.getElementById("tq_question").value;
		var test_option = document.getElementById("test_option");
		var to_option = test_option.getElementsByTagName("input");
		var length = to_option.length/2;
		var to_optionArray = new Array();
		var to_scoreArray = new Array();
		for(var i = 0; i < length; ++i){
			to_optionArray[i] = to_option[2*i].value;
			to_scoreArray[i] = to_option[2*i+1].value;
		}
		$.post("uploadTest/updateTest_questionAction.action", "toption_id=" + toption_id+"&to_optionArray="+to_optionArray+"&to_scoreArray="+to_scoreArray, function(data,
					statusCode) {
				if (data == "success") {
					document.getElementById("tq_question").readOnly = true;
					document.getElementById("tq_question").className = "readOnly";
					var test_option = document.getElementById("test_option");
					var to_option = test_option.getElementsByTagName("input");
					for(var i = 0; i < to_option.length; ++i){
						to_option[i].readOnly = true;
						to_option[i].className = "readOnly";
					}
					document.getElementById("t_button").value = "修改";
				}
			});
	}
}


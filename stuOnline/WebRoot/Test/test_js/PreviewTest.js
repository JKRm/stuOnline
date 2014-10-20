function update() {
	if (document.getElementById("t_explain") != null) {
		if (document.getElementById("t_button").value == "修改") {
			document.getElementById("t_name").readOnly = false;
			document.getElementById("t_name").className = "";
			document.getElementById("t_explain").readOnly = false;
			document.getElementById("t_explain").className = "";
			document.getElementById("t_button").value = "保存";
		} else {
			var t_name = document.getElementById("t_name").value;
			var t_explain = document.getElementById("t_explain").value;
			$.post("uploadTest/updateTestAction.action", "t_id=" + t_id
							+ "&t_name=" + t_name + "&t_explain=" + t_explain,
					function(data, statusCode) {
						if (data == "success") {
							document.getElementById("t_button").value = "修改";
							document.getElementById("t_name").className = "readOnly";
							document.getElementById("t_explain").className = "readOnly";
							document.getElementById("t_name").readOnly = true;
							document.getElementById("t_explain").readOnly = true;
						}
					});
		}
	} else {
		if (document.getElementById("t_button").value == "修改") {
			document.getElementById("t_name").readOnly = false;
			document.getElementById("t_name").className = "";
			document.getElementById("t_button").value = "保存";
		} else {
			var t_name = document.getElementById("t_name").value;
			$.post("uploadTest/updateTestAction.action", "t_id=" + t_id
							+ "&t_name=" + t_name ,
					function(data, statusCode) {
						if (data == "success") {
							document.getElementById("t_button").value = "修改";
							document.getElementById("t_name").className = "readOnly";
							document.getElementById("t_name").readOnly = true;
						}
					});
		}
	}

}

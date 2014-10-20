var num = 0;
function add() {
	to_optionid = "to_option"+num;
	to_scoreid = "to_score"+num;
	++num;
	var obj = document.getElementById("form_upload");
	var to_option = document.createElement("input");
	to_option.type = "text";
	to_option.name = "to_option";
	to_option.id = to_optionid;
	obj.appendChild(to_option);
	
	var to_score = document.createElement("input");
	to_score.type = "text";
	to_score.name = "to_score";
	to_score.id = to_scoreid;
	obj.appendChild(to_score);
	
	var p = document.createElement("p");
	obj.appendChild(p);
}


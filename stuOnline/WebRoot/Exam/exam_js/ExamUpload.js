function select() {
	var select = document.getElementById("e_type");
	var options = select.options;
	for (var i = 0; i < options.length; ++i) {
		var option = options[i];
		if (option.selected) {
			if (option.value == "选择") {
				var obj = document.getElementById("e_hiden");
				var to_option = document.createElement("input");
				to_option.type = "text";
				to_option.name = "eo_option";
				to_option.id = "eo_option";
				obj.appendChild(to_option);

				var t_button = document.createElement("input");
				t_button.type = "button";
				t_button.value = "添加选项";
				t_button.className = "button";
				t_button.onclick = function add() {
					var obj = document.getElementById("e_hiden");
					var to_option = document.createElement("input");
					to_option.type = "text";
					to_option.name = "eo_option";
					to_option.id = "eo_option";
					obj.appendChild(to_option);
					var p = document.createElement("p");
					obj.appendChild(p);
				};
				obj.appendChild(t_button);

				var p = document.createElement("p");
				obj.appendChild(p);
			}
		}
	}
}
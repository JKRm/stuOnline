function validation() {
	if (document.getElementById("t_name").value == "") {
		document.getElementById("t_name").style.border = '1px solid red';
		document.getElementById("t_name").focus();
		return false;
	}else{
		return true;
	}
}
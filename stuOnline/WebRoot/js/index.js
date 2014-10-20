function show(id) {
	var lis = document.getElementsByTagName('li');
	for(var i = 0; i < lis.length; i++){
		lis[i].style.visibility = 'hidden';
		lis[i].style.display = 'none';
    }
    var h2s = document.getElementsByTagName('h2');
	for(var i = 0; i < h2s.length; i++){
		h2s[i].className = '';
    }
    document.getElementById(id).getElementsByTagName('h2')[0].className = 'selected';
	var newLis = document.getElementById(id).getElementsByTagName('li');
	for(var i = 0; i < newLis.length; i++){
		newLis[i].style.visibility = 'visible';
		newLis[i].style.display = 'inline-block';
    }
}
function setLinkClickMethod() {
	var uls = document.getElementsByTagName('ul');
	for (var k=0; k<uls.length; ++k) {
		var lis = uls[k].getElementsByTagName('a');
		for (var i=0; i<lis.length; ++i) {
			var e = lis[i];
			e.onclick = function a(){
				for (var ik=0; ik<uls.length; ++ik) {
					var lis2 = uls[ik].getElementsByTagName('a');
					for (var ii=0; ii<lis2.length; ++ii) {
						lis2[ii].className = '';
					}
				}
				this.className = 'pointed';
			};
		}
	}
}
/**
 * 
 */

function check(){
	alert("여기는 05_param.js check() - 입력값 검증함수");
	
	if(document.frm.id.value == ""){
		alert("아이디를 입력해주세요");
		document.frm.id.focus();
		return false;
	} else if(document.frm.age.value == ""){
		alert("나이를 입력해주세요");
		document.frm.age.focus();
		return false;
	} else if(isNAN(document.frm.age.value)){
		alert("숫자로 입력해주세요");
		document.frm.age.focus();
		return false;
	} else {
		return true;
	}
}
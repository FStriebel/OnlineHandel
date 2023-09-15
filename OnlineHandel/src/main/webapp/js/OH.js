

function checkInput(myForm){
	var myFormOk = true;
		var useridOk = checkUserid(myForm.bname.value);
		if (!useridOk) myFormOk = false;
	
		var passwordOk = checkPassword(myForm.password.value);
		if (!passwordOk) myFormOk = false;
	
		if (!checkAge(myForm.age.value)) myFormOk = false;
		if (!checkEmail(myForm.email.value)) myFormOk = false;
		if(!checkVorname(myForm.vorname.value)) myFormOk = false;
		if(!checkNachname(myForm.nachname.value)) myFormOk = false;
	
	return myFormOk;
}

function checkUserid(myUserid){
	var myMsgField = document.getElementById("useridMsg");
	if (myUserid){
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Benutzername darf nicht leer sein";
		return false;
	}
}
function checkPassword(myPassword){
	var myMsgField = document.getElementById("passwordMsg");
	if (myPassword){
		if (myPassword.length >= 6){
			myMsgField.innerText = "";
			return true;
		}else{
			myMsgField.innerText = "Passwort muss mindestens 6 Zeichen haben";
			return false;
		}
	}else{
		myMsgField.innerText = "Passwort darf nicht leer sein";
		return false;
	}
}
function checkAge(myAge){
	var myMsgField = document.getElementById("ageMsg");
	if (myAge){
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Alter darf nicht leer sein";
		return false;
	}
}
function checkEmail(myEmail){
	var myMsgField = document.getElementById("emailMsg");
	if (myEmail){
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Email darf nicht leer sein";
		return false;
	}
}

function checkVorname(myVorname){
	var myMsgField = document.getElementById("vornameMsg");
	if(myVorname) {
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Vorname darf nicht leer sein";
		return false;
	}
}

function checkNachname(myNachname){
	var myMsgField = document.getElementById("nachnameMsg");
	if(myNachname) {
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Nachname darf nicht leer sein";
		return false;
	}
}




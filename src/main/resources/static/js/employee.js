function checkForm(){

    const employeeId=document.querySelector("#employeeId");
    const name=document.querySelector("#name");
    const department=document.querySelector("#department");
    const contact=document.querySelector("#contact");

    if(employeeId.value.trim()==""){
        alert("사번을 입력하세요.");
        employeeId.focus();
        return false;
    }

    if(name.value.trim()==""){
        alert("이름을 입력하세요.");
        name.focus();
        return false;
    }

    if(department.value.trim()==""){
        alert("부서를 입력하세요.");
        department.focus();
        return false;
    }

    if(contact.value.trim()==""){
        alert("연락처를 입력하세요.");
        contact.focus();
        return false;
    }

    return true;

}
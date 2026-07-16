const params= new URLSearchParams(location.search);
const message= params.get("message");

if(message === "insert"){
    alert("등록이 완료되었습니다.");
}

if(message === "update"){
    alert("수정이 완료되었습니다.");
}

if(message === "delete"){
    alert("삭제가 완료되었습니다.");
}
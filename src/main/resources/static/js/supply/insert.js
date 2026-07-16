const itemNameCheckBtn= document.querySelector("#itemNameCheckBtn");

itemNameCheckBtn.addEventListener("click", () => {
    const itemName = document.querySelector("[name='itemName']").value.trim();
    const message = document.querySelector("#itemNameMessage");

    if(itemName === ""){
        message.textContent = "비품명을 입력해 주세요.";
        return;
    }

    fetch(`/supplies/itemNameCheck?itemName=${itemName}`)
        .then(response => response.json())
        .then(result => {

            if(result){
                message.textContent = "등록 가능한 비품입니다.";
                message.style.color = "blue";
            }else{
                message.textContent = "이미 등록된 비품입니다.";
                message.style.color = "red";
            }

        });
})
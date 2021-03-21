document.getElementById("buttonSend").addEventListener("click", validaFormulario)

function validaFormulario(){
  if (document.getElementById("fname").value != "" && document.getElementById("cpfId").value != "") {
  alert("Obrigada!")
  }else{
    alert("Ops!Preencha os campos Nome e CPF.") 
  }  
}
//datalabel paging
window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});


/* modal open시 data 할당 */
const menuModal = document.getElementById('menuRegistModal')
menuModal.addEventListener('show.bs.modal', event => {
  const button = event.relatedTarget
  const parentIdx = button.getAttribute('data-bs-parentidx')
  const depth = button.getAttribute('data-bs-depth')
  
  const inputParentIdx = menuModal.querySelector('#inputParentIdx')
  const inputDepth = menuModal.querySelector('#inputDepth')

  inputParentIdx.value = parentIdx
  inputDepth.value=depth
})


createMenu = function(){
	$.ajax({
	  url: "/api/menu/regist.do",
	  type: "POST",
	  data: $("#menuForm").serialize(),
	  dataType: "JSON",
	  success: function( res ) {
	    console.log(JSON.stringify(res));
	    if(res.result == "false"){
	    	alert(res.message);
	    }else{
	    	location.reload();
	    }
	  }
	});
}
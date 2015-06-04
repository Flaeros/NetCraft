function showAttribute(id){
  $.get( "attr_data/" + id, function( data ) {
    populate('#edit_attr', data);
  });
}

function populate(frm, data) {
  $.each(data, function(key, value){
    $('[name='+key+']', frm).val(value);
  });
  $( frm ).show();
}

function createObjectType(parent_id){
  $("#popup1").hide();

  var name = $('#create_type input').val();
    console.log("name  = " + name);
    $.ajax({
        url: "create_type",
        method: "post",
        data: { name: name, parent_id: parent_id }
    }).done(function(data) {
        setTimeout(
            function()
            {
                console.log("type created: " + data.object_type_id);
            }, 5000);
        location.reload();
    });
}

//Функция отображения PopUp
function PopUpShow(){
  $("#popup1").show();
}
//Функция скрытия PopUp
function PopUpHide(){
  $("#popup1").hide();
}
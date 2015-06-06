var current_attr_id;

function showAttribute(id){
  $.get( "attr_data/" + id, function( data ) {
    populate('#edit_attr', data);
  });
    current_attr_id = id;
}

function showCreateAttribute(){
    $( '#edit_attr' ).show();
    $('#save_attribute').hide();
    $('#create_attribute').show();
}

function populate(frm, data) {
  $.each(data, function(key, value){
    $('[name='+key+']', frm).val(value);
  });
  $( frm ).show();
    $('#save_attribute').show();
    $('#create_attribute').hide();
}

function createMyAttribute(object_type_id){
    var name = $('#edit_attr input[name=name]').val();
    var attr_group_id = $('#edit_attr input[name=attr_group_id]').val();
    var attr_type_id = $( "#edit_attr select option:selected").val();

    $.ajax({
        url: "create_attr",
        method: "post",
        data: {name: name, attr_group_id: attr_group_id, attr_type_id:attr_type_id, object_type_id:object_type_id}
    }).done(function(data) {
        location.reload();
    });
}

function saveAttribute(object_type_id){
    var name = $('#edit_attr input[name=name]').val();
    var attr_group_id = $('#edit_attr input[name=attr_group_id]').val();
    var attr_type_id = $( "#edit_attr select option:selected").val();

    $.ajax({
        url: "save_attr",
        method: "post",
        data: {attr_id:current_attr_id, name: name, attr_group_id: attr_group_id, attr_type_id:attr_type_id}
    }).done(function(data) {
        location.reload();
    });
}

function deleteAttribute(attr_id){
    console.log("delete attr" + attr_id);

    $.ajax({
        url: "delete_attr",
        method: "post",
        data: { attr_id: attr_id }
    }).done(function(data) {
        location.reload();
    });

    return false;
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
        location.reload();
    });
}

function saveObjectType(object_type_id){
    $("#popup1").hide();

    var name = $('#create_type input').val();
    console.log("name  = " + name);
    $.ajax({
        url: "save_type",
        method: "post",
        data: { name: name, object_type_id: object_type_id }
    }).done(function(data) {
        location.reload();
    });
}

function deleteObjectType(object_type_id){
    console.log("delete object_type" + object_type_id);

    $.ajax({
        url: "delete_type",
        method: "post",
        data: { object_type_id: object_type_id }
    }).done(function(data) {
        location.reload();
    });

    return false;
}

function create_OT(){
    PopUpShow();
    $('#create_button').show();
    $('#save_button').hide();
}

function edit_OT(){
    PopUpShow();
    $('#create_button').hide();
    $('#save_button').show();

}

function bind_attr_to_type(object_type_id) {
    if (current_attr_id > 0) {
        console.log("current_attr_id = " + current_attr_id);
        console.log("bind_attr_to_type" + object_type_id);

        $.ajax({
            url: "bind_attr_to_type",
            method: "post",
            data: {object_type_id: object_type_id, attr_id:current_attr_id}
        }).done(function (data) {
            location.reload();
        });
    }

    return false;
}

//Функция отображения PopUp
function PopUpShow(){
  $("#popup1").show();
}
//Функция скрытия PopUp
function PopUpHide(){
  $("#popup1").hide();
}
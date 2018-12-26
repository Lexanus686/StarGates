function createSystem() {
    $("#but1").toggle("show");
    $("#butchoose").hide();
    $('#selectId').hide();
    var msg = $("#selectId").val();
    $.ajax({
        url: 'getPlanetSystem',
        type: 'GET',
        data: ({
            myString: msg
        }),
        success: function (data) {
            //alert(data);
            retrive();
            //alert(data);
            //notify();
        },
        error: function (e) {
            //alert(e.text);
            //alert(e);
        }
    });
}
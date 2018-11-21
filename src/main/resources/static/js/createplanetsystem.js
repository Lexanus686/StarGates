function createSystem() {
//TODO HERE
    $("#but1").toggle("show");
    var msg = $("#selectId").val();
    $.ajax({
        url: 'getPlanetSystem',
        type: 'GET',
        data: ({
            myString: msg
        }),
        success: function (data) {
            //alert(data);
        },
        error: function (e) {
            alert(e.text);
            alert(e);
        }
    });
}
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
            alert(data);
            retrive();
            notify();
        },
        error: function (e) {
            alert(e.text);
            alert(e);
        }
    });
}

function notify() {
    var x = 0;
    $.ajax({
        url: 'loader',
        type: 'GET',
        data: ({
            sign: x
        }),
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            alert(e.text);
            alert(e);
        }
    })
}
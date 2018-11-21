function call() {
    //взятие данных с http страницы

    //dataType : 'json',
    //contentTYpe: 'application/json',
    //mimeType: 'application/json',

    var arr = document.getElementsByClassName('ui-draggable ui-draggable-handle');
    var msg = [];
    msg[0] = $("#name").val();
    msg[1] = $("#isVisiting").prop("checked");
    msg[2] = $("#temperature").val();
    msg[3] = $("#gravitation").val();
    msg[4] = $("#stargate").val();
    msg[5] = $("#location option:selected").text();
    msg[6] = arr.item(0).id;
    msg[7] = arr.item(0).className;
    msg[8] = arr.item(0).getAttribute('style');

    $.ajax({
        url: 'getPlanet',
        type: 'GET',
        data: ({
            myArray: msg
        }),
        success: function (data) {
            // alert(data);
        },
        error: function (e) {
            alert(e.text);
            alert(e);
        }
    });


    // for (i = 0; i < array.length; i++) {
    //     console.log(array.item(0));
    // }
    //
    // console.log(array);
    // console.log($("#planet").children("#circle"));
    // console.log($("#circle").css(["position", "backgroundColor", "left", "top"]));

    $(function () {
        $('.closebutton').click(function () {
            $('.modal-shadow').hide();
            $('.modal-window').hide();
        });
    });
}
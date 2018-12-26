function call() {
    //взятие данных с http страницы

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
        url: 'addPlanet',
        type: 'GET',
        data: ({
            myArray: msg
        }),
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            //alert(e.text);
        }
    });

    $(function () {
        $('.closebutton').click(function () {
            $('.modal-shadow').hide();
            $('.modal-window').hide();
        });
    });
}
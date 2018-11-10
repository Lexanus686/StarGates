function call() {
    //взятие данных с http страницы
    //$.ajax.post()

    var msg1 = $("#name").val();
    var msg2 = $("#isVisiting").val();
    var msg3 = $("#temperature").val();
    var msg4 = $("#gravitation").val();
    var msg5 = $("#stargate").val();

    $.ajax({
        url: 'getPlanet',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data: ({
            text: msg1
        }),
        success: function (data) {
            alert("33");
        },
        error: function (e) {
            alert(e.text);
            alert(e);
        }
    });

    $(function () {
        $('.closebutton').click(function () {
            $('.modal-shadow').hide();
            $('.modal-window').hide();
        });
    });
}
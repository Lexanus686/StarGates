$(function () {
    //появление фигуры при нажатии кнопки
    $(".circle").draggable();
    $("#but1").click(function (e) {
        e.preventDefault();
        var circle = $('<div id="circle"></div>').css('background', 'rgb('
        + (Math.floor(Math.random() * 256)) + ','
        + (Math.floor(Math.random() * 256)) + ','
        + (Math.floor(Math.random() * 256)) + ')');
        circle.draggable();
        $('#planet').prepend(circle);

        //появление формы при нажатии кнопки

        $('.modal-shadow').show();
        $('.modal-window').show();

        $('.close').click(function () {
            $('.modal-shadow').hide();
            $('.modal-window').hide();
        });

        $('.closebutton').click(function () {
            $('.modal-shadow').hide();
            $('.modal-window').hide();
        });

    });
});




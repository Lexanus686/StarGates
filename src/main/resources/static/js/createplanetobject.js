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

        $('.modal-window').show();
        $('.modal-shadow').show();

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

function retrive() {
    //alert("x");
    msg = "getPlanets";
    $.ajax({
        url: 'getAllPlanets',
        type: 'GET',
        data: ({
            myMessage: msg
        }),
        success: function (data) {
            //alert("YES");
            //TODO TOP LEVEL: UNDERSTAND HOW TO PLACE ALL OF THEM TOWARDS EACH OTHER CORRECTLY (id:0)
            var offset = 120;
            var count = 0;
            var top = 0;
            for (j = 0; j < data.length; j++) {
                var str = "";
                for (i = 0; i < data[j].length; i++)
                    str += data[j][i];

                var check = 0, flag = 0;
                while (flag !== 7) {
                    if (check === 0) check = 1;
                    check = str.indexOf(" ", check + 1);
                    flag++;
                }

                var lol = str.slice(str.lastIndexOf("["), str.length);

                var id = lol.slice(1, lol.indexOf(","));

                var StyleName = lol.slice(lol.indexOf("background"), lol.length - 1);
                StyleName = StyleName.replace(/\s+/g, '');

                //TODO (id:0)
                // top = parseInt(StyleName.slice(StyleName.indexOf("top") + 4, StyleName.lastIndexOf(";")), 10);
                //
                // alert(top);
                //
                // var tmp = top.toString();
                // alert(tmp);
                //
                // alert(offset*count);
                // alert(top+offset*count);
                //
                // top = top + offset*count;
                // alert(top);
                // if (count === 0)
                //     count = 2;
                // else count++;
                // alert(count);
                // StyleName = StyleName.replace(tmp, top.toString());
                //
                // alert(tmp + ' ' + top);

                var divElement = $("<div id = " + id + " style = " + StyleName + ">");
                divElement.draggable();
                $('#planet').append(divElement);
            }
        },
        error: function (e) {
            //alert(e.text);
        }
    });
}
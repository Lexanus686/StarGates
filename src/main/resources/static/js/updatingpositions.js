function updating() {
    var arr = document.getElementsByClassName('ui-draggable ui-draggable-handle');

    var update = [];
    for (i = 0; i < arr.length; i++) {
        update[i] = arr.item(i).getAttribute('style').toString();
    }

    $.ajax({
        url: 'updatePlanet',
        type: 'GET',
        data: ({
            myHTMLArray: update
        }),
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            alert(e);
        }
    });
}
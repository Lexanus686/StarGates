function createCircle() {
    var planetCircle = document.getElementById("planetCircle");
    var div = document.createElement("div");
    div.id = 'circle';
    div.className = "ui-draggable ui-draggable-handle ui-draggable-dragging";
    planetCircle.appendChild(div);
    planetCircle.appendChild(document.createElement("br"));
}


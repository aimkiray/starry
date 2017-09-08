function checkRegular() {
    var regulars;
    if (arguments[0] == 'adminname') {
        regulars = /^[\u4e00-\u9fa5]{1,6}$/;
    }
    if(arguments[0] == 'adminpassword') {
        regulars = /^[a-z|A-Z|0-9]{6,12}$/;
    }
    if (regulars.test(arguments[1].value)) {
        arguments[1].parentNode.parentNode.lastElementChild.innerHTML = "<span style='color: green'>&nbsp;OK</span>";
    } else {
        arguments[1].parentNode.parentNode.lastElementChild.innerHTML = "<span style='color: red'>&nbsp;Fails</span>";
    }
}
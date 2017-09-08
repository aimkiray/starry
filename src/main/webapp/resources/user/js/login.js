function checkRegular() {
    var regulars;
    if (arguments[0] == 'adminname') {
        regulars = /^([\w\!\#$\%\&\'\*\+\-\/\=\?\^\`{\|\}\~]+\.)*[\w\!\#$\%\&\'\*\+\-\/\=\?\^\`{\|\}\~]+@((((([a-z0-9]{1}[a-z0-9\-]{0,62}[a-z0-9]{1})|[a-z])\.)+[a-z]{2,6})|(\d{1,3}\.){3}\d{1,3}(\:\d{1,5})?)$/i;
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
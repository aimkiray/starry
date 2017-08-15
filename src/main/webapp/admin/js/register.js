/**
 * Created by neko on 2017/6/6.
 */
var password = "";
var show = true;
function checkRegular(node) {
    var regulars = "";
    if(arguments[1] == 1){
        regulars = /^[\u4e00-\u9fa5]{1,6}$/;
    }
    if(arguments[1] == 2){
        regulars = /^\w{4,12}@[a-z|A-Z|0-9]{2,12}\.[a-z|A-Z|0-9]{2,3}(\.cn)?$/;
    }
    if(arguments[1] == 3){
        password = arguments[0].value;
        regulars = /^\w{6,12}$/;
    }
    if(arguments[1] == 4){
        checkPasswordAgain(arguments[0].value,arguments[0].parentNode.parentNode.lastElementChild)
    }
    if(regulars.test(arguments[0].value)){
        arguments[0].parentNode.parentNode.lastElementChild.innerHTML = "<span style='color: green'>&nbsp;&nbsp;OK</span>";
    }else{
        arguments[0].parentNode.parentNode.lastElementChild.innerHTML = "<span style='color: red'>&nbsp;&nbsp;有什么不对?</span>";
    }
}

function checkPasswordAgain() {
    var regulars = /^\w{6,12}$/;
    if(regulars.test(arguments[0]) && (arguments[0] == password) && (password != "")){
        arguments[1].innerHTML = "<font color='green'>&nbsp;&nbsp;Pass<font>";
    }else{
        arguments[1].innerHTML = "<font color='red'>&nbsp;&nbsp;有什么不对?<font>";
    }
}

// function showSuggest(node) {
//     var suggest = [
//         '@outlook.com',
//         '@foxmail.com',
//         '@gmail.com'
//     ];
//     if (show && (node.value.indexOf("@") != -1)) {
//         for (var i = 0; i <= suggest.length - 1; i++) {
//             var element = document.createElement("span");
//             // element.setAttribute("floor", "left");
//             element.setAttribute("class","suggest");
//             element.setAttribute("onclick","suggest("+i+")");
//             arguments[0].value = arguments[0].value + suggest[i];
//             // node.parentNode.setAttribute("display", "block");
//             element.innerHTML = "<br/>" + suggest[i];
//             node.parentNode.appendChild(element);
//             show = false;
//         }
//         show = false;
//     }
// }

// function suggest(num) {
//     var output = document.getElementById("inputMail");
//     var suggest = [
//         'outlook.com',
//         'foxmail.com',
//         'gmail.com'
//     ];
//     output.value = output.value + suggest[num];
// }

function showContinent() {
    var continents = [
        "亚洲",
        "欧萌",
        "北美洲"
    ];
    var continent = document.getElementById("continent");
    continent.innerHTML = "<option value='-1'>请选择</option>";
    for (var i = 0; i < continents.length; i++) {
        continent.add(new Option(continents[i],i));
    }
}

function showNational() {
    var nations = new Array();
    nations[0] = ["中国","日本","韩国"];
    nations[1] = ["英国","法国","德国"];
    nations[2] = ["美国","加拿大","百慕大"];
    var nation = document.getElementById("nation");
    var continent = arguments[0].value;
    var nations_array = nations[continent];
    nation.innerHTML = "<option value='-1'>请选择</option>";
    for (var i = 0; i < nations_array.length; i++) {
        nation.add(new Option(nations_array[i],nations_array[i]));
    }
}

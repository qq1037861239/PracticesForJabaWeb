function tipsView(className, indexOfEle, showText) {
    var tips = document.getElementsByClassName("reminBox");
    if (tips.length === 0) {
        var obj = document.getElementsByClassName(className)[indexOfEle];
        //创建元素
        var reminBox = document.createElement("div");
        var reminIcon = document.createElement("div");
        var reminText = document.createElement("div");
        //设置class
        reminBox.className = "reminBox";
        reminIcon.className = "reminIcon";
        reminText.className = "reminText";
        //设置从属关系
        obj.append(reminBox);
        reminBox.append(reminIcon);
        reminBox.append(reminText);
        //设置文本
        reminText.innerText = showText;
    }
}

function rmTips() {
    var eles = document.getElementsByClassName("reminBox");
    if (eles != null) {
        for (var i = 0; i < eles.length; i++) {
            eles.item(i).parentNode.removeChild(eles.item(i));
        }
    }
}

function autoRmTips(time) {
    setInterval(rmTips, time);
}

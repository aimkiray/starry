<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.title}</title>
    <c:set value="${pageContext.request.contextPath}" var="root"/>
    <link rel="stylesheet" href="${root}/admin/css/register.css" type="text/css">
    <script src="${root}/admin/js/register.js" type="/text/javascript"></script>
</head>
<body onload="showContinent()">
<form action="/admin/doregister.do" name="login" class="login-content" method="post">
<table class="login-table">
    <tr>
        <td class="title" colspan="5">某不为人知的交易界面</td>
    </tr>
    <tr>
        <td class="login-text"><span style="color: red;">*</span>君の名は:</td>
        <td colspan="2"><input name="adminName" type="text" onblur="checkRegular(this,1)"></td>
        <td colspan="2" class="login-prompt"><span style="color: #00FFFF">&nbsp;用户名</span></td>
    </tr>
    <tr>
        <td class="login-text">邮箱：</td>
        <td colspan="2">
            <input name="adminEmail" type="text" onblur="checkRegular(this,2)" id="inputMail">
        </td>
        <td colspan="2" class="login-prompt"></td>
    </tr>
    <tr>
        <td class="login-text"><span style="color: red;">*</span>密码：</td>
        <td colspan="2"><input type="text" onblur="checkRegular(this,3)"></td>
        <td colspan="2" class="login-prompt"></td>
    </tr>
    <tr>
        <td class="login-text"><span style="color: red;">*</span>确认密码：</td>
        <td colspan="2"><input name="adminPassword" type="text" onblur="checkRegular(this,4)"></td>
        <td colspan="2" class="login-prompt"></td>
    </tr>
    <tr>
        <td class="login-text">种族：</td>
        <td colspan="2"><input type="text" onblur="checkRegular(this,1)"></td>
        <td colspan="2" class="login-prompt"><span style="color: #00FFFF">&nbsp;精灵，萌狼，恶魔...</span></td>
    </tr>
    <!--<tr>-->
        <!--<td class="login-text">国籍：</td>-->
        <!--<td colspan="2"><input type="text" onblur="checkRegular(this,1)"></td>-->
        <!--<td colspan="2" class="login-prompt"><span style="color: #00FFFF">&nbsp;中国，欧萌...</span></td>-->
    <!--</tr>-->
    <tr>
        <td class="login-text">パンツ颜色？</td>
        <td colspan="2"><input type="text" onblur="checkRegular(this,1)"></td>
        <td colspan="2" class="login-prompt"><span style="color: #00FFFF">&nbsp;蓝白，白，不存在...</span></td>
    </tr>
    <tr>
        <td class="login-text">进化阶段：</td>
        <td colspan="2"><input type="text" onblur="checkRegular(this,1)"></td>
        <td colspan="2" class="login-prompt"><span style="color: #00FFFF">&nbsp;伪娘，长者...</span></td>
    </tr>
    <tr>
        <td class="login-text">出生日期：</td>
        <td colspan="4">
            <input class="selects" type="text" size="1" maxlength="4" name="year"><span>&nbsp;&nbsp;年&nbsp;&nbsp;</span>
            <select name="month">
            <option>请选择月份</option>
            <option value="Jan">一月</option>
            <option value="Feb">二月</option>
            <option value="Mar">三月</option>
            <option value="Apr">四月</option>
            </select>&nbsp;&nbsp;
            <input class="selects" type="text" size="1" maxlength="2" name="day"><span>&nbsp;&nbsp;日</span>
        </td>
        <td></td>
    </tr>
    <tr>
        <td class="login-text">出生地：</td>
        <td colspan="4">
            <select id="continent" name="continent" onchange="showNational(this)">
                <option value="-1">请选择</option>
            </select>
            <select id="nation" name="nation">
                <option value="-1">请选择</option>
            </select>
        </td>
        <td></td>
    </tr>
    <tr>
        <td class="login-text"><span style="color: red;">*</span>性别：</td>
        <td>
            <input type="radio" name="gender" value="girl">女
        </td>
        <td>
            <input type="radio" name="gender" value="boy">男
        </td>
        <td>
            <input type="radio" name="gender" value="fake_girl">秀吉
        </td>
        <td></td>
    </tr>
    <tr>
        <td class="login-text">爱好：</td>
        <td>
            <input type="radio" name="hobby" value="eat">吃饭
        </td>
        <td>
            <input type="radio" name="hobby" value="sleep">睡觉
        </td>
        <td></td>
    </tr>
    <tr>
        <td colspan="5"><span style="color: #00FFFF">&nbsp;准备好献上灵魂了吗（加*号为必填）？</span></td>
    </tr>
    <tr>
        <td colspan="5" class="bottom-buttons">
            <a href="javascript:document.login.submit()">确认</a>
            <a href="javascript:document.login.reset()">清空</a>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<div class="white-wrapper"><img class="circle-profile"
                                src="/resources/headimg/${boss.headshot}">
    <p class="site-description">${boss.userInfo}</p>
    <div class="grey-rule"></div>
    <ul>
        <li><a href="${root}/" target="_self">主页</a></li>

        <li><a href="${root}/user/login/page" target="_self">管理</a></li>

        <li><a href="${root}/resume" target="_self">关于我</a></li>
    </ul>
    <div class="grey-rule"></div>
    <div class="social-link-group">
        <a class="social-icon-link"
           href="https://github.com/${boss.userName}" target="_blank">
            <i class="fa fa-github fa-2x"></i>
        </a>
        <a class="social-icon-link"
           href="mailto:${boss.email}" target="_blank">
            <i class="fa fa-envelope fa-2x"></i>
        </a>
        <a class="social-icon-link"
           href="https://t.me/${boss.userName}" target="_blank">
            <i class="fa fa-telegram fa-2x"></i>
        </a>
        <a class="social-icon-link"
           href="tencent://message/?uin=1127076792" target="_blank">
            <i class="fa fa-qq fa-2x"></i>
        </a>
    </div>
    <#--版权信息-->
    <p class="copyright-text">
        licensed under the <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="cc" style="border-width:0;opacity: 0.6" src="https://i.creativecommons.org/l/by-nc-sa/4.0/80x15.png" /></a>
        <br/>
        site design/powered ☆
        <a target="_blank" href="https://github.com/aimkiray/starry"
           class="text-link">starry</a>
    </p>
</div>
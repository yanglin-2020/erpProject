"use strict";
layui.use(["okUtils", "table", "okCountUp", "okMock"], function () {
    var countUp = layui.okCountUp;
    var table = layui.table;
    var okUtils = layui.okUtils;
    var okMock = layui.okMock;
    var $ = layui.jquery;
    okLoading.close();
    /**
     * 收入、商品、博客、用户
     */
    function statText() {
        var elem_nums = $("#stat-text");
        elem_nums.each(function (i, j) {
            var ran = parseInt(Math.random() * 99 + 1);
            !new countUp({
                target: j,
                endVal: 20 * ran
            }).start();
        });
    }

    

    

    /**
     * 所有用户
     */
    function userList() {
        table.render({
            method: "get",
            url:  "/getUserLoginInfo",
            elem: '#userData',
            height: 300,
            page: true,
            limit: 10,
            cols: [[
            	 {field: "u_name", title: "账号", width: 80},
                 {field: "phone", title: "手机号", width: 130},
                 {field: "login_time", title: "登录时间", width: 166},
                 {field: "login_address", title: "登录地点", width: 120},
                 {field: "login_num", title: "登录次数", width: 100}
            ]],
        });
    }
    //首页公告
    function gonggao() {
        table.render({
            method: "get",
            url:  "/getGongGaoInfo",
            elem: '#gonggaolist',
            height: 300,
            page: true,
            limit: 10,
            cols: [[
            	 {field: "id", title: "ID", width: 80},
                 {field: "title", title: "标题", width: 130},
                 {field: "content", title: "发布的内容", width: 337},
                 {field: "time", title: "发布的时间", width: 160},
                 {field: "name", title: "发布人", width: 100}
            ]],
        });
    }
    //库存预警
    function kucunyj() {
        table.render({
            method: "get",
            url:  "/getyjInfo",
            elem: '#kucunyjlist',
            height: 300,
            page: true,
            limit: 10,
            cols: [[
            	 {field: "store_id", title: "库存ID", width: 160},
            	 {field: "product_id", title: "产品ID", width: 120},
                 {field: "product_name", title: "产品名称", width: 130},
                 {field: "amount", title: "当前储存", width: 100},
                 {field: "max_amount", title: "上限", width: 80},
                 {field: "min_amount", title: "下限", width: 80},
                 {field: "max_capacity_amount", title: "最大储存量", width: 120}
            ]],
        });
    }
    statText();
    userList();
    gonggao();
    kucunyj();
});



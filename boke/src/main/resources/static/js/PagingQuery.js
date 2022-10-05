//分页查询的带条件与不带条件

//不带条件
//实现不带条件的分页查询
function Randompage(Page,state) {
    console.log("不带条件的分页查询,状态："+state);
        //判断跳转的是否为上一页页面
        if (state==1){
            //判断为上一页
            if (Page!=1){
                Page=Page-1
            }
            //判断为上一页的查询
            page(Page);
        }
        //判断为首页或者尾页
         page(Page);
}
//下一页的判断
function underpage(Page,under) {
    console.log("下一页");
    if (Page!=under){
        Page=Page+1
    }
    console.log("不带条件的分页查询page=:"+Page);
    //判断为默认的查询
    page(Page);
}

function page(pa) {
    //ajax查询
    $.ajax({
        type : "get",
        url : "/plan/pclassSelects?pn=" + pa,
        success : function(data) {
            if (data) {
                toreload('planman/pclass_select');
            } else {
                alert("跳转失败")
            }
        }
    })
}
//跳转到录入采购需求页面
function EntrySkip() {
    var strSel="";
    $("[name='p_orderno']:checked").each(function(index, element) {
        strSel += $(this).val() + ",";
    });
    console.log("选中的值："+strSel);
    if (strSel!=""){
        $.ajax({
            type : "get",
            url : "/plan/EntryPageSkip?str=" + strSel,
            success : function(data) {
                if (data) {
                    toreload('planman/Order_newform');
                } else {
                    alert("跳转失败")
                }
            }
        })
    } else if (strSel==""){
    alert("请至少选中一个值");
    }
}
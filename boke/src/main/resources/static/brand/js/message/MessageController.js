//初始化分页组件
Vue.component('paginate',VuejsPaginate);
//初始化Vue对象
var CommentController = new Vue({
    el: "#wrapper",
    data: {
        src: '',
        search: '',
        total: 0,
        messageRey:0,
        messageReyName:'发表评论',
        messagereplyname:"",
        bokeComment:[],
        tokes:{         //当前toke的存储
            toke: null
        },
        searchParam : {
            pageNum : 1,
            pageSize : 6 //每页条数
        },
        dialogVisible: false
    },
    created() {
        const token =document.cookie;  //localStorage.getItem("user-Token");
        if(token.length>10) { //判断是否有Token
            this.tokes.toke = token;
        }
        let id = getUrlParamValue('id');
        //查询评论区评论信息
        this.BokeComet();
    },
    methods: {
        showImg(id) {
            //显示二维码
            document.getElementById(id).style.display='block';
        },
        hideImg(id) {
            document.getElementById(id).style.display='none';
        },
        BokeComet() {
            var self = this;
            axios.get("/boke/Comment/blogCommentmessage",{params:self.searchParam}).then(function (res) {
                console.log("评论信息");
                console.log(res);
                self.bokeComment =res.data.list;
                //设置总数量
                self.total =Math.ceil(res.data.total/self.searchParam.pageSize);
                console.log(self.bokeComment);
            })
        },
        messageReplyid(id,name){//回复人id设置
            var self = this;
            self.messageRey=id;
            self.showImg('cancel-comment-reply-link');
            self.messageReyName="@："+name;
            self.messagereplyname=name;
        },
        cancelReplyid(){//回复人取消
            var self = this;
            self.messageRey=0;
            self.hideImg('cancel-comment-reply-link');
            self.hideImg('hint');
            self.messageReyName="发表评论";
        },
        commentrelease() {//发表评论
            console.log("进入表单验证")
            var author = document.getElementById("author").value;
            if (!author) {
                return false;
            }
            var email = document.getElementById("email").value;
            if (!email) {
                return false;
            }
            return true;
        },
        finByBlogsearch(){
            var sear = document.getElementById("keyword").value;
            window.location.href="/search?search="+sear;
        }
    }
});
/**
 * 获取url参数
 * @param name
 * @returns {string|null}
 */
function getUrlParamValue(name) {
    if (name == null || name === 'undefined') {
        return '';
    }
    let searchStr = decodeURI(location.search);
    let infoIndex = searchStr.indexOf(name + "=");
    if (infoIndex === -1) {
        return '';
    }
    let searchInfo = searchStr.substring(infoIndex + name.length + 1);
    let tagIndex = searchInfo.indexOf("&");
    if (tagIndex !== -1) {
        searchInfo = searchInfo.substring(0, tagIndex);
    }
    return searchInfo;
}
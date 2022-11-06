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
        bokeArchive:[],
        tokes:{         //当前toke的存储
            toke: null
        },
        searchParam : {
            pageNum : 1,
            pageSize : 5, //每页条数
            ids:''
        },
        dialogVisible: false
    },
    created() {
        const token =document.cookie;// localStorage.getItem("user-Token");
        if(token.length>10) { //判断是否有Token
            this.tokes.toke = token;
        }
        //查询个人介绍
        this.Archive();
    },
    methods: {
        Archive() {
            var self = this;
            axios.get("/authorblog/Authormessage").then(function (res) {
                console.log(res)
                $('#view-notice-body').html(res.data);
            })
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
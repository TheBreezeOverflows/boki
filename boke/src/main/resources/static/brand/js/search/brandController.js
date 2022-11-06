//初始化分页组件
Vue.component('paginate',VuejsPaginate);

// 添加请求拦截器
// axios.interceptors.request.use(function (config) {
//     // 在发送请求之前做些什么
//     //2、将token添加入头部
//     if (window.localStorage['user-Token']) {
//         //如果vuex中存储有用户token,就把token传给后端
//         config.headers['baitoken'] = window.localStorage['user-Token'];
//     }
//     return config;
// }, function (error) {
//     // 对请求错误做些什么
//     return Promise.reject(error);
// });

//初始化Vue对象
var brandController = new Vue({
    el:"#brandView",
    data:{//属性
        basePath:"/userPage",
        userinfodata : {},   //用户信息内容
        classifybase:[],    //用户技术栏
        ids:[],//指定删除的id列表
        pageCount:0,//总页数
        searchParam : {
            id:1,
            lab:0,
            pageNum : 1,
            pageSize : 4, //每页条数
            keyword : null
        },
        searchResult : {        //文章内容
            total : 0,
            list : []
        },
        tokes:{         //当前toke的存储
            toke: null
        }
    },
    created(){//页面加载就运行
        //调用查询方法
        this.findUser();
    },
    methods:{//方法
        findUser(){
            var self = this;
            self.findByuserId();
            var sear= getUrlParamValue('search');
            if (sear){
                self.searchParam.keyword=sear;
            }
            self.findPage();
            // 判断是否存在token，如果存在的话，则每个http header都加上token
        },
        findByuserId(){     //查询用户信息，查看localStorage是否存储有用户信息Token有则将Token放入请求头中请求没有则直接用Boss账户
           var self = this;
            const token =document.cookie; //localStorage.getItem("user-Token");
                if (token.length>10){
                    self.tokes.toke=token;
                }
                axios.get('/user/info').then(function (res) {
                    self.userinfodata = res.data;
                    self.userinfodata.userRelevance=self.userinfodata.userRelevance;
                    //加载技术栏
                    axios.get('/classif/base').then(function (res) {
                        self.classifybase = res.data;
                    })
                })
        },
        findPage(){//查询文章，异步请求
            var self = this;
            console.log("查询的为"+self.searchParam.keyword)
            //get请求参数才要加params关键字，其它请求不需要
            axios.get(this.basePath,{params:self.searchParam}).then(function (res) {
                self.searchResult = res.data;
                //设置总页数
                self.pageCount = Math.ceil(res.data.total/self.searchParam.pageSize);
                console.log("查询的为"+self.searchParam.keyword)
            })
        },
        finByBlogClassID(ids,lab){
            var self = this;
            //判断是否是用标签点击进入的查询
            self.searchParam.lab=lab;
            self.searchParam.id=ids;
            self.basePath="classPage";
            //get请求参数才要加params关键字，其它请求不需要
            axios.get(self.basePath,{params:self.searchParam}).then(function (res) {
                console.debug(res);
                self.searchResult = res.data;
                //设置总页数
                self.pageCount = Math.ceil(res.data.total/self.searchParam.pageSize);
                self.searchParam.lab=0;
                self.searchParam.pageNum=1;
            })

        },
        findendtoken(){//查询文章，异步请求
            var self = this;
            //get请求参数才要加params关键字，其它请求不需要
            axios.get(this.basePath).then(function (res) {
                console.debug(res);
                self.searchResult = res.data;
                //设置总页数
                self.pageCount = Math.ceil(res.data.total/self.searchParam.pageSize);
            })
        },fsubmit(){
             //将token与路径拼接，后台更改获取token的方式
             location.href='end/frame';
        },
        finByBlogsearch(){
            var sear = document.getElementById("keyword").value;
            this.searchParam.keyword=sear;
            this.findPage();
            this.searchParam.pageNum=1;
        },
        finBlogsearch(){
            var sear = document.getElementById("keywordblog").value;
            this.searchParam.keyword=sear;
            this.findPage();
            this.searchParam.pageNum=1;
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
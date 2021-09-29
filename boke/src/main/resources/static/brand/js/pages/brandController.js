//初始化分页组件
Vue.component('paginate',VuejsPaginate);
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
            pageNum : 1,
            pageSize : 4 //每页条数
        },
        searchResult : {        //文章内容
            total : 0,
            list : []
        }
    },
    created(){//页面加载就运行
        //调用查询方法
        this.findPage();
        this.findByuserId();
    },
    methods:{//方法
        findPage(){//查询文章，异步请求
            var self = this;
            //get请求参数才要加params关键字，其它请求不需要
            axios.get(this.basePath,{params:self.searchParam}).then(function (res) {
                console.debug(res);
                self.searchResult = res.data;
                //设置总页数
                self.pageCount = Math.ceil(res.data.total/self.searchParam.pageSize);
            })
        },
        findByuserId(){     //查询用户信息，查看localStorage是否存储有用户信息Token有则将Token放入请求头中请求没有则直接用Boss账户
            var self = this;
            if(localStorage.getItem("user-Token") != null){ //判断是否有Token
                axios.get({
                    method:'get',
                    url: '',
                    headers: {
                        'token':window.localStorage['user-Token']
                    }
                })
            }else{
                //获取默认boss账户信息
                axios.get('/user/infos').then(function (res) {
                    self.userinfodata = res.data;
                    self.userinfodata.userRelevance=JSON.parse(self.userinfodata.userRelevance);
                })

                axios.get('/classif/base').then(function (res) {
                    console.debug("技术栏加载完毕");
                    console.debug(res);
                    self.classifybase = res.data;
                })
            }
        },
        finByBlogClassID(ids){
            var self = this;
            if(localStorage.getItem("user-Token") != null){ //判断是否有Token
                axios.get({
                    method:'get',
                    url: '',
                    headers: {
                        'token':window.localStorage['user-Token']
                    }
                })
            }else{
                self.searchParam.id=ids;
                self.basePath="classPage";
            //get请求参数才要加params关键字，其它请求不需要
            axios.get(self.basePath,{params:self.searchParam}).then(function (res) {
                console.debug(res);
                self.searchResult = res.data;
                //设置总页数
                self.pageCount = Math.ceil(res.data.total/self.searchParam.pageSize);
            })
           }
        }
    }
});
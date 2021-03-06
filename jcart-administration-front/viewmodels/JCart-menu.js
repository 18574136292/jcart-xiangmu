var app = new Vue({
    router:router,
    el: '#app',
    data: {
        subMenus:[
            {
                name:'商品管理',
                index:'1',
                icon:'el-icon-goods',
                menuItems:[
                    {
                        name:'商品列表',
                        index:'1-1',
                        route:'/product/pageSearch'
                    }
                ]
            },
            {
                name:'订单管理',
                index:'2',
                icon:'el-icon-order',
                menuItems:[
                    {
                        name:'订单列表',
                        index:'2-1',
                        route:'/order/pageSearch'
                    },
                    {
                        name:'退货列表',
                        index:'2-2',
                        route:'/return/pageSearch'
                    }
                ]
            },
            {
                name:'客户管理',
                index:'3',
                icon:'el-icon-customer',
                menuItems:[
                    {
                        name:'客户列表',
                        index:'3-1',
                        route:'/customer/pageSearch'
                    }
                ]
            },
            {
                name:'admin管理',
                index:'4',
                icon:'el-icon-admin',
                menuItems:[
                    {
                        name:'admin列表',
                        index:'4-1',
                        route:'/admin/getList'
                    }
                ]
            }
        ]
    },
    methods:{

    }
})
const routes = [
    {path:'/product/pageSearch',component:ProductSearch},
    {path:'/product/update/:productId',component:ProductUpdate},
    {path:'/product/create',component:ProductCreate},
    {path:'/order/pageSearch',component:OrderSearch},
    {path:'/order/getById/:orderId',component:OrderShow,
        children:[
            {path:'/orderHistory/getListByOrderId/:orderId',component:OrderShow},
            {path:'/orderHistory/create',component:OrderShow}
        ]
    },
    {path:'/admin/getList',component:AdminSearch},
    {path:'/admin/create',component:AdminCreate}
];

const router = new VueRouter({
    routes:routes
});
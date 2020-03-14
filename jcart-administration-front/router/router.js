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
    {path:'/return/pageSearch',component:ReturnSearch},
    {path:'/return/getById/:returnId',component:ReturnShow},
    {path:'/returnHistory/getListByReturnId/:returnId',component:ReturnHistorySearch},
    {path:'/admin/getList',component:AdminSearch},
    {path:'/admin/create',component:AdminCreate},
    {path:'/customer/pageSearch',component:CustomerSearch},
    {path:'/customer/getById/:customerId',component:CustomerShow},
    {path:'/address/getListByCustomerId/:customerId',component:AddressSearch},
    {path:'/address/getById/:addressId',component:AddressShow}
];

const router = new VueRouter({
    routes:routes
});
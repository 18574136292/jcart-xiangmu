const routes = [
    {path:'/product/pageSearch',component:ProductSearch},
    {path:'/product/update/:productId',component:ProductUpdate},
    {path:'/product/create',component:ProductCreate},
    {path:'/order/pageSearch',component:OrderSearch },
];

const router = new VueRouter({
    routes:routes
});
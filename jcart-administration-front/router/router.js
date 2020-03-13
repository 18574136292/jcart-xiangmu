const routes = [
    {path:'/product/pageSearch',component:ProductSearch},
    {path:'/order/pageSearch',component:OrderSearch },
];

const router = new VueRouter({
    routes:routes
});
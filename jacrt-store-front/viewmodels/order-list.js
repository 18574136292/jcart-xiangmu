var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('get list');
        this.getMyOrders();
    },
    methods:{
        handlePageChange(Value) {
            console.log('page change click',value);
            this.pageNum = value;
            this.getMyOrders();
        },
        getMyOrders(){
            axios.get('/order/getList',{
                params:{
                    pageNum:this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})
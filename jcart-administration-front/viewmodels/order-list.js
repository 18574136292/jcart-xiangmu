var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('order list');
        this.selectOrder();
    },
    methods:{
        handlePageChange(){
            console.log('page change',value);
            this.pageNum = value;
            this.selectOrder();
        },
        selectOrder(){
            axios.get('/order/pageSearch',{
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
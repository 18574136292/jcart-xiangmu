var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('list');
        this.searchProduct();
    },
    methods:{
        searchProduct(){
            axios.get('/product/search',{
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
        },
        handlePageChange(Value) {
            console.log('page change', value);
            this.pageNum = value;
            this.searchProduct();
        }
    }
})
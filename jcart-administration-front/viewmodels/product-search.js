var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        this.searchProduct();
    },
    methods:{
        handlePageChange(value){
            this.pageNum=value;
            this.searchProduct();
        },
        searchProduct(){
            axios.get('product/pageSearch',{
                params:{
                    pageNum:this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo=response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})
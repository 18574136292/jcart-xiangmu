var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('get return list');
        this.getReturnList();
    },
    methods:{
        handlePageChange(value){
            console.log('page change click',value);
            this.pageNum= value;
        },
        getReturnList(){
            axios.get('/return/getList',{
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
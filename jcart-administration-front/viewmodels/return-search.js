var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('get return list');
        this.pageSearchReturn();
    },
    methods:{
        handlePageChange(value) {
            console.log('page change click', value);
            this.pageNum = value;
            this.pageSearchReturn();
        },
        pageSearchReturn(){
            axios.get('/return/pageSearch',{
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
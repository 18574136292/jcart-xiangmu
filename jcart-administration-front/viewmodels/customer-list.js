var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1,
        statuses:[
            {value:0,label:'禁用'},
            {value:1,label:'启用'},
            {value:2,label:'不安全'}
        ]
    },
    mounted(){
        console.log('customer list');
        this.pageSearchCustomer();
    },
    methods:{
        handlePageChange(value){
            console.log('page change ',value);
            this.pageNum = value;
            this.pageSearchCustomer();
        },
        handleUpdateClick(index,row){
            console.log('update status click');
            this.updateCustomerStatus(row.customerId,row.status);
        },
        pageSearchCustomer(){
            axios.get('/customer/pageSearch',{
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
        updateCustomerStatus(customerId,status){
            axios.post('/customer/setStatus',{
                customerId:customerId,
                status:status
            })
                .then(function (response) {
                    console.log(response);
                    alert('状态更新成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('状态更新失败');
                })
        }
    }
})
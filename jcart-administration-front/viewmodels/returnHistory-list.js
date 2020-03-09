var app = new Vue({
    el: '#app',
    data: {
        returnId:'',
        returnHistories:[],
        selectedReturnStatus:'',
        returnStatuses:[
            {value:0,label:'带取货'},
            {value:1,label:'正在处理'},
            {value:2,label:'完成'},
            {value:3,label:'拒绝'}
        ],
        customerNotified:false,
        comment:''
    },
    mounted(){
        console.log('get returnId');
        var url = new URL(location.href);
        this.returnId = url.searchParams.get('returnId');
        if(!this.returnId){
            alert('returnId is null');
            return;
        }
        this.getReturnHistoryByReturnId();
    },
    methods:{
        handleCreateClick(){
            console.log('create click');
            this.createReturnHistory();
        },
        createReturnHistory(){
            axios.post('/returnHistory/create',{
                returnId:this.returnId,
                returnStatus:this.selectedReturnStatus,
                customerNotified:this.customerNotified,
                comment:this.comment
            })
                .then(function (response) {
                    console.log(response);
                    alert('创建成功');
                    app.selectedReturnStatus = '';
                    app.customerNotified = false;
                    app.comment = '',
                    app.getReturnHistoryByReturnId();
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        getReturnHistoryByReturnId(){
            axios.get('/returnHistory/getListByReturnId',{
                params:{
                    returnId:this.returnId
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.returnHistories = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})
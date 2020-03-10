var app = new Vue({
    el: '#app',
    data: {
        email:''
    },
    methods:{
        handleFindBackPwdClick(){
            console.log('get pwd click');
            this.getPwdResetCode();
        },
        getPwdResetCode(){
            axios.get('/customer/getPwdResetCode',{
                params:{
                    email:this.email
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert('已发送邮箱');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('发送失败');
                })
        }
    }
})
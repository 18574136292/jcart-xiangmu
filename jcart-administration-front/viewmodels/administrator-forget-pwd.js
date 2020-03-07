var app = new Vue({
    el: '#app',
    data: {
        email:''
    },
    methods:{
        handleFindBackPwdClick(){
            console.log('find pwd click');
            this.getPwdResetCode();
        },
        getPwdResetCode(){
            axios.get('/admin/getPasswordResetCode',{
                params:{
                    email:this.email
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert('邮箱已发送')
                })
                .catch(function (error) {
                    console.log(error);
                    alert('邮箱发送失败');
                })
        }
    }
})
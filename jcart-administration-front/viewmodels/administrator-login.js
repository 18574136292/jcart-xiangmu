var app = new Vue({
    el: '#app',
    data: {
        username:'',
        password:''
    },
    methods:{
        handleLoginClick(){
            console.log('login click');
            this.administratorLogin();
        },
        administratorLogin(){
            axios.get('/admin/loginIn',{
                params:{
                    username:this.username,
                    password:this.password
                }
            })
                .then(function (response) {
                    console.log(response);
                    var dto = response.data;
                    localStorage['jcartToken'] = dto.token;
                    localStorage['expireTimestamp'] = dto.expireTimestamp;
                    alert('登陆成功');
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})